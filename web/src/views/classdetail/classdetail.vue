<template>
  <!-- 1295px -->
  <div>
    <gHead activeIndex='3'></gHead>
    <el-row :gutter="0">
      <el-col :span="2"
              :offset="2">
        <div>
          <img src='../../assets/img/boy.png'
               style="height: 120px;" />
        </div>
      </el-col>
      <el-col :span="3">
        <div class='name'>{{stuname}}</div>
      </el-col>
      <el-col :span="2"
              class="seaTex">
        <el-input placeholder="请输入学生学号"
                  v-model="input2"
                  clearable>
        </el-input>
      </el-col>
      <el-col :span="2"
              class="seaButton">
        <el-button type="primary"
                   v-on:click="search">查找</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="2"
              :offset="2">
        <div style="overflow:hidden;">
          <el-table :data="tableData">
            <el-table-column prop="pro"
                             label="科目">
            </el-table-column>
            <el-table-column prop="tea"
                             label="教师">
            </el-table-column>
          </el-table>
        </div>
      </el-col>
      <el-col :span="6">
        <!-- <div>语文</div> -->
        <lineChart :name='"语文"'
                   :data='lines[0].data'
                   :xAxis='lines[0].xAxis'
                   :text="'语文'"
                   v-if="showChart">
        </lineChart>
        <lineChart :name='"数学"'
                   :data='lines[1].data'
                   :xAxis='lines[1].xAxis'
                   :text="'数学'"
                   v-if="showChart">
        </lineChart>
      </el-col>
      <el-col :span="6">
        <lineChart :name='"英语"'
                   :data='lines[2].data'
                   :xAxis='lines[2].xAxis'
                   :text="'英语'"
                   v-if="showChart">
        </lineChart>
        <lineChart :name='"生物"'
                   :data='lines[3].data'
                   :xAxis='lines[3].xAxis'
                   :text="'生物'"
                   v-if="showChart">
        </lineChart>
      </el-col>
      <el-col :span="6">
        <lineChart :name='"物理"'
                   :data='lines[4].data'
                   :xAxis='lines[4].xAxis'
                   :text="'物理'"
                   v-if="showChart">
        </lineChart>
        <lineChart :name='"化学"'
                   :data='lines[5].data'
                   :xAxis='lines[5].xAxis'
                   :text="'化学'"
                   v-if="showChart">
        </lineChart>
      </el-col>

    </el-row>
  </div>
</template>
<script>
import lineChart from '@/components/lineChart.vue'
import gHead from '@/components/head.vue'
import '../../assets/css/exam_detail.css'
export default {
  components: {
    gHead,
    lineChart
  },
  data () {
    return {
      showChart: false,
      lines: [
        {
          name: '语文',
          xAxis: ['1'],
          data: [1]
        }, {
          name: '英语',
          xAxis: [],
          data: []
        }, {
          name: '数学',
          xAxis: [],
          data: []
        }, {
          name: '化学',
          xAxis: [],
          data: []
        }, {
          name: '物理',
          xAxis: [],
          data: []
        }, {
          name: '生物',
          xAxis: [],
          data: []
        }
      ],
      projects: ['语文', '英语', '数学', '化学', '物理', '生物'],
      tableData: [
      ],
      input2: null,
      stuname: '输入学生学号'
    }
  },
  mounted () {
  },
  methods: {
    search: function (event) {
      var indexofChart = 0
      this.showChart = false
      let _this = this
      const id = this.input2
      // this.lines[0].flag=false;

      let promise = new Promise(function (resolve, reject) {
        _this.$http.get('/api/selectStunamebyid.action?id=' + id).then(
          function (res) {
            if (res.bodyText === '') { alert('请输入正确的学号') } else {
              _this.stuname = res.bodyText
              _this.$http.get('/api/selectteacherbystupro.action?id=' + id).then(
                function (res) {
                  let result = JSON.parse(JSON.parse(res.bodyText))
                  _this.tableData = [{ pro: '语文', tea: result[0] },
                    { pro: '英语', tea: result[1] }, { pro: '数学', tea: result[2] },
                    { pro: '化学', tea: result[3] }, { pro: '物理', tea: result[4] },
                    { pro: '生物', tea: result[5] }
                  ]
                }
              )

              this.projects.forEach((item) => {
                this.$http.get('/api/selectgradebyid.action?id=' + id + '&project=' + item).then(
                  function (res) {
                    let result = JSON.parse(JSON.parse(res.bodyText))
                    console.log(result)
                    let gra = []
                    let xax = []
                    for (let i = 0; i < result.length; i++) {
                      gra.push(result[i].mes_Score)
                      xax.push(String(i))
                    }
                    // this.lineData.data.push(result[i].)
                    _this.lines[indexofChart].data = gra
                    _this.lines[indexofChart].xAxis = xax
                    // _this.showChart[0]=true
                    indexofChart = indexofChart + 1
                  }
                )
              }
              )

              setTimeout(() => {
                _this.showChart = true
              }, 1000)
            }
          }
        )
      })

      // const tea='英语'
      // this.showChart=[true,false,false,false,false,false,false,false,false]
    },
    showdata: function () {

    }
  }
}
</script>
<style>
</style>
