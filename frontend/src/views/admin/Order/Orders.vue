<template>
    <div class="Order">
        <AdminSidebar />
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Order Number</th>
                <th scope="col">Order Status</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="order in items" v-bind:key="order.orderNumber">
                <th scope="row">{{order.orderNumber}}</th>
                <td>{{order.orderStatus.name}}</td>
                <td class="TableEdit">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Edit order status
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <button class="dropdown-item" v-on:click="save(1,order.orderNumber)">Awaiting Payment</button>
                            <button class="dropdown-item" v-on:click="save(2,order.orderNumber)">Paid</button>
                            <button class="dropdown-item" v-on:click="save(3,order.orderNumber)">Refunded</button>
                            <button class="dropdown-item" v-on:click="save(4,order.orderNumber)">Payment cancelled</button>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<style>

    

</style>

<script>

    import client from "../../../api.js"
    import AdminSidebar from "../../../components/AdminSidebar"
    export default {

        components:{
            AdminSidebar
        },
        methods:{
            async loadData(){
                let resp = await client.get("/orders?projection=OrderTicket");
                this.items = resp.data._embedded.orders
                this.loading=false;
            },
            async save(id,orderNumber){
                let resp = await client.put("/orders/"+orderNumber,{
                    "_links":{
                        "orderStatus":{
                            "href":"orderStatus/"+id
                        }
                    }
                });
            }
        },
        created(){
            this.loadData()
        },
        data(){
            return {
                items:[],

            }
        },
    };
</script>