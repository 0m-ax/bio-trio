<template>
    <form v-on:submit="onSubmit">
        <div class="form-group mb-4">
            <input type="text" v-model="value.name" v-on:change="onChange" class="form-control" placeholder="Enter name">
        </div>
        <div class="form-group mb-4">
            <input type="number" v-model="value.length" v-on:change="onChange" class="form-control" placeholder="Enter length">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.description" v-on:change="onChange" class="form-control" placeholder="Enter description">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.ageRating" v-on:change="onChange" class="form-control" placeholder="Enter Age Rating">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.genre" v-on:change="onChange" class="form-control" placeholder="Enter Genre">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.video" v-on:change="onChange" class="form-control" placeholder="Enter Youtube trailer link">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.image" v-on:change="onChange" class="form-control" placeholder="image">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <router-link style="margin-left:20px" to='/admin/Movie' type="button" class="btn btn-primary">Go Back </router-link>
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
            }
        }
    }

</script>