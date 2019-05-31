<template>
    <div>
        <div class="modal fade" id="modalLoginForm" ref="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content padding shadow-lg p-4 mb-4">
                    <form  v-on:submit.prevent="login">
                        <div class="modal-header mb-4">
                            <h5 class="modal-title color">Login</h5>
                        </div>
                        <div class="form-group mb-4">
                            <input type="email" v-model="loginUsername" class="form-control" aria-describedby="emailHelp" placeholder="Enter email">
                            <small class="form-text text-muted ml-2">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <input type="password" v-model="loginPassword" class="form-control" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modalSignupForm" tabindex="-1" role="dialog" ref="signup" aria-labelledby="myModalLabel"
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
                            <input type="text" v-model="firstName" class="form-control" name="fistName" placeholder="First name">
                        </div>
                        <div class="form-group">
                            <input type="text" v-model="lastName" class="form-control" name="lastName" placeholder="Last name">
                        </div>
                        <div class="form-group">
                            <input type="tel" v-model="phone" class="form-control" placeholder="Phone number">
                        </div>
                        <div class="form-group">
                            <input type="password" v-model="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <input type="password" v-model="passwordConfirm" class="form-control" placeholder="Confirm Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
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
    import api from '../api.js'
    export default {
        name: "Sign up",
        props: {
            msg: String
        },
        data(){
            return {
                firstName:"",
                lastName:"",
                address:"",
                password:"",
                passwordConfirm:"",
                email:"",
                phone:"",
                loginUsername:"",
                loginPassword:"",
            }
        },
        methods:{
            async signup(e){
                e.preventDefault();
                if(this.password == this.passwordConfirm){
                    try {
                        let resp = await axios.post("http://localhost:8080/api/registration",{
                            firstName:this.firstName,
                            lastName:this.lastName,
                            address:this.address,
                            password:this.password,
                            email:this.email,
                            phone:this.phone,
                        })
                        console.log(resp)
                        if(resp.status == 200 && resp.data){
                            window.$(this.$refs.signup).modal('hide');
                            window.$(this.$refs.login).modal('show');
                        }else{
                            alert("error signing up")
                        }
                    }catch (e) {
                        alert("error signing up")
                    }

                }else{
                    alert("Passwords do not match");
                }
            },
            async login(){
                let resp = await api.post("../login",{
                    username:this.loginUsername,
                    password:this.loginPassword,
                });
                await this.$store.dispatch("fetchUser");
                window.$(this.$refs.login).modal('hide');
                console.log(resp)
            }
        }
    };
</script>