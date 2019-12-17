<template>
  <div>
    <el-row>
      <el-col :span="18">
        <h2>考勤总览</h2>
        <sunBurst :data="data"
                  v-if="flag"></sunBurst>
      </el-col>
      <el-col :span="6">
        <div class="rightText"
             v-for="child in data"
             :key="child.name">
          <el-divider></el-divider>
          <h3>
            {{child.name}}
          </h3>
          <div v-for="each in child.children"
               :key="each.name">
            <el-divider></el-divider>
            <span>
              <el-row>
                <el-col :span="8">{{each.name}}</el-col>
                <el-col :span="16">{{each.value}}</el-col>
              </el-row>
            </span>
          </div>
        </div>
      </el-col>
    </el-row>

  </div>
</template>
<script>
import sunBurst from '@/components/sunburst.vue'
import '@/assets/css/summary.css'
export default {
  name: 'deData',
  components: {
    sunBurst
  },
  data () {
    return {
      data: [],
      flag: false,
      data1: [],
      data2: []
    }
  },
  mounted () {
    this.getAllData()
  },
  methods: {
    getAllData () {
      this.$http.post('/api/getallattendance.action').then(
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
            this.data = data
            this.flag = true
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
