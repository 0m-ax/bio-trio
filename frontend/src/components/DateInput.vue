<template>
    <input type="date" class="form-control"  v-model="date">

</template>
<script>
    export default {
        name: "DateInput",
        props: {
            value: {
                type: Date
            }
        },
        computed:{
            date:{
                get(){
                    let t = `${("000" + this.value.getFullYear()).slice(-4)}-${("0"+(this.value.getMonth()+1)).slice(-2)}-${("0"+this.value.getDate()).slice(-2)}`;
                    console.log(t);
                    return t;
                },
                set(newVal){
                    let [y,m,d] = newVal.split("-");
                    this.value.setFullYear(y);
                    this.value.setMonth(m-1);
                    this.value.setDate(d);
                    this.$emit('input', this.value);
                }
            }
        }
    }
</script>