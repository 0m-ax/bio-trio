<template>
    <div class="container">
        <div class="header" style="height: 300px; position: relative;">
            <div v-bind:style="{backgroundImage:'url('+screening.movie.image+')'}" style="background-position: center; background-size: cover; position: absolute; width: 100%; height: 100%; z-index: -1; opacity: 0.4;"></div>
            <div class="image" style="height: 100%; padding-top: 15px; padding-left: 15px; padding-bottom: 15px; float: left;">
                <img v-bind:src="screening.movie.image" style="height: 100%;">
            </div>
            <div class="image" style="padding-top: 15px; padding-left: 15px; padding-bottom: 15px; float: left;">
                <h1>{{screening.movie.name}}</h1>
                <ul>
                    <li style="font-size: 20px ">{{moment(parseISOLocal(screening.startTime)).format("HH:mm Do MMM")}}</li>
                    <li>{{screening.movie.length}}</li>
                    <li>End time: 17:00</li>
                    <li>Rateing: {{screening.movie.ageRating}}</li>
                </ul>
            </div>
        </div>
        <svg v-bind:viewBox='"0 0 "+(size.x+40)+" "+(size.y+40+10)' style="width: 100%;" xmlns="http://www.w3.org/2000/svg">
            <svg v-on:click="seatClick(seat.seatID)" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 422.998 491" v-for="seat in screening.seats"  v-bind:y="seat.y" v-bind:x="seat.x" height="40" width="40">
                <rect stroke="#000" opacity="0" height="491" width="422.998"  stroke-width="0" fill="#fff"/>
                <path fill="#AAAAAA" stroke="#FFFFFF" v-bind:class="{seatSelected:selectedSeats.has(seat.seatID),taken:takenSeats.has(seat.seatID)}" d="M386.002 186.045V81.683c0-25.363-21.008-45.683-46.37-45.683h-42.629V15.895a15.917 15.917 0 0 0-4.702-11.266A15.917 15.917 0 0 0 281.004 0h-140a15.914 15.914 0 0 0-11.297 4.629 15.915 15.915 0 0 0-4.703 11.266V36H83.833a45.638 45.638 0 0 0-45.828 45.683v104.042c-22.215 4.398-38.167 23.964-38 46.609v168.271c0 3.313 2.258 6.391 5.574 6.391h9.191l9.418 77.965a5.79 5.79 0 0 0 5.957 5.035h47.019a5.788 5.788 0 0 0 5.957-5.035l9.418-77.965H328.01l9.418 77.965a5.788 5.788 0 0 0 5.957 5.035H390.4a5.788 5.788 0 0 0 5.957-5.035l9.422-77.965h10.648c3.316 0 5.574-3.078 5.574-6.391V232.334c.001-22.516-14.999-41.41-35.999-46.289zM285.004 79a4 4 0 0 1-4 4h-140c-2.211 0-4-1.789-4-4V16a4 4 0 0 1 4-4h140c2.207 0 4 1.793 4 4v63zM83.833 48h41.172v31.223A15.825 15.825 0 0 0 141.004 95h140a15.825 15.825 0 0 0 11.285-4.555 15.854 15.854 0 0 0 4.714-11.222V48h42.629c18.745 0 34.37 14.938 34.37 33.683v103.16c-25.999.68-46.999 21.714-46.999 47.492v87.663H95.005v-87.663c-.109-25.219-19.824-46-45-47.437V81.683A33.622 33.622 0 0 1 83.833 48zM71.845 477.996H35.466l-8.609-71h53.601l-8.613 71zm313.235 0h-36.378l-8.609-71h53.601l-8.614 71zm24.922-83H12.006V232.334c0-19.609 15.894-35.5 35.5-35.5s35.5 15.891 35.5 35.5v93.968c-.074 1.52.488 3 1.559 4.082a5.424 5.424 0 0 0 4.059 1.613h244.764c1.52.055 2.992-.531 4.059-1.613s1.633-2.563 1.559-4.082v-93.968c0-19.609 15.894-35.5 35.499-35.5s35.5 15.891 35.5 35.5v162.662z"/>
            </svg>
            <rect stroke="#000" height="5" v-bind:width="size.x+40-10" v-bind:y="size.y+40+5" x="5"  stroke-width="0" fill="#fff"/>
        </svg>
        <ul>
            <li v-for="seatID in Array.from(selectedSeats)">{{screening.seats.find(seat=>seat.seatID == seatID).seatName}} @ {{screening.cost/100}}kr</li>
        </ul>
        <button v-on:click="book">Book</button>
    </div>
</template>

<script>
    import moment from "moment";
    import api from "../api.js"
    export default {
        name: "user-order",
        created(){
            this.getOrder()
        },
        computed:{
            size(){
                console.log(this.screening)
                return this.screening.seats.reduce(({x,y},val)=>{
                    return {
                        x:parseInt(val.x)>x?parseInt(val.x):x,
                        y:parseInt(val.y)>y?parseInt(val.y):y
                    }
                },{
                    x:0,
                    y:0,
                })
            }
        },
        methods:{
            async seatClick(seatID){
                if(this.takenSeats.has(seatID)){
                    return;
                }
                if(this.selectedSeats.has(seatID)){
                    this.selectedSeats.delete(seatID)
                }else{
                    if(this.selectedSeats.size < 4){
                        this.selectedSeats.add(seatID);
                    }else {
                        alert("you may only book 4 seats")
                    }
                }
                this.$forceUpdate();
            },
            parseISOLocal(s) {
                var b = s.split(/\D/);
                return new Date(b[0], b[1]-1, b[2], b[3], b[4], b[5]);
            },
            async getOrder(){
                let respO = await api.get("screenings/"+this.$route.params.screeningID+"?projection=ScreeningSeats");
                this.screening = respO.data;
                let respS = await api.get("seats/search/getByAvalibleForScreeningID?screeningID="+this.$route.params.screeningID);
                this.takenSeats = new Set(respS.data._embedded.seats.map((seat)=>seat.seatID));
            },
            async book(e){
                e.preventDefault();
                if(this.selectedSeats.size < 1){
                    alert("please select a seat");
                    return;
                }
                if(this.$store.state.user){
                    try {
                        let resp = await api.post("screenings/"+this.$route.params.screeningID+"/book",Array.from(this.selectedSeats));
                        console.log(resp);
                        this.$router.push({
                            name:"user-order",
                            params:{orderID:resp.data.orderNumber
                            }
                        })
                    }catch (e) {
                        alert("error booking");
                        this.getOrder();
                    }
                }else{
                    alert("please login")
                }
            }
        },
        data(){
            let takenSeats = new Set();
            takenSeats.add(10);
            return {
                moment:moment,
                screening:{
                    seats:[]
                },
                selectedSeats:new Set(),
                takenSeats
            }
        }
    };
</script>

<style lang="scss">
    .seatSelected{
        fill: #FFFFFF;
        stroke-width:5;
    }
    .taken{
        fill: #444444;
    }
    /*.container {*/
        /*margin: 0 auto;*/
        /*margin-top: 100px;*/
        /*margin-bottom: 50px;*/
    /*}*/
</style >