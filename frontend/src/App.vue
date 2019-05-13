<template>
  <div id="app">
    <NavbarFixedTop msg="" />

    <Login msg="" />
    <RouterView class="page"></RouterView>
    <Footer msg=""/>
  </div>
</template>

<script>
  import NavbarFixedTop from "@/components/NavbarFixedTop.vue";
  import Login from "./components/Login";
  import Footer from "./components/Footer";

  export default {
    components: {
      Login,NavbarFixedTop,Footer
    },
  };
</script>

<style lang="scss">
@import "css-vars";
@import "../node_modules/bootstrap/scss/bootstrap";

.page{
  margin-top: 56px;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.footer {
  
  background-color: #570900;
}
.nav-item {
  color: #F7F7F7;
}
</style>
