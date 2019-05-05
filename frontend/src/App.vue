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
    <div class="row justify-content-center mt-5 mb-5">
      <div class="card ml-5 mr-5" style="width: 300px; height: auto">
        <img src="./assets/engameposter.jpg" class="card-img-top" alt="..." onclick="alert('work in progress')">
        <div class="card-body">
          <h5 class="card-title">Endgame</h5>
          <a href="#" class="btn btn-primary">Book</a>
        </div>
      </div>
      <div class="card ml-5 mr-5" style="width: 300px; height: auto">
        <img src="./assets/engameposter.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Endgame</h5>
          <a href="#" class="btn btn-primary">Book</a>
        </div>
      </div>
      <div class="card ml-5 mr-5" style="width: 300px; height: auto">
        <img src="./assets/engameposter.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Endgame</h5>
          <a href="#" class="btn btn-primary">Book</a>
        </div>
      </div>
      <div class="card ml-5 mr-5" style="width: 300px; height: auto">
        <img src="./assets/engameposter.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Endgame</h5>
          <a href="#" class="btn btn-primary">Book</a>
        </div>
      </div>
    </div>



    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


    <!--<router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>-->
  </div>
</template>

<script>
  export default {
    data(){
      return {
        title:'',
        active: null
      }
    }
  };



</script>

<style lang="scss">

.carousel-inner{
  max-height: 720px;
  width: auto;
}
#nav2{
  position: sticky;
  top:50px;
  z-index:1;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.card{
  cursor: pointer;
}
</style>
