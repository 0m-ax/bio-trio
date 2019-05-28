<template>
    <div>
        <h1>{{items.name}}</h1>
        <MovieForm v-on:submit="save" v-model="items"/>

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
                let resp = await client.get("/movies/"+this.$route.params.movieID);
                this.items = resp.data;
                this.loading=false;
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
        name: "Films"
    };
</script>
