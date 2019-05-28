<template>

  <!--Section: Contact v.1-->
  <section style="margin-top:40px" class="section pb-5">

    <!--Section heading-->
    <h2 class="section-heading h1 pt-4">Contact us</h2>
    <!--Section description-->
    <p class="section-description pb-4">blabkallbalabalablabalbala.</p>

    <div class="row">

      <!--Grid column-->
      <div class="col-lg-5 mb-4">

        <!--Form with header-->
        <div style="margin-left: 40px;" class="card">

          <div class="card-body">
            <!--Header-->
            <div class="form-header blue accent-1">
              <h3><i class="fas fa-envelope"></i> Write to us:</h3>
            </div>

            <i>We love receiving emails, please do not hesitate!.</i>
            <br>
            <br>

            <!--Body-->
            <div class="md-form">
              <label for="form-name">Your name</label>
              <i class="fas fa-user prefix grey-text"></i>
              <input type="text" id="form-name" class="form-control">
            </div>

            <div class="md-form">
              <label for="form-email">Your email</label>
              <i class="fas fa-envelope prefix grey-text"></i>
              <input type="text" id="form-email" class="form-control">

            </div>

            <div class="md-form">
              <label for="form-Subject">Subject</label>
              <i class="fas fa-tag prefix grey-text"></i>
              <input type="text" id="form-Subject" class="form-control">

            </div>

            <div class="md-form">
              <label for="form-text">Your message</label>
              <i class="fas fa-pencil-alt prefix grey-text"></i>
              <textarea id="form-text" class="form-control md-textarea" rows="3"></textarea>

            </div>

            <div class="text-center mt-4">
              <button v-on:click="alert('Your message has been sent, we will get back to you soon!')" style="font-size:17px" class="btn btn-light-blue" >Submit</button>

            </div>
          </div>
        </div>
      </div>

      <div style="margin-left: 60px;" class="col-lg-6">
        <!--Google map-->
        <h3 style="text-align: center"> Don't get lost!</h3>
        <div id="map-container-google-12" class="z-depth-1-half map-container-6" style="height: 400px">
          <iframe src="https://maps.google.com/maps?q=empire%20cinema&t=&z=13&ie=UTF8&iwloc=&output=embed"
                  frameborder="5" style="border:0" allowfullscreen></iframe>
        </div>
      </div>
    </div>

    <br>
    <br>

    <h2 style="text-align: center"> Follow our social media pages!</h2>

    <div class ="media-logo">
      <a href="https://twitter.com/" target="_blank">
      <img  src="../assets/twitterlogo.png" alt="Twitter">
      </a>
      <a href="https://www.facebook.com/" target="_blank">
      <img  src="../assets/facebookFooter.png" alt="Facebook">
      </a>
      <a href="https://www.instagram.com/" target="_blank">
      <img src="../assets/InstagramFooter.png" alt="Instagram">
      </a>
    </div>
     <p class="follow-p"> Follow our social media pages, we post weekly and we often give out juicy discounts. We also organise movie events so make sure not to miss out on those. Join our amazing community of movie lover!!</p>


  </section>

</template>


<style lang="scss">

  .follow-p{
    text-align: center;
    margin-top:10px;
    width: 500px;
  }

  .map-container-6{
    overflow:hidden;
    padding-bottom:60%;
    position:relative;
    height:0;
  }
  .map-container-6 iframe{
    left:0;
    top:0;
    height:100%;
    width:100%;
    position:absolute;
  }

  .media-logo{
    width: 200px;
    margin-left: 30px;
    display: block;
  }
  </style>

<script>
  export default {
    name: "NavbarSticky",
    props: {
      value:{
        type:Object
      },
      locations:{
        type:Array,
        default(){
          return []
        }
      },
      days:{
        type:Array,
        default(){
          return []
        }
      }
    },
    methods:{
      onChange(){
        this.$emit('input', this.value)
      }
    },
    data(){
      return {
      }
    }
  };
</script>