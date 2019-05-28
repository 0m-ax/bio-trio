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
            <PayPal
                    amount="10.00"
                    currency="USD"
                    :client="credentials"
                    v-on:payment-authorized="paymentAuthed"
                    v-on:payment-completed="paymentComplete"
                    :invoice-number="$route.params.orderID.toString()+':'+Math.random()"
                    env="sandbox">
            </PayPal>
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
    import PayPal from 'vue-paypal-checkout'

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
                let resp = await api.get("orders/"+this.$route.params.orderID+"/pay?paypalOrderID="+"");
                await this.getOrder();
            },
            async paymentComplete(event){
                let resp = await api.get("orders/"+this.$route.params.orderID+"/pay?paypalOrderID="+event.cart);
                console.log(resp)
                await this.getOrder();
            },
            async paymentAuthed(event){
                console.log(event)
            }
        },
        components: {
            PayPal
        },
        data(){
            return {
                moment:moment,
                order:[],
                credentials: {
                    sandbox: 'AYi6ynH1fwYMY1XdyMOK0YK-QJsiRxFMueAO1Ck96X528D_deV2RwDIEIQ3Yf9r_TuVzQ-SZNXNv9j8B',
                }
            }
        }
    };
</script>
