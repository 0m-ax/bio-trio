<template>
  <div id="app">
    <NavbarFixedTop msg="" />
    <Signup msg="" />
    <RouterView class="page"></RouterView>
    <Footer msg=""/>
  </div>
</template>

<script>
  import NavbarFixedTop from "@/components/NavbarFixedTop.vue";
  import Footer from "./components/Footer";
  import Signup from "./components/Signup";

  export default {
    components: {
      NavbarFixedTop,Footer,Signup
    },
  };
</script>

<style lang="scss">
@import "css-vars";
@import "../node_modules/bootstrap/scss/bootstrap";


#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.page{
  margin-top: 58px;
}
.nav-item {
  color: #F7F7F7;
}
</style>
