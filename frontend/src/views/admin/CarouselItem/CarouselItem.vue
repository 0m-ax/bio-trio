<template>
    <div class="CarouselItem container">
        <AdminSidebar />
        <div class="Spacer"></div>
        <div class="movieBtn">
            <router-link class="routerBtn" :to="{ name: 'admin-carousel-item-add'}">Add Carousel Item</router-link>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th class="TableID" scope="col">ID</th>
                <th class="TableTitle" scope="col">Title</th>
                <th class="TableText" scope="col">Text</th>
                <th class="TableEdit" scope="col">Edit</th>
                <th class="TableDelete" scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="carouselItem , i in items" v-bind:key="carouselItem.carouselItemID">
                    <th scope="row">{{carouselItem.carouselItemID}}</th>
                    <td>{{carouselItem.title}}</td>
                    <td>{{carouselItem.text}}</td>
                    <td class="TableEdit"><router-link :to="{ name: 'admin-carousel-item-edit', params: { carouselItemID:carouselItem.carouselItemID }}">Edit</router-link></td>
                    <td class="TableDelete"><button v-on:click="clicked(carouselItem.carouselItemID,i)">Delete</button> </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style>
    .routerBtn {
        display: inline-block;
        border: solid 1px white;
        padding: 10px;
        background-color: white;
        color: #383838;
        margin-bottom: 20px;
    }
    .routerBtn:hover{
        text-decoration: none;
        background-color: #dbdbdb;
        color: black;
    }
    .Spacer{
        padding-bottom: 20px;
    }
    .TableID{
        width: 3%;
    }
    .TableName{
        width: 40%;
    }
    .TableLength{
        width: 10%;
    }
    .TableGenre{
        width: 10%;
    }
    .TableEdit{
        width: 4%;
    }
    .TableDelete{
        width: 2%;
    }
    /*
    .movieBtn{
        padding-top: 5px;
        padding-bottom: 10px;
        color: black;
        text-decoration: none;
        width: 120px;
        height: 30px;
        background-color: grey;
        text-align: center;
        margin-bottom: 15px;
    }
    .movieBtn a{
        color: black;
        text-decoration: none;
        padding-left: 20px;
        padding-right: 20px;
        padding-bottom: 10px;

    }
    .movieBtn a:hover{
        color: #232323;
        background-color: white;
    }
    */
    .Movie{
    margin-left: 400px;
    width: 60%;
}

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
                let resp = await client.get("/carouselItems");
                this.items = resp.data._embedded.carouselItems;
                this.loading=false;
                },
            async deleteRow(id,i){
                fetch("http://localhost:8080/api/carouselItems/" + id, {method: "DELETE"})
                    .then(() =>{
                    this.items.splice(i,1);
                    })
                },
            clicked(id,i){
                if(confirm("Are you sure you want to delete?")){
                    this.deleteRow(id,i);
                }
                else return false;
            }
        },
        created(){
          this.loadData()
        },
        data(){
            return {
                loading:true,
                items:[

                ]
            }
        },
        name: "CarouselItems"
    };
</script>