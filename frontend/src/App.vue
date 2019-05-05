<template>
  <div id="app">
      <!-- NAVBAR -->
    <div id="nav">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <a class="navbar-brand" href="#">Bio-Trio</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </nav>
    </div>
      <!-- CAROUSEL-->
    <div class="bd-example">
      <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="./assets/endgame-long.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>Endgame</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="./assets/endgame-long.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Endgame</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="./assets/endgame-long.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Endgame</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>

    <!-- ANOTHER NAVBAR LMAO -->
    <div id="nav2">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Bio-Trio</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </nav>
    </div>

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
  export default {
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
.carousel-inner {
  max-height: 720px;
  width: auto;
}
#nav2 {
  position: sticky;
  top:50px;
  z-index:1;
}
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
