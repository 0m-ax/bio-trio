<template>
    <div class="Order">
        <AdminSidebar />
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Order Number</th>
                <th scope="col">Order Status</th>
                <th scope="col">Customer ID</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="order in items" v-bind:key="movie.id">
                <th scope="row">{{order.orderNumber}}</th>
                <td>{{order.orderStatus}}</td>
                <td>{{order.customer.customerID}} minutes</td>
                <td><router-link :to="{ name: 'admin-order', params: { orderNumber:order.orderNumber }}">Editto</router-link></td>
                <td><a href="">Deletto</a> </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    import client from "../../../api.js"
    import AdminSidebar from "../../../components/AdminSidebar"
    export default {

        components:{
            AdminSidebar
        },
        methods:{
            async loadData(){
                let resp = await client.get("/orders");
                this.items = resp.data._embedded.orders
                this.loading=false;
            }
        },
        created(){
            this.loadData()
        },
        data(){
            return {
                items:[

                ]
            }
        },
        name: "Films"
    };
</script>