<template>
    <div>
        <div v-bind:class="{ active: active }" id="sideBar">
            <a class="toggle-sideBar" v-on:click="toggleSidebar()">
                <span></span>
                <span></span>
                <span></span>
            </a>
            <h2>Services</h2>
            <ul>
                <a href="/admin/cal"><li>Calendar Management</li></a>
                <a href="/admin/TheatreManagement"><li>Theatre Management</li></a>
                <a href="/admin/ScheduleManagement"><li>Schedule Management</li></a>
                <a href="/admin/Movie"><li>Movie Management</li></a>
                <a href="/admin/CarouselManagement"><li>Carousel Management</li></a>
                <a href="/admin/Order"><li>Order Management</li></a>
            </ul>
        </div>
    </div>
</template>

<style>

    *{
        margin: 0px;
        padding:0px;
    }
    h2{
        text-align: left;
        margin-left: 20px;
        margin-top: 15px;
    }
    a:hover{
        text-decoration: none;
    }
    #sideBar.active{
        left: 0px;
    }

    #sideBar{
        position: fixed;
        width: 300px;
        height: 100%;
        background: black;
        left: -300px;
        transition: all 500ms linear;
    }
    #sideBar ul li{
        color: white;
        list-style: none;
        padding: 20px;
        border-bottom: solid 1px grey;

    }
    #sideBar ul li:hover{
        border-left: solid 5px orange;
        background-color: #353535;
        text-decoration: none;
    }
    #sideBar .toggle-sideBar {
        position: absolute;
        left: 330px;
        top: 20px;

    }
    #sideBar .toggle-sideBar span {
        display: block;
        width: 30px;
        height: 5px;
        margin: 3px 0px;
        background: white;

    }

</style>

<script>

    export default {
        methods:{
            toggleSidebar(){
                console.log("swap")
                this.active = !this.active
            }
        },
        data(){
            return {
                active:false
            }
        },
        name: "adminPage"
    };

</script>