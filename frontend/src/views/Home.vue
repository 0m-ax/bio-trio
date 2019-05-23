<template>
  <div class="home">
    <Carousel :items="carousel" />
    <NavbarSticky v-model="mFilter" :locations="locations" :days="days"/>
    <Films :items="films"></Films>
  </div>
</template>

<script>
// @ is an alias to /src
import NavbarSticky from "@/components/NavbarSticky.vue";
import Films from "@/components/Films";
import Carousel from "@/components/Carousel";
import client from "../api.js"
export default {
  name: "home",
  components: {
    NavbarSticky,Films,Carousel
  },
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
    }
  },
  data(){
    client.get("/movies").then((resp)=>{
      console.log(resp)
    });
    return {
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
        }
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
      movies:[
        {
          name:"Mary Poppins",
          image:"http://localhost:8080/img/mary-popins.jpg",
          video:"https://www.youtube-nocookie.com/embed/fuWf9fP-A-U",
          times:[
            {
              "time":"10:30",
              audioDescribed:false,
              thirdDimension:false
            }
          ],
          id:"10"
        },
        {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          description:"Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.\n",
          times:[
            {
              "time":"10:30",
              audioDescribed:true,
              thirdDimension:false
            },
            {
              "time":"11:30",
              audioDescribed:false,
              thirdDimension:true
            },
            {
              "time":"12:30",
              audioDescribed:false,
              thirdDimension:false
            }
          ],
          id:"20"
        }
      ]
    }
  }
};
</script>
