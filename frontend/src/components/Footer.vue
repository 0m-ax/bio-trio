<template>
    <footer class="footer">
        <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand FooterContact" href="/">Logo</a>
            <p class="navbar-brand" style="color: #717171; margin-top: 20px">© 2019 Bio-Trio</p>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active contact-info">
                        <p>Phone: +4500000000</p>
                        <p>Email: Bio-Trio@gmail.com</p>
                    </li>
                </ul>
            </div>
            <div style="text-align: right">
                <a href="#">
                    <img class="FooterLogo" src="../assets/twitterlogo.png" alt="..." />
                </a>
                <a href="#">
                    <img class="FooterLogo" src="../assets/facebookFooter.png" alt="..." />
                </a>
                <a href="#">
                    <img class="FooterLogo" style="width:4.6%;" src="../assets/InstagramFooter.png" alt="..." />
                </a>
            </div>
        </nav>
    </footer>

</template>

<style>
    .footer{
        text-align: left;
        background-color:darkgrey;
        font-weight: bold;
    }
    .FooterContact{
        margin-left: 150px;
        color: black;
    }
    .FooterLogo{
        width: 4%;
        margin-right: 15px;
    }
    .contact-info {
        color: black;
        margin-left: 200px;
        margin-right: auto;
        display: block;
        width: max-content;
        position: static ;
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

