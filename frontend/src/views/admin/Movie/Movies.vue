<template>
    <div class="Movie container">
        <AdminSidebar />
        <div class="Spacer"></div>
        <div class="movieBtn">
            <router-link class="routerBtn" :to="{ name: 'admin-movie-add'}">Add Movie</router-link>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th class="TableID" scope="col">ID</th>
                <th class="TableName" scope="col">Name</th>
                <th class="TableLength" scope="col">Length</th>
                <th class="TableGenre" scope="col">Genre</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="movie, i in items" v-bind:key="movie.id">
                    <th scope="row">{{movie.movieID}}</th>
                    <td>{{movie.name}}</td>
                    <td>{{movie.length}} minutes</td>
                    <td>{{movie.genre}}</td>
                    <td class="TableEdit"><router-link :to="{ name: 'admin-movie', params: { movieID:movie.movieID }}">Edit</router-link></td>
                    <td class="TableDelete"><button v-on:click="clicked(movie.movieID,i)">Delete</button> </td>
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
                let resp = await client.get("/movies");
                this.items = resp.data._embedded.movies;
                this.loading=false;
                },
            async deleteRow(id,i){
                let resp = await client.delete("http://localhost:8080/api/movies/"+id)
                this.items.splice(i,1);

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
                openMovie:null,
                loading:true,
                items:[

                ]
            }
        },
        name: "Films"
    };
</script>