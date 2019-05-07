<template>
    <!-- CAROUSEL-->
    <div class="bd-example">
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li div v-for="(item,index) in items"  data-target="#carouselExampleCaptions" v-bind:data-slide-to="index" v-bind:class="{ active: index==0 }"></li>
            </ol>
            <div class="carousel-inner bio-trio-carousel">
                <div v-for="(item,index) in items" class="carousel-item" v-bind:class="{ active: index==0 }" v-bind:style="{ 'background-image': 'url('+item.image+')','background-size': item.size,'background-color': item.color }">
                    <div class="carousel-caption">
                        <h5>{{item.title}}</h5>
                        <p>{{item.text}}</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</template>

<style lang="scss">

    .bio-trio-carousel{
        max-height: 720px;
        .carousel-item {
            height: 600px;
            background-position: center;
            background-repeat: no-repeat;
            background-color: black;
            background-size: cover;
        }
    }

</style>

<script>
export default {
    props: {
        items: {
            type: Array
        }
    },
    name: "Carousel"
};
</script>