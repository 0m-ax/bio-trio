<template>
    <div class="home">
        <NavbarSticky v-model="mFilter" :locations="locations" :days="days"/>
        <AdminSidebar />
        <div class="container">
            <div class="row">
                <div class="col-1 cal-col">
                    <div class="card-hold">
                        <div class="time" v-for="time in times">
                            <div class="time-hold">
                                {{time.text}}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 cal-col">
                    <div class="card-hold">
                        <div v-for="time in times" class="hr" v-on:dragover="allowDrop($event)" v-on:drop="drop($event,time.value)">
                        </div>
                        <div v-for="(screening,id) in screenings" v-bind:key="id" v-on:click="click(id)" class="cal-row card"  v-bind:class="{ active: id==active }" v-on:dragstart="drag($event,id)" draggable="true" v-bind:style="{top: 'calc(1000px * '+calcPercentage(timeToInt(screening.time))+')', height: 'calc(1000px *  '+calcPercentage(timeObjToInt(screening.interval)+timeObjToInt(screening.film.duration)+timeObjToInt(screening.ads))+')'}">
                            <div class="card-body">
                                <h5 class="card-title">{{screening.film.name}} @ {{screening.time}}</h5>
                                <p class="card-text">
                                    Total Duration: {{("0"+Math.floor(timeObjToInt(screening.interval)+timeObjToInt(screening.film.duration)+timeObjToInt(screening.ads))).slice(-2)}}:{{("0"+((timeObjToInt(screening.interval)+timeObjToInt(screening.film.duration)+timeObjToInt(screening.ads))*60)%60).slice(-2)}}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-5">
                    <div class="card"  v-if="screenings[active]" style="margin-bottom: 16px;">
                        <div class="card-body">
                            <h5 class="card-title">{{screenings[active].film.name}}</h5>
                            <p class="card-text">
                                <div class="form-group">
                                    <label>Start Time</label>
                                    <input type="time" class="form-control"  v-model="screenings[active].time">
                                </div>
                                <div class="form-group">
                                    <label>Interval Time</label>
                                    <div class="input-group">
                                        <input class="form-control"  type="number" min="0" v-model="screenings[active].interval.mins">
                                        <div class="input-group-append">
                                            <span class="input-group-text">Mins</span>
                                        </div>
                                    </div>
                                </div>
                            <div class="form-group">
                                <label>Film Duration</label>
                                <div class="input-group">
                                    <input class="form-control"  type="number" min="0" disabled v-model="screenings[active].film.duration.mins">
                                    <div class="input-group-append">
                                        <span class="input-group-text">Mins</span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>ADs Time</label>
                                <div class="input-group">
                                    <input class="form-control"  type="number" min="0" v-model="screenings[active].ads.mins">
                                    <div class="input-group-append">
                                        <span class="input-group-text">Mins</span>
                                    </div>
                                </div>
                            </div>
                            </p>
                        </div>
                    </div>
                        <div>
                            <input type="text" v-model="search" placeholder="Search Movies"/>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="TableID" scope="col">ID</th>
                                    <th class="TableName" scope="col">Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="movie in filteredMovies" v-bind:key="movie.id">
                                    <th scope="row">{{movie.movieID}}</th>
                                    <td>{{movie.name}}</td>
                                    <td class="movieAdd"><button v-on:click="add()">add movie</button></td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    import client from "../../api.js"
    import AdminSidebar from "../../components/AdminSidebar";
    import NavbarSticky from "../../components/NavbarSticky";
    import moment from "moment"
    export default {
        name: "home",
        components: {
            AdminSidebar,NavbarSticky
        },
        data() {
            let times = [];
            let screenings = [
                {
                    id:1,
                    film:{
                        duration:{
                            hours:1,
                            mins:30
                        },
                        name:"Endgame",
                    },
                    interval:{
                        hours:1,
                        mins:1
                    },
                    time:"02:30",
                    ads:{
                        hours:1,
                        mins:1
                    }
                }
            ];
            for (let i = 1; i < 25; i++) {
                times.push({
                    value:("0" + i).slice(-2)+":00",
                    text:("0" + i).slice(-2)+":00"
                });
            }

            return {
                search:'',
                i:2,
                times,
                screenings,
                active:'',
                items:[],
                mFilter:{
                    day:null,
                    location:null,
                    audioDescribed:false,
                    thirdDimension:false
                },
                locations:[
                    {
                        value:1,
                        text:"Broadbottom, Tameside"
                    },
                    {
                        value:2,
                        text:"Penistone, Barnsley"
                    },
                    {
                        value:3,
                        text:"Cock Bridge, Hope"
                    }
                ],
                days:[
                    {
                        value:1,
                        text:"Today"
                    },
                    {
                        value:2,
                        text:"Tommrow"
                    },        {
                        value:3,
                        text:moment().add(2, 'days').format("Do MMM")
                    },        {
                        value:4,
                        text:moment().add(3, 'days').format("Do MMM")
                    },        {
                        value:5,
                        text:moment().add(4, 'days').format("Do MMM")
                    },
                ],
                thirdDimension:false,
                audioDescribed:false,
                carousel:[
                    {
                        title:"good stuff",
                        image:"http://localhost:8080/img/endgame-long.jpg",
                        text:"yes"
                    },
                    {
                        title:"Iron Man dies ",
                        image:"http://localhost:8080/img/endgame-long.jpg",
                        text:"ah nahh"
                    },
                    {
                        title:"cool",
                        image:"http://localhost:8080/img/endgame-long.jpg",
                        text:"yes"
                    }
                ],

            }
        },
        methods:{
            async loadData(){
                let resp = await client.get("/movies");
                this.items = resp.data._embedded.movies;
                this.loading=false;
            },
            click(id){
                this.active=id;
            },
            allowDrop(e){
                e.preventDefault();
                return false;
            },
            drop(e,time){
                e.preventDefault();
                let index = e.dataTransfer.getData("text");
                console.log("drop",index,time);
                this.$set(this.screenings[index],'time',time)
                this.$forceUpdate()
            },
            drag(e,index){
                this.active = index;
                e.dataTransfer.setData("text", index);
            },
            timeToInt(time){
                let [hours,mins]=time.split(':');
                return (parseInt(hours)+(parseInt(mins)/60))
            },
            timeObjToInt(time){
                return parseInt(time.hours)+(parseInt(time.mins)/60)
            },
            calcPercentage(time){
                console.log(this.screenings)
                return time/24
            },
            add(){
                this.screenings.push({
                    id:1,
                    film:{
                        duration:{
                            hours:1,
                            mins:1
                        },
                        name:"End game",
                    },
                    interval:{
                        hours:1,
                        mins:1
                    },
                    time:"02:30",
                    ads:{
                        hours:1,
                        mins:1
                    }
                });
            }
        },

        computed:{
            filteredMovies: function () {
                return this.items.filter((movie) => {
                    return movie.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
                })
            }

        },

        created(){
            this.loadData()
        },
    };
</script>

<style lang="scss">

    .input-group-text{
        width: 70px;
    }
    .container{
        padding-top: calc(100px);
    }
    .cal-col{
        position: relative;
        height: 1000px;
    }
    .cal-row{
        position: absolute;
        width: 100%;
    }
    .cal-row.active {
        background-color: #224861;
    }
    .card-hold{
        position: relative;
        display: flex;
        flex-direction: column;
        height: 100%;
    }
    .time{
        height: calc(1000px / 24);
        position: relative;
        border-bottom: white;
        border-bottom-style: solid;
        border-bottom-width: 1px;
        margin-right: -15px;
    }
    .time:first-child{
        border-top: white;
        border-top-style: solid;
        border-top-width: 1px;
    }
    .time > .time-hold{
        position: absolute;
        bottom: 0px;
    }
    .bars{
        width: 100%;
        height: 100%;
        position: absolute;
    }
    .hr{
        height: calc(1000px / 24);
        border-bottom: white;
        border-bottom-style: solid;
        border-bottom-width: 1px;
        margin-left: -15px;
        margin-right: -15px;
    }
    .hr:first-child{
        border-top: white;
        border-top-style: solid;
        border-top-width: 1px;
    }
</style>