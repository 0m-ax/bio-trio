<template>
    <div class="modal fade" id="modalSignupForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content SignupPadding shadow-lg p-4 mb-4">
                <form v-on:submit="signup">
                    <div class="modal-header mb-4">
                        <h5 class="modal-title SignupColor">Sign up</h5>
                    </div>
                    <div class="form-group mb-4">
                        <input type="email" v-model="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted ml-2">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <input type="text" v-model="Name" class="form-control" name="Name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input type="tel" v-model="phoneNumber" class="form-control" placeholder="Phone number">
                    </div>
                    <div class="form-group">
                        <input type="password" v-model="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="password" v-model="confirmPassword" class="form-control" placeholder="Confirm Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>
<style>
    .SignupPadding{
        padding: 15px;
        border-width:4px !important;
        border-color:#E54C00 !important;

    }
    .SignupColor{
        color: #E54C00;
    }


</style>

<script>
    import axios from 'axios';
    export default {
        name: "Sign up",
        props: {
            msg: String
        },
        data(){
            return {
                email:'',
                password:'',
                confirmPassword:'',
                Name:'',
                phoneNumber:''

            }
        },
        methods:{
            signup(e){
                e.preventDefault()
                axios.post("http://localhost:8080/user/Signup",{
                    email:this.email,
                    password:this.password,
                    confirmPassword:this.confirmPassword,
                    Name:this.Name,
                    phoneNumber:this.phoneNumber
                })
            }
        }
    };
</script>