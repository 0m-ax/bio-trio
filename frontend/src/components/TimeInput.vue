<template>
    <input type="time" class="form-control"  v-model="time">

</template>
<script>
    export default {
        name: "TimeInput",
        props: {
            value: {
                type: Date
            }
        },
        computed:{
            time:{
                get(){
                    let t = `${("0" + this.value.getHours()).slice(-2)}:${("0"+this.value.getMinutes()).slice(-2)}`;
                    console.log(t);
                    return t;
                },
                set(newVal){
                    let [h,m] = newVal.split(":");
                    this.value.setHours(h);
                    this.value.setMinutes(m);
                    this.$emit('input', this.value);
                }
            }
        }
    }
</script>