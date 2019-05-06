<template>
  <div class="home">
    <Carousel :items="carousel" />

    <NavbarSticky msg="" />

    <Films :items="movies"></Films>
  </div>
</template>

<script>
// @ is an alias to /src
import NavbarSticky from "@/components/NavbarSticky.vue";
import Films from "@/components/Films";
import Carousel from "@/components/Carousel";

export default {
  name: "home",
  components: {
    NavbarSticky,Films,Carousel
  },
  data(){
    return {
      carousel:[
        {
          title:"cool",
          image:"http://localhost:8080/img/endgame-long.jpg",
          text:"yes"
        },
        {
          title:"cool",
          image:"http://localhost:8080/img/endgame-long.jpg",
          text:"yes"
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
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },       {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          "description":"Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.\n",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },   {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },   {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },   {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },   {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },   {
          name:"Avengers: Endgame",
          image:"http://localhost:8080/img/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c",
          times:[
            "10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30","10:30"
          ]
        },
      ]
    }
  }
};
</script>
