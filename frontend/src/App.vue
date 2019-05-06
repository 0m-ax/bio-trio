<template>
  <div id="app">
    <NavbarFixedTop msg="" />

    <Login msg="" />
    <RouterView></RouterView>
  </div>
</template>

<script>
  import NavbarFixedTop from "@/components/NavbarFixedTop.vue";
  import Login from "./components/Login";

  export default {
    components: {
      Login,NavbarFixedTop
    },

  };
</script>

<style lang="scss">

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
