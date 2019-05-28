<template>
    <div id="nav2">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary border border-dark rounded-sm">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <form class="form-inline mr-auto">
                        <label v-if="locations.length != 0" class="my-1 mr-2" for="location">Location: </label>
                        <select v-if="locations.length != 0" v-on:change="onChange()" class="form-control my-1 mr-sm-2" id="location">
                            <option v-for="location in locations" v-bind:value="location.name">{{location.text}}</option>
                        </select>
                        <label v-if="days.length != 0" class="my-1 mr-2" for="day">Day: </label>
                        <select v-if="days.length != 0" v-model="value.day" v-on:change="onChange()" class="form-control my-1 mr-sm-2" id="day">
                            <option v-for="day in days" v-bind:value="day.value">{{day.text}}</option>
                        </select>
                        <div v-if="value.thirdDimension != null" class="form-check form-check-inline">
                            <input class="form-check-input" v-on:change="onChange()" type="checkbox" id="3d" value="option1" v-model="value.thirdDimension">
                            <label class="form-check-label" for="3d">3D</label>
                        </div>
                        <div v-if="value.audioDescribed != null" class="form-check form-check-inline">
                            <input class="form-check-input" v-on:change="onChange()" type="checkbox" id="ad" value="option2" v-model="value.audioDescribed">
                            <label class="form-check-label" for="ad">AD</label>
                        </div>

                </form>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search">
                    <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</template>

<style lang="scss">
    #nav2{
        position: sticky;
        top:55px;
        z-index:1;
        
    }
</style>

<script>
    export default {
        name: "NavbarSticky",
        props: {
            value:{
                type:Object
            },
            locations:{
                type:Array,
                default(){
                    return []
                }
            },
            days:{
                type:Array,
                default(){
                    return []
                }
            }
        },
        methods:{
            onChange(){
                this.$emit('input', this.value)
            }
        },
        data(){
            return {
            }
        }
    };
</script>