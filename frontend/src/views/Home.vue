<template>
  <div class="home">
    <Carousel :items="carousel" />
    <NavbarSticky v-model="mFilter" :locations="locations" :days="dates"/>
    <Films :items="films"></Films>
  </div>
</template>

<script>
// @ is an alias to /src
import NavbarSticky from "@/components/NavbarSticky.vue";
import Films from "@/components/Films";
import Carousel from "@/components/Carousel";
import client from "../api.js"
import moment from "moment";

function groupBy(list, keyGetter) {
  const map = new Map();
  list.forEach((item) => {
    const key = keyGetter(item);
    const collection = map.get(key);
    if (!collection) {
      map.set(key, [item]);
    } else {
      collection.push(item);
    }
  });
  return Array.from(map.values());
}


export default {
  name: "home",
  components: {
    NavbarSticky,Films,Carousel
  },
  computed:{
    films(){
      return groupBy(this.screenings,item=>item.movie.movieID).map((screenings)=>{
        let movie = screenings[0].movie;
        return {
          name:movie.name,
          video:movie.video,
          image:movie.image,
          description:movie.description,
          id:movie.movieID,
          times:screenings
              .filter((item)=>this.parseISOLocal(item.startTime).toLocaleDateString()==this.mFilter.day)
              .map((screening)=>{
                return {
                  text:moment(this.parseISOLocal(screening.startTime)).format("HH mm"),
                  id:screening.screeningID
                }
            })
        }
      })

    },
      dates(){
          return groupBy(this.screenings,item=>this.parseISOLocal(item.startTime).toDateString())
              .map((screenings)=>{
                  return this.parseISOLocal(screenings[0].startTime)
              })
              .map((time)=>{
                  return {
                      value:time.toLocaleDateString(),
                      text:time.toLocaleDateString()
                  }
              })
      }
  },
  methods:{
    async populate(){
      let {
        data:{
          _embedded:{
            screenings
          }
        }
      } = await client.get("/screenings/search/getByCinemaID?chinemaID=1&projection=ScreeningMovie")
      this.screenings = screenings;
      this.mFilter.day = this.dates[0].value;
    },
    parseISOLocal(s) {
      var b = s.split(/\D/);
      return new Date(b[0], b[1]-1, b[2], b[3], b[4], b[5]);
    }
  },
  created(){
    this.populate()
  },
  data(){
    return {
      screenings:[],
      mFilter:{
        day:null,
        location:null,
        audioDescribed:null,
        thirdDimension:null
      },
      locations:[
        {
          "name":1,
          "text":"BioTrio"
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
  }
};
</script>
