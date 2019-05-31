<template>
    <div id="nav">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top border border-dark rounded-sm">
            <a class="navbar-brand" href="/"><img src="../../../backend/src/main/resources/static/img/logo.png" style="max-height: 26px"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <router-link to='/' tag='li' active-class='active' class='nav-item'><a class='nav-link' >Home</a></router-link>
                    <router-link to="/about" tag="li" active-class="active" class="nav-item"><a class="nav-link" >About</a></router-link>
                </ul>
                <div class="text-center" v-if="!$store.state.user">
                    <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalLoginForm">Log in</a>
                </div>
                <div class="text-center" v-if="!$store.state.user">
                    <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalSignupForm">Sign up</a>
                </div>
                <div class="text-center" v-if="$store.state.user">
                    <router-link to="/user/order" class="btn btn-default btn-rounded" >Orders</router-link>
                    <a href="" v-on:click="logout" class="btn btn-default btn-rounded">Logout</a>
                </div>
                <div class="text-center" v-if='$store.state.user && $store.state.user.roles.find((role)=>role.id == 2)'>
                    <router-link to="/admin" class="btn btn-default btn-rounded" >Admin Area</router-link>
                </div>
            </div>
        </nav>
    </div>
</template>

<style>
    .btn{
        color: #F7F7F7;
    }
</style>

<script>
    import api from '../api.js'

    export default {
        name: "NavbarFixedTop",
        props: {
            msg: String
        },
        created() {
            this.$store.dispatch("fetchUser")
        },
        methods:{
            async logout(e){
                e.preventDefault();
                try {
                    let resp = await api.get("../logout");
                }catch (e) {
                    await this.$store.dispatch("fetchUser");
                    this.$router.push("/")
                }
            }
        }
    };
</script>

