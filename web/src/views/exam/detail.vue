<template>
  <!-- 1295px -->
  <div>
    <gHead activeIndex='3'></gHead>
    <el-row gutter="0">
      <el-col :span="2"
              :offset="2">
        <div>
          <img src='../../assets/img/boy.png'
               style="height: 120px;" />
        </div>
      </el-col>
      <el-col :span="6">
        <div classname='name'>zero</div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="2"
              :offset="2">
        <el-tabs :tab-position="tabPosition"
                 style="height: 1200px;">
          <el-tab-pane v-for="pro in projects"
                       :label='pro'
                       :key="pro">
          </el-tab-pane>
        </el-tabs>
      </el-col>
      <el-col :span="6">
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
      </el-col>
      <el-col :span="6">
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
      </el-col>
      <el-col :span="6">
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
        <lineChart :name='"aass"'
                   :data='lineData.data'
                   :xAxis='lineData.xAxis'>
        </lineChart>
      </el-col>

    </el-row>
  </div>
</template>
<script>
import lineChart from '@/components/lineChart.vue'
import gHead from '@/components/head.vue'

export default {
  components: {
    gHead,
    lineChart
  },
  data () {
    return {
      lineData: {
        name: 'a',
        xAxis: ['1', '2', '3'],
        data: [220, 182, 19]
      },
      projects: ['语文', '语文', '语文', '语文', '语文', '语文'],
      tabPosition: 'left'
    }
  },
  mounted () {

  },
  methods: {
    getClassTeacherNum () {

    }
  }
}
</script>
<style>
</style>
