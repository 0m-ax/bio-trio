<template>
  <div id="app">
    <NavbarFixedTop msg="" />

    <Login msg="" />
    <RouterView></RouterView>
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

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
