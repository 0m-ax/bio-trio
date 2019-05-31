<template>
    <div>
        <CarouselItemForm v-on:submit="save" v-model="items"/>

    </div>
</template>

<script>

    import CarouselItemForm from "./CarouselItemForm";
    import client from "../../../api.js"
    export default {

        components: {
            CarouselItemForm
        },

        methods:{
            async loadData(){
                let resp = await client.get("/carouselItems/"+this.$route.params.carouselItemID);
                this.items = resp.data;
                this.loading=false;
            },
            async save(){
                let resp = await client.put("/carouselItems/"+this.$route.params.carouselItemID,this.items);
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
        name: "CarouselItemEdit"
    };
</script>
