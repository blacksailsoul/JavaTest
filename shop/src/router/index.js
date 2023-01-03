import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../views/LoginView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path:'/login',
    name:'login',
    meta:{
      requireAuth: false,
    },
    component: () => import('../views/LoginView.vue')
  },
  {
    path:'/register',
    name:'register',
    meta:{
      requireAuth: false,
    },
    component: () => import('../views/RegisterView.vue')
  },
  {
    path:'/forgetpassword',
    name:'forgetpassword',
    meta:{
      requireAuth: false,
    },
    component: () => import('../views/ForgetPasswordView.vue')
  },
  {
    path:'/mycart',
    name:'mycart',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyCartView.vue')
  },
  {
    path:'/myorder',
    name:'myorder',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyOrderView.vue')
  },
  {
    path:'/myevaluation',
    name:'myevaluation',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyEvaluationView.vue')
  },
  {
    path:'/mycenter',
    name:'mycenter',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyCenterView.vue')
  },
  {
    path:'/myaddress',
    name:'myaddress',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyAddressView.vue')
  },
  {
    path:'/myinformation',
    name:'myinformation',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyInformationView.vue')
  },
  {
    path:'/mychangepassword',
    name:'mychangepassword',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/MyChangepasswordView.vue')
  },
  {
    path:'/prolist',
    name:'prolist',
    meta:{
      requireAuth: true,
      IndexOnly: true
    },
    component: () => import('../views/ProlistView.vue')
  },
  {
    path:'/flowerder',
    name:'flowerder',
    meta:{
      requireAuth: true,
      IndexOnly: true
    },
    component: () => import('../views/FlowerDer.vue')
  },
  {
    path:'/vaseprolist',
    name:'vaseprolist',
    meta:{
      requireAuth: true,
      IndexOnly: true
    },
    component: () => import('../views/VaseProlistView.vue')
  },
  {
    path:'/prodetail',
    name:'prodetail',
    meta:{
      requireAuth: true,
      IndexOnly: true,
      title: '首页' 
    },
    component: () => import('../views/ProDetailView.vue')
  },
  {
    path:'/count',
    name:'count',
    meta:{
      requireAuth: true,
      IndexOnly: false
    },
    component: () => import('../views/ComputedCom.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
