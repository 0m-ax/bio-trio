<template>
    <div class="Movie">
        <AdminSidebar />
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
                <tr v-for="movie in items" v-bind:key="movie.id">
                    <th scope="row">{{movie.movieID}}</th>
                    <td>{{movie.name}}</td>
                    <td>{{movie.length}} minutes</td>
                    <td>{{movie.genre}}</td>
                    <td><router-link :to="{ name: 'admin-movie', params: { movieID:movie.movieID }}">Editto</router-link></td>
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
                let resp = await client.get("/movies");
                this.items = resp.data._embedded.movies
                this.loading=false;
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