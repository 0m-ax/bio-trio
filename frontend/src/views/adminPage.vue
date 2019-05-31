<template>

        <div id="wrap">
            <div id="main" class="container clear-top">
                <AdminSidebar />
                <h1>Admin Home</h1>
            </div>
        </div>
</template>

<style>

    html, body {
        height: 100%;
    }
    #app{
        height: 100%;
    }
    #wrap {
        min-height: 100%;
    }

    #main {
        overflow:auto;
        padding-bottom:70px; /* this needs to be bigger than footer height*/
    }

</style>

<script>
    import AdminSidebar from "../components/AdminSidebar";

    export default {
        components: {
            AdminSidebar
        }
    }
</script>