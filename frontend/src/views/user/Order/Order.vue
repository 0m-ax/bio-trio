<template>
    <div class="container">
    <div class="row">
        <div class="col-md-4" >
            <img width="100%" class="movie-banner" v-bind:src="order.movie.image">
        </div>
        <div class="col-md-8" v-if="order.orderStatus.usable">

            <div>
                <h1 class="movie-title">{{order.movie.name}}</h1>
                <h3 class="movie-title">Order Number: {{$route.params.orderID}}</h3>
            </div>
            <div id="accordion">
                <div class="card"  v-for="ticket,id in order.tickets">
                    <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" v-bind:data-target="'#col'+id" aria-expanded="true" aria-controls="collapseOne">
                                Ticket {{id+1}}
                            </button>
                        </h5>
                    </div>

                    <div v-bind:id="'col'+id" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body" >
                            <img  v-bind:src="'https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl='+ticket.ticketID">
                         </div>
                    </div>
                </div>
            </div>

                <!--<div class="qr-codes" v-for="ticket in order.tickets">-->
                    <!--<div class="tickets-indiv">-->
                        <!--<img  v-bind:src="'https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl='+ticket.ticketID">-->
                    <!--</div>-->
                <!--</div>-->
        </div>
         <div class="col-md-8" v-if="order.orderStatus.orderStatusID == 1">
             <div>
                 <h1 class="movie-title">{{order.movie.name}}</h1>
                 <h3 class="movie-title">Order Number: {{$route.params.orderID}}</h3>
             </div>
            <ul>
                <li class="ticket-list" v-for="ticket in order.tickets">
                    {{ticket.cost/100}}kr
                </li>
            </ul>
            Total: {{(order.tickets.reduce((total,ticket)=>total+ticket.cost,0)/100)}}kr
            <PayPal
                    :amount="(order.tickets.reduce((total,ticket)=>total+ticket.cost,0)/100).toString()"
                    currency="DKK"
                    :client="credentials"
                    v-on:payment-authorized="paymentAuthed"
                    v-on:payment-completed="paymentComplete"
                    :invoice-number="$route.params.orderID.toString()+':'+Math.random()"
                    env="sandbox">
            </PayPal>
        </div>
    </div>
    </div>
</template>

<style>
    /*.ticket-codes{*/
        /*display: inline-block;*/
        /*width: 50%;*/
    /*}*/
    /*.ticket-list{*/
        /*border: solid 1px white;*/
        /*list-style: none;*/
        /*display: inline-block;*/
        /*margin: 10px;*/
    /*}*/
    /*.order-page{*/
        /*margin: auto;*/
        /*width: 60%;*/
    /*}*/

    /*.movie-image{*/
        /*width: 40%;*/
        /*margin-right: 30px;*/
        /*display: inline-block;*/
    /*}*/
    /*.movie-banner{*/
        /*=*/
        /*width: 100%;*/
    /*}*/
   .movie-title{
        text-align: center;

    }
   /* .qr-codes{
        display: inline-block;
    }*/

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
