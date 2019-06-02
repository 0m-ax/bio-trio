<template>
    <div class="container">
        <AdminSidebar />
    <h1>{{items.name}}</h1>
        <MovieForm v-on:submit="save" v-model="items"/>
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
            async loadData(){
                let resp = await client.get("/movies/"+this.$route.params.movieID);
                this.items = resp.data;
            },
            async save(){
                let resp = await client.put("/movies/"+this.$route.params.movieID,this.items);
            }
        },
        created(){
            this.loadData()
        },
        data(){
            return {
                items:{}
            }
        },
        name: "MovieEdit"
    };
</script>
