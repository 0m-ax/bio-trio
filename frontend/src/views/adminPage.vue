<template>
    <div class="adminPage">
        <div id="sideBar">
            <div class="toggle-sideBar" onclick="toggleSidebar()">
                <span></span>
                <span></span>
                <span></span>
            </div>
            <ul>
                <li><a href="/admin/cal">Calendar Management</a></li>
                <li><a href="/admin/TheatreManagement">Theatre Management</a></li>
                <li><a href="/admin/ScheduleManagement">Schedule Management</a></li>
                <li><a href="/admin/Movie">Movie Management</a></li>
                <li><a href="/admin/CarouselManagement">Carousel Management</a></li>
                <li><a href="/admin/OrderManagement">Order Management</a></li>
            </ul>
        </div>
    </div>
</template>

<style>

    *{
        margin: 0px;
        padding:0px;
    }
    .footer{
        visibility: hidden;
    }
    #sideBar{
        position: fixed;
        width: 300px;
        height: 100%;
        background: black;
        left: -300px;
        transition: all 500ms linear;
    }
    #sidebar.active{
        left: 0px;
    }
    #sideBar ul li{
        list-style: none;
        margin-top: 1px;
        margin-bottom: 2px;
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
    .navbar {
        visibility: hidden;
    }

</style>

<script>

    function toggleSidebar(){
        document.getElementById("sideBar").classList.toggle('active');
    }

</script>