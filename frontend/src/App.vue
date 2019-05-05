<template>
  <div id="app">
      <!-- NAVBAR -->
    <NavbarFixedTop msg="" />

    <!--POPUP LOGIN -->
    <Login msg="" />

    <!-- CAROUSEL-->
    <Carousel msg="" />

    <!-- ANOTHER NAVBAR LMAO -->
    <NavbarSticky msg="" />

    <!-- CARDS -->
    <div class="container">
    <div class="row movies">
      <div v-for="movie,movieIndex in movies" class="col-md-4 movie">
        <div class="card poster" v-on:click="open(movieIndex)">
          <img src="./assets/engameposter.jpg" class="card-img" alt="...">
          <div class="card-img-overlay" >
            <h5 class="card-title">{{movie.name}}</h5>
          </div>
        </div>
        <div v-bind:class="{ open: openMovie==movieIndex }" class="info closed">
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
                Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.
              </div>
              <div class="col-md-6">
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
                <button type="button" class="time btn btn-secondary">10:30</button>
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
  </div>
</template>

<script>
  import Carousel from "@/components/Carousel.vue";
  import NavbarSticky from "@/components/NavbarSticky.vue";
  import NavbarFixedTop from "@/components/NavbarFixedTop.vue";
  import Login from "./components/Login";

  export default {
    components: {
      Login,
      Carousel,NavbarSticky,NavbarFixedTop
    },
    methods:{
      open(movie){
        if(movie == this.openMovie){
          this.openMovie=null
        }else{
          this.openMovie=movie
        }
      }
    },
    data(){
      return {
        openMovie:null,
        movies:[
          {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          },          {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          },          {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          } ,         {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
          video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"

          },          {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          } ,         {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          } ,         {
            name:"Avengers: Endgame",
            image:"./assets/engameposter.jpg",
            video:"https://www.youtube-nocookie.com/embed/TcMBFSGVi1c"
          }
        ]
      }
    }
  };



</script>

<style lang="scss">
  @import "../node_modules/bootstrap/scss/mixins/_breakpoints";
  @import "../node_modules/bootstrap/scss/functions";
  @import "../node_modules/bootstrap/scss/variables";
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
.closed {
  max-height: 0px;
  transform:scaleY(0); // *squish*
}
.open{
  max-height: 1000px;
  transform:scaleY(1);
}

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
