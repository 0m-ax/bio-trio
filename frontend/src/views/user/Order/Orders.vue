<template>
    <div class="home">
        <div class="title">Order list</div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Film</th>
                <th class="col-time" scope="col">Time</th>
                <th scope="col">Hall</th>
                <th >Status</th>
                <th class="col-tickets" scope="col">Tickets</th>
                <th class="col-tickets">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="order in orders">
                <td>{{order.movie.name}}</td>
                <td>{{moment(order.screening.startTime).format("HH:mm Do MMM")}}</td>
                <td>{{order.screeningHallName}}</td>
                <td>{{order.orderStatus.name}}</td>
                <td>{{order.tickets.length}}</td>
                <td><router-link :to="{ name: 'user-order', params: { orderID:order.orderNumber }}">View</router-link> </td>

            </tr>
            </tbody>
        </table>
    </div>
</template>

<style>
    .title{
        font-size: 30px;
        text-align: center;
        padding-top: 15px;
        padding-bottom: 10px;
    }
    .col-tickets{
        width: 170px;
    }
    .col-time{
        width: 140px;
    }
    .table{
        margin: auto;
        width: 70%;
    }

</style>

<script>
    // @ is an alias to /src
    import moment from "moment";
    import api from "../../../api.js"
    export default {
        name: "user-orders",
        created(){
            this.getOrders()
        },
        methods:{
          async getOrders(){
              let resp = await api.get("orders/search/findByCustomer?user=%2Fusers%2F"+this.$store.state.user.userID+"&projection=OrderTicket")
              this.orders = resp.data._embedded.orders;
          }
        },
        data(){
            return {
                moment:moment,
                orders:[]
            }
        }
    };
</script>
