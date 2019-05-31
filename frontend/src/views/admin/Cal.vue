<template>
    <div class="home">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary border border-dark rounded-sm">
            <div id="navbarTogglerDemo03">
                <form class="form-inline mr-auto">
                    <label class="my-1 mr-2" for="location">Location: </label>
                    <select v-on:change="onChange" class="form-control my-1 mr-sm-2" id="location" v-model="screenHallID">
                        <option v-for="screeningHall in screeningHalls" v-bind:value="screeningHall.screenHallID">{{screeningHall.name}}</option>
                    </select>
                    <label class="my-1 mr-2" for="day">Day: </label>
                    <DateInput v-on:input="onChange" class="form-control mr-sm-2" id="day" v-model="date"/>
                </form>
            </div>
        </nav>
        <AdminSidebar />
        <div class="container cal-contain">
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
                        <div v-for="(screening,id) in screenings"
                             v-bind:key="id"
                             v-on:click="click(id)"
                             class="cal-row card"
                             v-bind:class="{ active: id==active }"
                             v-on:dragstart="drag($event,id)"
                             draggable="true"
                             v-bind:style="{top: 'calc(1000px * '+calcPercentage(dateToInt(screening.startTime))+')',
                             height: 'calc(1000px *  '+calcPercentage((screening.cleaning/60)+(screening.movie.length/60))+')'
                             }">
                            <div class="card-body">
                                <h5 class="card-title">{{screening.movie.name}} @ {{screening.startTime}}</h5>
                                <p class="card-text">
                                    <!--Total Duration: {{("0"+Math.floor(timeObjToInt(screening.interval)+timeObjToInt(screening.film.duration)+timeObjToInt(screening.ads))).slice(-2)}}:{{("0"+((timeObjToInt(screening.interval)+timeObjToInt(screening.film.duration)+timeObjToInt(screening.ads))*60)%60).slice(-2)}}-->
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-5">
                    <div class="card"  v-if="screenings[active]" style="margin-bottom: 16px;">
                        <div class="card-body">
                            <h5 class="card-title">{{screenings[active].movie.name}}</h5>
                            <p class="card-text">
                                <div class="form-group">
                                    <label>Start Time</label>
                                    <TimeInput class="form-control" v-on:input="$forceUpdate()" v-model="screenings[active].startTime"/>
                                </div>
                                <div class="form-group">
                                    <label>Cleaning Time</label>
                                    <div class="input-group">
                                        <input class="form-control"  type="number" min="0" v-model="screenings[active].cleaning">
                                        <div class="input-group-append">
                                            <span class="input-group-text">Mins</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Cost</label>
                                    <div class="input-group">
                                        <input class="form-control"  type="number" min="0" v-model="screenings[active].cost">
                                        <div class="input-group-append">
                                            <span class="input-group-text">kr</span>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-primary" v-on:click="remove(screenings[active].screeningID)">Delete</button>
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
                                <tr v-for="(movie,movieID) in filteredMovies" v-bind:key="movie.id">
                                    <th scope="row">{{movie.movieID}}</th>
                                    <td>{{movie.name}}</td>
                                    <td class="movieAdd"><button v-on:click="add(movieID)">add movie</button></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                </div>
            </div>
            <button v-on:click="save">Save {{screenHallID}}</button>
        </div>
    </div>
</template>

<script>
    import client from "../../api.js"
    import AdminSidebar from "../../components/AdminSidebar";
    import NavbarSticky from "../../components/NavbarSticky";
    import TimeInput from "../../components/TimeInput";
    import DateInput from "../../components/DateInput";
    import moment from "moment"
    export default {
        name: "home",
        components: {
            AdminSidebar,NavbarSticky,TimeInput,DateInput
        },
        data() {
            let times = [];
            for (let i = 1; i < 25; i++) {
                times.push({
                    value:i,
                    text:("0" + i).slice(-2)+":00"
                });
            }
            return {
                date:new Date(),
                search:'',
                i:2,
                times,
                screeningHalls:[],
                screenings:[],
                active:'',
                movies:[],
                screenHallID:null
            }
        },
        methods:{
            async onChange(){
                await this.save()
                await this.loadData();
            },
            async loadData(){
                this.loading=true;
                function parseISOLocal(s) {
                    var b = s.split(/\D/);
                    return new Date(b[0], b[1]-1, b[2], b[3], b[4], b[5]);
                }
                let respM = await client.get("/movies");
                this.movies = respM.data._embedded.movies;
                let respH = await client.get("screenHalls");
                this.screeningHalls = respH.data._embedded.screenHalls;
                if(this.screenHallID == null){
                    this.screenHallID = 1;
                }
                let respS = await client.get("/screenings/search/findByStartTime?screenHallID="+this.screenHallID+"&startTime="+this.date.getFullYear()+"-"+("0"+(this.date.getMonth()+1)).slice(-2)+"-"+("0"+this.date.getDate()).slice(-2)+"&projection=ScreeningInfo");
                let screeningData = respS.data._embedded.screenings.map(screening=>{
                    screening.startTime = parseISOLocal(screening.startTime);
                    return screening;
                }).filter(({startTime})=>startTime.toDateString() == this.date.toDateString())
                let screenings = {};
                for(let screening of screeningData){
                    screenings[screening.screeningID] = screening;
                }
                this.screenings = screenings;
                this.loading=false;
                this.$forceUpdate()
            },
            async remove(id){
                if(id){
                    try{
                        await client.delete("/screenings/"+id);
                    }catch (e) {
                        alert("error deleting screening (it may have bookings)")
                    }
                    this.loadData();
                }else {
                    delete this.screenings[this.active];
                    this.$forceUpdate();
                }

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
                this.screenings[index].startTime.setHours(time-1);
                this.screenings[index].startTime.setMinutes(0);
                this.$set(this.screenings[index],'startTime',this.screenings[index].startTime);
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
            async save(){
                let data = Object.values(this.screenings).map((screening)=>{
                    return {
                        startTime:(new Date(screening.startTime- ((new Date()).getTimezoneOffset() * 60000))).toISOString(),
                        movie:"movie/"+screening.movie.movieID,
                        cleaning:screening.cleaning,
                        screeningID:screening.screeningID,
                        screenHall:"screenHall/"+this.screenHallID,
                        cost:screening.cost
                    };
                });
                for(let item of data){
                    if(item.screeningID){
                        let resp = await client.put("/screenings/"+item.screeningID,item);
                        console.log(resp)
                    }else{
                        let resp = await client.post("/screenings",item);
                        console.log(resp)
                    }
                }
                await this.loadData();
            },
            timeObjToInt(time){
                return parseInt(time.hours)+(parseInt(time.mins)/60)
            },
            dateToInt(date){
                console.log(date.getHours())
                return date.getHours()+(date.getMinutes()/60)
            },
            calcPercentage(time){
                console.log(this.screenings)
                return time/24
            },
            add(movieID){
                this.screenings[Math.random()] ={
                    movie: this.filteredMovies[movieID],
                    cleaning:10,
                    startTime:new Date(this.date),
                    cost:0,
                    added:true
                };
                this.$forceUpdate();
            }
        },

        computed:{
            filteredMovies: function () {
                return this.movies.filter((movie) => {
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

    .cal-contain{
        margin-left: 400px;

    }
    .container{
        max-width: 70%;
    }

    .input-group-text{
        width: 70px;
    }
    .cal-contain{
        padding-top: 15px;
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