<template>
    <div class="Movie">
        <AdminSidebar />
        <router-link :to="{ name: 'admin-movie-add'}">Add Movie</router-link>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Length</th>
                <th scope="col">Genre</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="movie, i in items" v-bind:key="movie.id">
                    <th scope="row">{{movie.movieID}}</th>
                    <td>{{movie.name}}</td>
                    <td>{{movie.length}} minutes</td>
                    <td>{{movie.genre}}</td>
                    <td><router-link :to="{ name: 'admin-movie', params: { movieID:movie.movieID }}">Editto</router-link></td>
                    <td><button v-on:click="clicked(movie.movieID,i)">Deletto</button> </td>
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
                let resp = await client.get("/movies");
                this.items = resp.data._embedded.movies;
                this.loading=false;
                },
            async deleteRow(id,i){
                fetch("http://localhost:8080/api/movies/" + id, {method: "DELETE"})
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
                openMovie:null,
                loading:true,
                items:[

                ]
            }
        },
        name: "Films"
    };
</script>