<template>
    <form v-on:submit="onSubmit">
        <div class="form-group mb-4">
            <input type="text" v-model="value.title" v-on:change="onChange" class="form-control" placeholder="Enter title">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.text" v-on:change="onChange" class="form-control" placeholder="Enter text">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.image" v-on:change="onChange" class="form-control" placeholder="Enter image">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <router-link style="margin-left:20px" to='/admin/' type="button" class="btn btn-primary">Go Back </router-link>
    </form>
</template>

<script>
    export default {

        props: {
            value:{
                type:Object
            },

        },
        methods:{
            onChange(){
                this.$emit('input', this.value)
            },
            onSubmit(ev){
                ev.preventDefault()
                this.$emit('submit')
                alert("is updated!");
            }
        }
    }

</script>