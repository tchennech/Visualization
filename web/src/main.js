// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/font/iconfont.css'
import VueClipboard from 'vue-clipboard2'
// import $ from 'jquery'
import VueResource from 'vue-resource'
import { setCookie, getCookie, delCookie, getUser } from './assets/js/cookie.js'
import VueParticles from 'vue-particles'
Vue.use(VueParticles)
Vue.use(VueClipboard)
Vue.use(ElementUI)
Vue.use(VueResource)
// Vue.use($)
Vue.config.productionTip = false
Vue.http.options.emulateHTTP = true
Vue.http.options.emulateJSON = true

// cookies
Vue.prototype.setCookie = setCookie
Vue.prototype.getCookie = getCookie
Vue.prototype.delCookie = delCookie
Vue.prototype.getUser = getUser
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
