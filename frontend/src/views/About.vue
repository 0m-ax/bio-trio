<template>

  <!--Section: Contact v.1-->
  <div class="about page container">

    <!--Section heading-->
    <h2 class="section-heading h1 pt-4">Contact us</h2>
    <!--Section description-->

    <div class="row">

      <!--Grid column-->
      <div class="col-lg-5 mb-4">

        <!--Form with header-->
        <div class="card">

          <div class="card-body">
            <!--Header-->
            <div class="form-header blue accent-1">
              <h3><i class="fas fa-envelope"></i> Write to us:</h3>
            </div>

            <i>We love receiving emails, please do not hesitate!.</i>
            <br>
            <br>
            <form  action="mailto:Bio-Trio@gmail.com" method="post" enctype="text/plain">
            <!--Body-->
            <div class="md-form">
              <label for="form-name">Your name</label>
              <i class="fas fa-user prefix grey-text"></i>
              <input type="text" id="form-name" name="name" class="form-control">
            </div>

            <div class="md-form">
              <label for="form-email">Your email</label>
              <i class="fas fa-envelope prefix grey-text"></i>
              <input type="text" id="form-email" name="email" class="form-control">

            </div>

            <div class="md-form">
              <label for="form-Subject">Subject</label>
              <i class="fas fa-tag prefix grey-text"></i>
              <input type="text" id="form-Subject" name="subject" class="form-control">

            </div>

            <div class="md-form">
              <label for="form-text">Your message</label>
              <i class="fas fa-pencil-alt prefix grey-text"></i>
              <textarea id="form-text" class="form-control md-textarea" name="comment" rows="3"></textarea>

            </div>

            <div class="text-center mt-4">
              <input type="submit" style="font-size:17px" class="btn btn-light-blue">

            </div>
            </form>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <!--Google map-->
        <h3 style="text-align: center"> Don't get lost!</h3>
        <div id="map-container-google-12" class="z-depth-1-half map-container-6" style="height: 400px">
          <iframe src="https://maps.google.com/maps?q=empire%20cinema&t=&z=13&ie=UTF8&iwloc=&output=embed"
                  frameborder="5" style="border:0" allowfullscreen></iframe>
        </div>
      </div>
    </div>

  </div>

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