<template>
    <div class="container">
        <AdminSidebar />
        <h1>{{movie.name}}</h1>
        <MovieForm v-on:submit="save()" v-model="movie"/>
    </div>
</template>

<script>
    import MovieForm from "./MovieForm";
    import client from "../../../api.js"
    import AdminSidebar from "../../../components/AdminSidebar"
    export default {
        components: {
            MovieForm,
            AdminSidebar
        },
        methods:{
            async save(){
                try {
                    let resp = await client.post("/movies/",this.movie);
                    this.$router.push({ name: 'admin-movie', params: { movieID:resp.data.movieID }})
                }catch (e) {
                    alert("error saving")
                }
            }
        },
        data(){
            return {
                movie:{}
            }
        },
        name: "Movie"
    };
</script>