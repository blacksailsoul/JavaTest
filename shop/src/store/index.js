import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  namespaced: true,
  state: {
    list: [{ tile:'非洲菊仿真花干花', price: 11 ,num:1},{ tile: '非洲菊仿真花干花', price: 11,num:1 }],

  },
  getters: {},
  mutations: {
    mutationsTotalList(state, list) {
      state.totalList = list
    },
    mutationsTotalList2(state, list) {
      state.totalList = list
    }

  },
  actions: {},
  modules: {}
})