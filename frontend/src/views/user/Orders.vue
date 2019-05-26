<template>
    <div class="home">

    </div>
</template>

<script>
    // @ is an alias to /src
    import client from "../api.js"
    export default {
        name: "home",
        computed:{
            films(){
                return this.movies.map((movie)=>{
                    return {
                        times:movie.times.filter((time)=>{
                            return (this.mFilter.audioDescribed?time.audioDescribed:true)&&
                                (this.mFilter.thirdDimension?time.thirdDimension:true)
                        }),
                        name:movie.name,
                        video:movie.video,
                        image:movie.image,
                        description:movie.description,
                        id:movie.id,
                    }
                }).filter((movie)=>movie.times.length > 0)
                    .map((movie)=>{
                        movie.times = movie.times.map((time)=>time.time+(time.thirdDimension?" (3D)":"")+(time.audioDescribed?" (AD)":""));
                        return movie
                    })
            },
            getOrders(){
                this.api.get("orders/")
            }
        },

        data(){
            return {
                orders:[]
            }
        }
    };
</script>
