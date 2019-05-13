<template>
    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content padding shadow-lg p-4 mb-4 bg-white">
                <form  v-on:submit.prevent="login">
                    <div class="modal-header mb-4">
                        <h5 class="modal-title color">Login</h5>
                    </div>
                    <div class="form-group mb-4">
                        <input type="email" v-model="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted ml-2">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <input type="password" v-model="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>
<style>
    .padding{
        padding: 15px;
        border-width:4px !important;
        border-color:#E54C00 !important;

    }
    .color{
        color: #E54C00;
    }


</style>

<script>
    import axios from 'axios';
    export default {
        name: "Login",
        props: {
            msg: String
        },
        data(){
            return {
                username:'',
                password:''
            }
        },
        methods:{
            login(){
                axios.post("http://localhost:8080/user/login",{
                    username:this.username,
                    password:this.password
                })
            }
        }
    };
</script>