<template>
    <div class="home">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Film</th>
                <th scope="col">Time</th>
                <th scope="col">Hall</th>
                <th scope="col">Tickets</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="order in orders">
                <td>{{order.movie.name}}</td>
                <td>{{moment(order.screening.startTime).format("HH:mm Do MMMM")}}</td>
                <td>{{order.screeningHallName}}</td>
                <td>{{order.tickets.length}} <router-link :to="{ name: 'user-order', params: { orderID:order.orderNumber }}">View Tickets</router-link> </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

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
