<template>
<div class="container">
    <div class="row movies">
        <div v-for="movie in items" v-bind:key="movie.id" class="col-md-4 movie" v-bind:class="{noopen:openMovie!=movie.id}">
            <div class="card poster" v-on:click="open(movie.id)" v-bind:style="{backgroundImage:'url('+movie.image+')'}">
                <div class="card-img-overlay" >
                    <h5 class="card-title">{{movie.name}}</h5>
                </div>
            </div>
            <div v-bind:class="{ open: openMovie==movie.id }" v-bind:id="'moviecard'+movie.id" v-bind:ref="movie.id" class="info closed">
                <div class="connector"></div>
                <div class="full-width">
                    <div class="card">
                        <div class="card-body">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6 dec">
                                        <div class="embed-responsive embed-responsive-16by9">
                                            <iframe class="embed-responsive-item" :src="movie.video" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                        </div>
                                        <h2>{{movie.name}}</h2>
                                        {{movie.description}}
                                    </div>
                                    <div class="col-md-6" >
                                        <router-link v-for="time in movie.times" :to='"/screening/"+time.id' target="_blank" type="button" class="time btn btn-secondary">{{time.text}} </router-link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<style lang="scss">
    @import "../../node_modules/bootstrap/scss/mixins/_breakpoints";
    @import "../../node_modules/bootstrap/scss/functions";
    @import "../../node_modules/bootstrap/scss/variables";
    .movies {
        .movie.noopen{
            height: 150%;
        }
        .movie {

            margin-bottom: 15px;
            margin-top: 15px;
            .poster {
                background-position: center;
                background-size: cover;
                padding-bottom: 150%;
                text-align: center;
                border: 0px solid rgba(0,0,0,.125);
                cursor: pointer;
                .card-title{
                    bottom:-0.75rem;
                    position: absolute;
                    width: 100%;
                    margin-left: -1.25rem;
                    background-color: rgba(0,0,0,0.5);
                    padding-bottom: 0.75rem;
                    padding-top: 0.75rem;
                    color: white;
                }
            }
            .closed {
                max-height: 0px;
                transform:scaleY(0);
            }
            .open{
                max-height: 1000px;
                transform:scaleY(1);
            }
            .info{
                transform-origin: top;
                transition:transform 0.2s,max-height 0.2s;
                .card-body{
                    background-color: #131f27;
                }
                .connector{
                    position: absolute;
                    background-color: #131f27;
                    height: 16px;
                    top:-15px;
                    width: 100%;
                    border-left: 1px solid rgba(0,0,0,.125);
                    border-right: 1px solid rgba(0,0,0,.125);
                    z-index: 10;
                }
                .full-width{
                    margin-top: 15px;
                    width: 100%;
                    .dec{
                        border-bottom: 1px solid rgba(0,0,0,.125);
                    }
                    .time{
                        margin: 8px;
                    }
                }
            }
        }
        @include media-breakpoint-up(md) {
            .movie {
                .info {
                    .full-width{
                        .dec{
                            border-right: 1px solid rgba(0,0,0,.125);
                            border-bottom: none;
                        }
                        width: calc(300% + 15px * 4);
                    }
                }
            }
            .movie:nth-child(3n+0) {
                .info {
                    .full-width{
                        margin-left: calc(-200% - 15px * 4);
                    }
                }
            }
            .movie:nth-child(3n-1) {
                .info {
                    .full-width{
                        margin-left: calc(-100% - 15px * 2);
                    }
                }
            }
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
        methods:{
            open(movie){
                if(this.openMovie == movie ){
                    this.openMovie = null;
                }else{
                    this.openMovie = movie;
                    let movieEl = this.$refs[movie][0];
                    setTimeout(()=>movieEl.scrollIntoView({behavior:"smooth"}),200)
                }
            }
        },
        data(){
            return {
                openMovie:null
            }
        },
        name: "Films"
    };
</script>