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
          <div class='middleConten center'>
            <el-card class="box-card">
              <el-row>
                <el-col :span='16'>
                  <mapChart :name="'学生分布情况'"
                            :id="mapData.id"
                            :data="mapData.data">
                  </mapChart>
                </el-col>
                <el-col :span='8'>
                  <pieCHart :name="pieData.name"
                            :id="pieData.id"
                            :data="pieData.data">
                  </pieCHart>
                </el-col>
              </el-row>
            </el-card>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import gHead from '@/components/head.vue'
import barChart from '@/components/barChart.vue'
import mapChart from '@/components/map.vue'
import pieCHart from '@/components/pieChart.vue'
import '../assets/css/home.css'

export default {
  components: {
    gHead,
    barChart,
    mapChart,
    pieCHart
  },
  data () {
    return {
      user: {},
      teaDisData: {
        id: 'teacherDis',
        data: [24, 24, 31, 9, 10, 7],
        xLabel: ['语文', '数学', '英语', '物理', '化学', '生物'],
        flag: false
      },
      mapData: {
        id: 'mapDis',
        data: [
          { name: '宁波', value: 9 },
          { name: '温州', value: 12 },
          { name: '安徽', value: 12 },
          { name: '河南', value: 12 },
          { name: '陕西', value: 14 },
          { name: '台州', value: 15 },
          { name: '福建', value: 112 },
          { name: '辽宁', value: 123 },
          { name: '山东', value: 43 },
          { name: '江苏', value: 12 },
          { name: '吉林', value: 14 },
          { name: '甘肃', value: 123 },
          { name: '浙江', value: 65 }
        ],
        flag: false
      },
      pieData: {
        id: 'secDis',
        name: '学生性别分布',
        data: [
          { value: 2,
            name: '正常表层细胞',
            itemStyle: {
              color: this.colors[0]
            } },
          { value: 3,
            name: '正常中底层细胞',
            itemStyle: {
              color: this.colors[1]
            } }
        ],
        flag: false
      }
    }
  },
  mounted () {
    this.user = this.getUser()
    this.getClassTeacherNum()
  },
  methods: {
    getClassTeacherNum () {
      this.$http.post('/api/getallteacher.action').then(
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
            console.log(this.teaDisData)
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
      ).bind(this)
    }
  }
}
</script>
<style>
</style>
