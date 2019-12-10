<template>
  <div>
    <gHead activeIndex='1'></gHead>
    <div class='oddDiv'>
      <div class='middleConten center'>

        <el-card shadow="always">
          <div class="title">
            各科教师分布
          </div>
          <el-divider></el-divider>
          <barChart :name="'教师各科数量分布'"
                    :id="teaDisData.id"
                    :data="teaDisData.data"
                    :xLabel="teaDisData.xLabel">
          </barChart>
        </el-card>
      </div>
    </div>
    <div class='evenDiv'>
      2
    </div>
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
        xLabel: ['语文', '数学', '英语', '物理', '化学', '生物']
      }
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
