<template>
    <div id="nav">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
            <a class="navbar-brand" href="#">Bio-Trio</a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <router-link to='/' tag='li' active-class='active' class='nav-item'><a class='nav-link' >Home</a></router-link>
                    <router-link to="/about" tag="li" active-class="active" class="nav-item"><a class="nav-link" >About</a></router-link>
                </ul>
                <!-- LOGIN IN THE NAVBAR-->
                <div class="text-center">
                    <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#modalLoginForm">Sign in</a>
                </div>
                <!-- END OF LOG IN FORM -->
            </div>
        </nav>
    </div>
</template>

<script>
    export default {
        name: "NavbarFixedTop",
        props: {
            msg: String
        }
    };
</script>