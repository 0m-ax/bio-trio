<template>
    <div class="container">
        <CarouselItemForm v-on:submit="save()" v-model="items"/>
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
            },
            async save(){
                let resp = await client.post("/carouselItems/",this.items);
                this.$router.push({ name: 'admin-carousel-item', params: { carouselItemID:resp.data.carouselItemID }})
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
        name: "CarouselItemAdd"
    };
</script>