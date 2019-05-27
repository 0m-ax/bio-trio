<template>
    <div>
        <h1>{{items.name}}</h1>
        <MovieForm v-on:submit="save()" v-model="items"/>
    </div>
</template>

<script>

    import MovieForm from "./MovieForm";
    import client from "../../../api.js"
    export default {

        components: {
            MovieForm
        },

        methods:{
            async loadData(){
            },
            async save(){
                let resp = await client.post("/movies/",this.items);
                console.log(resp);
                this.$router.push({ name: 'admin-movie', params: { movieID:resp.data.movieID }})
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
        name: "Films"
    };
</script>