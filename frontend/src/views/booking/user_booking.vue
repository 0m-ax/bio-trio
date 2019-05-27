<template>

    <div class="container"  style="width:1000px; height:300px; ">
        <img style='height: 100%; width: 100%; object-fit: cover; opacity: 0.5'
             src = "https://ichef.bbci.co.uk/news/660/cpsprodpb/1AF3/production/_106399860_avengers-endgame1.jpg" />

        <div class="col wrapper">
        <div class="col s12 m7">
            <div class="card horizontal" style= "height:250px; width:900px; background: transparent">
                <div class="card-image">
                    <img src="https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_.jpg" style='height: 1100%; width: 17%; object-fit: cover; opacity:1'>
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <h1> <b> End Game </b></h1>
                        <ul>
                            <li style="  font-size: 20px "> <b> Tues, 28. may 2019, 14:45  </b>  </li>
                            <li>2 Hours 10 minutes</li>
                            <li>End time: 17:00</li>
                            <li>Not allowed for children under 11 years old</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



</template>



<style lang="scss">

    .container {
        margin: 0 auto;
        margin-top: 100px;
        margin-bottom: 50px;


    }

    .card{
        min-height: 100%;
        opacity: 1;
        bottom: 250px;


    }

    .card-body {
        background-color: #131f27;
    }


.card-content{

    margin-left: 180px;
    position: relative;
    bottom: 50px;
    line-height: 2;

}

    .card-image {

        height:50px;
        height:20px;
    }

</style >



<script>
    export default {
        name: "User_Booking",
        data(){
            return {
                movie:{
                    "name":"meep moop i is name"
                }
            }
        }
    }

</script>