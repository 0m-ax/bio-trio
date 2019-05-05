<template>
    <div id="nav2">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Cinema
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/">Bio-Trio</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" aria-disabled="true">More cinemas coming soon</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Day
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Moday</a>
                            <a class="dropdown-item" href="#">Tuesday</a>
                            <a class="dropdown-item" href="#">Wednesday</a>
                            <a class="dropdown-item" href="#">Thursday</a>
                            <a class="dropdown-item" href="#">Friday</a>
                            <a class="dropdown-item" href="#">Saturday</a>
                            <a class="dropdown-item" href="#">Sunday</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</template>

<style>
    #nav2{
        position: sticky;
        top:50px;
        z-index:1;
    }

</style>

<script>
    export default {
        name: "NavbarSticky",
        props: {
            msg: String
        }
    };
</script>