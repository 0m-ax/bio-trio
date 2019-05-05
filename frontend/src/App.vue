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
  import Carousel from "@/components/Carousel.vue";
  import NavbarSticky from "@/components/NavbarSticky.vue";
  import NavbarFixedTop from "@/components/NavbarFixedTop.vue";
  import Login from "./components/Login";

  export default {
    components: {
      Login,
      Carousel,NavbarSticky,NavbarFixedTop
    },
      data(){
      return {
        title:'',
        active: null
      }
    }
  };



</script>

<style lang="scss">

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
