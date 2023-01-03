import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

Vue.config.productionTip = false



import "./assets/css/forget.css"
import "./assets/css/idea.css"
import "./assets/css/index.css"
import "./assets/css/login.css"
import "./assets/css/mygrxx.css"
import "./assets/css/mygxin.css"
import "./assets/css/myorder.css"
import "./assets/css/proList.css"
import "./assets/css/public.css"

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
