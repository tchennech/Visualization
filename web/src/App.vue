<template>
  <div style="height: 100%">
    <!-- 个人主页的导航 -->
    <!-- <div v-if="!$route.meta.keepAlive">
      <keep-alive>
        <gHead></gHead>
      </keep-alive>
    </div> -->
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>
import 'element-ui/lib/theme-chalk/display.css'

export default {
  name: 'App',
  
  data () {
    return {
      textarea: ''
    }
  },

  methods: {
  }
}
</script>

<style>
* {
  text-decoration: none;
  margin: 0;
  padding: 0;
}
@media screen and (min-width: 768px) {
  #mains {
    width: 100%;
    margin: 0 auto;
  }
}
#mains {
  /* background-color: #f3f5f7; */
}
html,
body {
  height: 100%;
}
body {
  width: 100%;
  font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, SimSun, sans-serif;
  font-weight: 400 !important;
}
</style>
