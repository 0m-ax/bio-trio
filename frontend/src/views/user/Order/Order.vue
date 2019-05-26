<template>
    <div class="home">
        <h1>{{order.movie.name}}</h1>
        <img v-bind:src="order.movie.image">
        <div v-for="ticket in order.tickets">
            <img v-bind:src="'https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl='+ticket.ticketID">
        </div>
    </div>
</template>

<script>
    // @ is an alias to /src
    import moment from "moment";
    import api from "../../../api.js"
    export default {
        name: "user-order",
        created(){
            this.getOrder()
        },
        methods:{
            async getOrder(){
                let resp = await api.get("orders/"+this.$route.params.orderID+"?projection=OrderTicket")
                this.order = resp.data;
            }
        },
        data(){
            return {
                moment:moment,
                order:[]
            }
        }
    };
</script>
