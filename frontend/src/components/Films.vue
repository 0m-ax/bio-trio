<template>
<div class="container">
    <div class="row movies">
        <div v-for="movie in items" v-bind:key="movie.id" class="col-md-4 movie">
            <div class="card poster" v-on:click="open(movie.id)">
                <img :src="movie.image" class="card-img" alt="...">
                <div class="card-img-overlay" >
                    <h5 class="card-title">{{movie.name}}</h5>
                </div>
            </div>
            <div v-bind:class="{ open: openMovie==movie.id }" class="info closed">
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
                                        <button v-for="time in movie.times" type="button" class="time btn btn-secondary">{{time}}</button>
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
        .movie {
            margin-bottom: 15px;
            margin-top: 15px;
            .poster {
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
                .connector{
                    position: absolute;
                    background-color: white;
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
                this.openMovie=(movie==this.openMovie)?null:movie;
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