import Vue from "vue";
import Vuex from "vuex";
import axios from "axios"
import api from "./api"
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user:null
  },
  mutations: {
    SET_USER(state, user) {
      state.user = user
      console.log(user)
    }
  },
  actions:{
    async fetchUser({ commit }){
      let resp = await api.get("../self");
      commit("SET_USER", resp.data);
    }
  }
});
