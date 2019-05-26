<template>
    <div id="nav">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top border border-dark rounded-sm">
            <a class="navbar-brand" href="/"><img src="../../../backend/src/main/resources/static/img/logo.png" style="max-height: 26px"></a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <router-link to='/' tag='li' active-class='active' class='nav-item'><a class='nav-link' >Home</a></router-link>
                    <router-link to="/about" tag="li" active-class="active" class="nav-item"><a class="nav-link" >About</a></router-link>
                </ul>
                <!-- LOGIN IN THE NAVBAR-->
                <div class="text-center" v-if="!$store.state.user">
                    <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalLoginForm">Log in</a>
                </div>
                <!-- END OF LOG IN FORM -->
                <!-- SIGN UP IN THE NAVBAR-->
                <div class="text-center" v-if="!$store.state.user">
                    <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalSignupForm">Sign up</a>
                </div>
                <div class="text-center" v-if="$store.state.user">
                    <a href="" v-on:click="logout" class="btn btn-default btn-rounded">Logout</a>
                </div>
                <!-- END OF SIGN UP FORM-->
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
                }
                console.log("updated")
            }
        }
    };
</script>

