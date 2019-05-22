<template>
    <form v-on:submit="onSubmit">
        <div class="form-group mb-4">
            <input type="text" v-model="value.name" v-on:change="onChange" class="form-control" placeholder="Enter name">
        </div>
        <div class="form-group mb-4">
            <input type="text" v-model="value.length" v-on:change="onChange" class="form-control" placeholder="Enter length">
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
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</template>
private String name;
private String length;
private String description;
private String ageRating;
private String genre;
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
            onSubmit(){
                this.$emit('submit')
            }
        }
    }

</script>