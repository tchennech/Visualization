import Vue from 'vue'
import Router from 'vue-router'

import login from '@/views/login.vue'
import home from '@/views/home.vue'
import atdhome from '@/views/attendance/home.vue'
import exam from '@/views/exam/detail.vue'
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
    },
    {
      path: '/exam',
      name: 'exam',
      component: exam,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/atdhome',
      name: 'atdhome',
      component: atdhome,
      meta: {
        keepAlive: false
      }
    }
  ]
})
