<template>
    <div class="container">
        <AdminSidebar />
        <qrcode-stream @decode="onDecode"></qrcode-stream>
        <div v-if="data">
            <h1>Movie: {{data.movie.name}}</h1>
            <h2>Screening: {{data.screening.startTime}}</h2>
            <h2>Seat: {{data.seat.seatName}}</h2>
            <h2>Used: {{data.used}}</h2>
            <button class="btn-block" v-on:click="markUsed">Mark used</button>
        </div>
    </div>
</template>

<script>
    import AdminSidebar from "../../components/AdminSidebar"
    import { QrcodeStream } from 'vue-qrcode-reader'
    import api from "../../api"
    export default {
        components:{
            AdminSidebar,
            QrcodeStream
        },
        data(){
            return {
                data:null
            }
        },
        methods: {
            async onDecode (decodedString) {
                try{
                    let resp = await api.get("tickets/"+decodedString+"?projection=TicketInfo");
                    this.data = resp.data;
                }catch (e) {
                    this.data = null;
                }

            },
            async markUsed(){
                let resp = await api.put("tickets/"+this.data.ticketID,{
                    used:true
                });
                this.onDecode(this.data.ticketID)
            }
        }
    }
</script>