<template>
  <div>
    <el-container style="width:100%">
      <el-header>
        <gHead activeIndex='4'></gHead>
      </el-header>
      <el-main id="atdMain">
        <div class="outMain">
          <el-tabs v-model="activeName"
                   tab-position="left"
                   style="height: 880px;">
            <el-tab-pane label="概要"
                         name="first">
              <vsummary></vsummary>
            </el-tab-pane>
            <el-tab-pane label="本学期考勤数据"
                         name="second">
              <deData></deData>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import gHead from '@/components/head.vue'
import '@/assets/css/atdHome.css'
import vsummary from './summary.vue'
import deData from './detail.vue'
export default {
  components: {
    gHead,
    vsummary,
    deData
  },
  data () {
    return {
      user: {},
      activeName: 'first'
    }
  },
  mounted () {
    this.user = this.getUser()
  },
  methods: {
  }
}
</script>
<style>
</style>
