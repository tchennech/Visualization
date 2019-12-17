<template>
  <div>
    <el-row>
      <mbarChart :legend="upData1.legend"
                 :xAxis="upData1.xAxis"
                 :data="upData1.data"
                 :title="upData1.title"
                 :id="upData1.id"
                 v-if="upData1.flag"></mbarChart>
      <mbarChart :legend="upData2.legend"
                 :xAxis="upData2.xAxis"
                 :data="upData2.data"
                 :title="upData2.title"
                 :id="upData2.id"
                 v-if="upData2.flag"></mbarChart>
    </el-row>
    <el-row>
      极坐标柱状图
    </el-row>
  </div>
</template>
<script>
import mbarChart from '@/components/barChart_muliti.vue'
export default {
  name: 'deData',
  components: {
    mbarChart
  },
  data () {
    return {
      xlabel: ['迟到', '校服', '早退', '离校', '进校'],
      upData1: {
        legend: ['男', '女'],
        xAxis: this.xlabel,
        data: [],
        title: '考勤性别比',
        id: 'sexBar',
        flag: false
      },
      upData2: {
        legend: ['住校', '非住校'],
        xAxis: this.xlabel,
        data: [],
        title: '考勤住校比',
        id: 'sleepBar',
        flag: false
      },
      downData1: {

      },
      downData2: {

      },
      downData3: {

      }
    }
  },
  mounted () {
    this.getUpData()
  },
  methods: {
    getUpData () {
      this.$http.post('/api/getUpData.action').then(
        function (res) {
          let result = JSON.parse(JSON.parse(res.bodyText))
          if (result.status === 1) {
            this.$message({
              message: '获取数据失败:' + result.msg,
              type: 'warning'
            })
            console.log('getClassTeacherNum Failed')
          } else {
            let data = JSON.parse(result.data)
            let baseData = {
              name: '',
              type: 'bar',
              stack: '总量',
              label: {
                normal: {
                  show: true
                }
              },
              data: []
            }
            let man = baseData
            man.name = this.upData1.legend[0]
            man.data = data.left[0]
            let women = baseData
            women.name = this.upData1.legend[1]
            women.data = data.left[1]
            this.upData1.data = [man, women]
            this.upData1.flag = true

            let lin = baseData
            lin.name = this.upData2.legend[0]
            lin.data = data.right[0]
            let lout = baseData
            lout.name = this.upData2.legend[1]
            lout.data = data.right[1]
            this.upData2.data = [lin, lout]
            this.upData2.flag = true
          }
        },
        function (err) {
          if (err) {
            console.log(err.stack)
          }
          this.$message.error('请求服务器时发生错误')
        }
      )
    }
  }
}
</script>
