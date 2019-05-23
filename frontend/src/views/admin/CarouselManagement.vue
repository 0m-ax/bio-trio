<template>
    <div id="wrap">
        <div id="main" class="container clear-top">
            <p>Your content here</p>
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

    .footer {
        position: relative;
        margin-top: -70px; /* negative value of footer height */
        height: 70px;
        clear:both;
    }
    .navbar{
        visibility: hidden;
    }

</style>