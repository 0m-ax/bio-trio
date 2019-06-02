<template>
    <div class="Movies container page">
        <AdminSidebar />
        <div class="movieBtn">
            <router-link class="btn btn-primary"  :to="{ name: 'admin-movie-add'}">Add Movie</router-link>
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
                    <td class="TableEdit"><router-link class="btn btn-primary" :to="{ name: 'admin-movie', params: { movieID:movie.movieID }}">Edit</router-link></td>
                    <td class="TableDelete"><button class="btn btn-primary" v-on:click="deleteRow(movie.movieID,i)">Delete</button> </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style>
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
    .Movies{
        padding-top: 15px;
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
                let resp = await client.get("/movies");
                this.items = resp.data._embedded.movies;
            },

            async deleteRow(id,i){
                if(confirm("Are you sure you want to delete?")){
                    let resp = await client.delete("http://localhost:8080/api/movies/"+id)
                    this.items.splice(i,1);
                }
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
        name: "Movies"
    };
</script>