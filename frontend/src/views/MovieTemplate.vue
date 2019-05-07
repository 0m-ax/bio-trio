<template>
    <div class="MovieTemplate">
        <div class="container">
            <div class="row dec justify-content-md-center align-self-center">
                <div class="col-md-6">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/TcMBFSGVi1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="col-md-6 border-left">
                    <h2>Endgame</h2>
                    <div class="text-left">Disney and Marvel screen new Avengers: Endgame footage at CinemaCon 2019 - here are all the details of what the MCU movie footage includes. After the release of Captain Marvel last month, Marvel Studios is turning their focus to the upcoming blockbuster event, Avengers: Endgame. The 22nd movie in the Marvel Cinematic Universe, it's expected to wrap up the story of the franchise thus far, what Marvel Studios head Kevin Feige calls the Infinity Saga. Endgame will pick up from the cliffhanger ending of Avengers: Infinity War and feature the remaining heroes attempting to avenge those they could not save from Thanos' decimating snap.</div>
                </div>
            </div>
        </div>

        <NavbarSticky msg=""/>

        <div class="container">
            <div class="row MovieTemplate dec">
                <div class="col">
                    <div class="col-md-6" >
                        <button type="button" class="time btn btn-secondary">time</button>
                    </div>
                </div>
                <div class="col">
                    <div class="col-md-6" >
                        <button type="button" class="time btn btn-secondary">time</button>
                    </div>
                </div>
                <div class="col">
                    <div class="col-md-6" >
                        <button type="button" class="time btn btn-secondary">time</button>
                    </div>
                </div>
                <div class="col">
                    <div class="col-md-6" >
                        <button type="button" class="time btn btn-secondary">time</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</template>
<style>
    .MovieTemplate {

        padding-top: 15px;
    }
    .dec{
        padding-bottom: 15px;
    }

</style>

<script>
    import NavbarSticky from "../components/NavbarSticky";

    export default {
        components: {
            NavbarSticky
        },
    };

</script>