import Vue from 'vue'
import Router from 'vue-router'

import login from '@/views/login.vue'
import home from '@/views/home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/',
      name: 'home',
      component: home,
      meta: {
        keepAlive: false
      }
    }
  ]
})
