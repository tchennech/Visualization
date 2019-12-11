<template>
  <div>
    <el-container style="width:100%">
      <el-header height="600px"
                 id="homeHeadBack">
        <gHead activeIndex='1'></gHead>
      </el-header>
      <el-main>
        <div class='oddDiv'>
          <div class='middleConten center'>
            <el-card class="box-card">
              <div slot="header"
                   class="clearfix">
                <span style="float: left;">各科教师分布</span>
                <el-button style="float: right; padding: 3px 0"
                           type="text">详情</el-button>
              </div>
              <barChart :name="'教师各科数量分布'"
                        :id="teaDisData.id"
                        :data="teaDisData.data"
                        :xLabel="teaDisData.xLabel"
                        :width='"1000px"'
                        v-if='teaDisData.flag'>
              </barChart>
            </el-card>
          </div>
        </div>
        <div class='evenDiv'>
          2
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import gHead from '@/components/head.vue'
import barChart from '@/components/barChart.vue'
import '../assets/css/home.css'

export default {
  components: {
    gHead,
    barChart
  },
  data () {
    return {
      user: {},
      teaDisData: {
        id: 'teacherDis',
        data: [24, 24, 31, 9, 10, 7],
        xLabel: ['语文', '数学', '英语', '物理', '化学', '生物'],
        flag: false
      }
    }
  },
  created () {
    this.user = this.getUser()
    this.getClassTeacherNum()
  },
  methods: {
    getClassTeacherNum () {
      this.$http.post('/api/getallteacher.action').then(
        function (res) {
          let result = JSON.parse(JSON.parse(res.bodyText))
          console.log(result)
          if (result.status === 1) {
            this.$message({
              message: '获取数据失败:' + result.msg,
              type: 'warning'
            })
            console.log('getClassTeacherNum Failed')
          } else {
            let data = JSON.parse(result.data)
            console.log(data)
            this.teaDisData.data = data.tNum
            this.teaDisData.xLabel = data.label
          }
          this.teaDisData.flag = true
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
<style>
</style>
