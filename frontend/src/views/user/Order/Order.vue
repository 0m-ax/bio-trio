<template>
    <div class="order-page">
        <div class="spacing"></div>
        <img class="movie-banner" v-bind:src="order.movie.image">
        <div v-if="order.orderStatus.usable">
            <h1 class="movie-title">{{order.movie.name}}</h1>
            <div class="qr-code" v-for="ticket in order.tickets">
                <img  v-bind:src="'https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl='+ticket.ticketID">
            </div>
        </div>
        <div v-if="order.orderStatus.orderStatusID == 1">
            <button v-on:click="pay">Pay now</button>
        </div>
    </div>
</template>

<style>
    .spacing{
        padding: 40px;
    }
    .order-page{
        margin: auto;
        width: 60%;
    }

    .movie-banner{
        display: inline-block;
        max-width: 40%;
    }
    .movie-title{
        display: inline-block;
    }
    .qr-code{
        display: inline-block;
    }

</style>

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
            },
            async pay(){
                let resp = await api.get("orders/"+this.$route.params.orderID+"/pay");
                await this.getOrder();
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
