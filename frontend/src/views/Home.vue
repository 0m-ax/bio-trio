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
      }).filter((movie)=>movie.times.length > 0)

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
      if(this.dates[0]){
        this.mFilter.day = this.dates[0].value;
      }
      let resp = await client.get("carouselItems");
      this.carousel =  resp.data._embedded.carouselItems;
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
      carousel:[

       ],
    }
  }
};
</script>
