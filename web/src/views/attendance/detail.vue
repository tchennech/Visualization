<template>
  <div style="padding-top: 10px;">
    <el-row>
      <el-col :span="12">
        <mbarChart :legend="upData1.legend"
                   :xAxis="upData1.xAxis"
                   :data="upData1.data"
                   :title="upData1.title"
                   :id="upData1.id"
                   v-if="upData1.flag"
                   class="center"></mbarChart>
      </el-col>
      <el-col :span="12">
        <mbarChart :legend="upData2.legend"
                   :xAxis="upData2.xAxis"
                   :data="upData2.data"
                   :title="upData2.title"
                   :id="upData2.id"
                   v-if="upData2.flag"
                   class="center"></mbarChart>
      </el-col>
    </el-row>
    <el-divider></el-divider>
    <el-row>
      <el-col :span="8">
        <barPolar :name="downData[0].name"
                  :id="downData[0].id"
                  :xLabel="downData[0].xLabel"
                  :legend="xlabel"
                  :data="downData[0].data"
                  v-if="downData[0].flag">
        </barPolar>
      </el-col>
      <el-col :span="8">
        <barPolar :name="downData[1].name"
                  :id="downData[1].id"
                  :xLabel="downData[1].xLabel"
                  :legend="xlabel"
                  :data="downData[1].data"
                  v-if="downData[1].flag">
        </barPolar>
      </el-col>
      <el-col :span="8">
        <barPolar :name="downData[2].name"
                  :id="downData[2].id"
                  :xLabel="downData[2].xLabel"
                  :legend="xlabel"
                  :data="downData[2].data"
                  v-if="downData[2].flag">
        </barPolar>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import mbarChart from '@/components/barChart_muliti.vue'
import barPolar from '@/components/barPolar.vue'
export default {
  name: 'deData',
  components: {
    mbarChart,
    barPolar
  },
  data () {
    return {
      xlabel: ['迟到', '校服', '早退', '离校', '进校'],
      upData1: {
        legend: ['男', '女'],
        xAxis: [],
        data: [],
        title: '考勤性别比',
        id: 'sexBar',
        flag: false
      },
      upData2: {
        legend: ['住校', '非住校'],
        xAxis: [],
        data: [],
        title: '考勤住校比',
        id: 'sleepBar',
        flag: false
      },
      downData: [
        {
          name: '早高峰考勤',
          id: 'morning',
          xLabel: [21600, 25200],
          data: [],
          flag: false
        }, {
          name: '午高峰考勤',
          id: 'afternoon',
          xLabel: [39600, 43200],
          data: [],
          flag: false
        }, {
          name: '晚高峰考勤',
          id: 'night',
          xLabel: [57600, 61200],
          data: [],
          flag: false
        }
      ]
    }
  },
  mounted () {
    this.getUpData()
    this.getDownData()
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
            let man = JSON.parse(JSON.stringify(baseData))
            man.name = this.upData1.legend[0]
            man.data = data.left[0]
            let women = JSON.parse(JSON.stringify(baseData))
            women.name = this.upData1.legend[1]
            women.data = data.left[1]
            this.upData1.data = [man, women]
            this.upData1.xAxis = this.xlabel
            this.upData1.flag = true

            let lin = JSON.parse(JSON.stringify(baseData))
            lin.name = this.upData2.legend[0]
            lin.data = data.right[0]
            let lout = JSON.parse(JSON.stringify(baseData))
            lout.name = this.upData2.legend[1]
            lout.data = data.right[1]
            this.upData2.data = [lin, lout]
            this.upData2.xAxis = this.xlabel
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
    },
    getDownData () {
      this.$http.post('/api/getDownData.action').then(
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
              type: 'bar',
              data: [],
              coordinateSystem: 'polar',
              stack: 'as',
              name: ''
              // Set `large` for large data amount
            }
            for (let index in data) {
              let eachData = data[index]
              let datas = []
              for (let inside in eachData) {
                let each = JSON.parse(JSON.stringify(baseData))
                each.data = eachData[inside]
                each.name = this.xlabel[inside]
                datas.push(each)
              }
              this.downData[index].data = JSON.parse(JSON.stringify(datas))
              this.downData[index].flag = true
            }
            console.log(this.downData)
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
