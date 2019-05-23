<template>
    <footer>
        <div class="container-fluid footer  ">
            <div class="row">
                <div class="col">
                    <a href="/"><img src="../../../backend/src/main/resources/static/img/logo.png" style="height: 50%; margin-top: 10px"/></a>
                    <p style="color: #717171">© 2019 Bio-Trio</p>
                </div>
                <div class="col align-self-center">
                    <p>Phone: +4500000000</p>
                    <p>Email: Bio-Trio@gmail.com</p>
                </div>
                <div class="col text-right">
                    <a href="#">
                    <img class="FooterLogo" src="../assets/twitterlogo.png" alt="..." />
                    </a>
                    <a href="#">
                    <img class="FooterLogo" src="../assets/facebookFooter.png" alt="..." />
                    </a>
                    <a href="#">
                    <img class="FooterLogo" style="width:9%;" src="../assets/InstagramFooter.png" alt="..." />
                    </a>
                </div>

            </div>
        </div>

    </footer>


</template>

<style lang="scss">
    .footer{
        text-align: left;
        background-color:darkgrey;
        font-weight: bold;
        margin-bottom: 0;
        bottom: 0;
        justify-content: space-between;
    }
    footer{

        .row{
            max-height: 70px;
        }
        .col{
            max-height: 70px;
        }
        p{
            margin-bottom: 0;
        }
    }
    .FooterLogo{
        width: 8%;
        margin-right: 15px;
        margin-top: 5px;
    }
</style>

<script>
    export default {
        name: "Footer",
        props: {
            msg: String
        }
    };
</script>

