<template>
  <div>
    <div :id="id"
         :style="{height:height,width:width}"
         ref="myEchart">
    </div>
  </div>
</template>

<script>
import echarts from 'echarts'
export default {
  name: 'barPolar',
  props: {
    name: {
      type: String,
      default: '考勤时间分布'
    },
    id: {
      type: String,
      default: 'barPolarChart'
    },
    width: {
      type: String,
      default: '310px'
    },
    height: {
      type: String,
      default: '400px'
    },
    xLabel: {
      type: Array
    },
    legend: {
      type: Array
    },
    data: {
      type: Array
    }
  },
  data () {
    return {
      chart: null
    }
  },
  mounted () {
    this.initChart()
  },
  beforeDestroy () {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    ftime (value, index) {
      // 格式化成月/日，只在第一个刻度显示年份
      var hour = parseInt(value / 3600)
      var mins = parseInt((value % 3600) / 60)
      var texts = [hour, mins]
      return texts.join(':')
    },
    initChart () {
      this.chart = echarts.init(this.$refs.myEchart)
      // 把配置和数据放这里
      let _this = this
      this.chart.setOption({
        title: {
          text: this.name
        },
        legend: {
          show: true,
          data: this.legend,
          top: '20px'
        },
        grid: {
          top: 100
        },
        barMaxWidth: 5,
        angleAxis: {
          type: 'value',
          min: this.xLabel[0],
          max: this.xLabel[1],
          axisLabel: { formatter: this.ftime }
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          },
          formatter: function (val) {
            let result = _this.ftime(val[0].value[1], 0) + '<br>'
            for (let index in val) {
              result += val[index].marker + ' ' +
                val[index].seriesName + ': ' +
                val[index].value[0] + '<br>'
            }
            return result
          }
        },
        radiusAxis: {
          type: 'value',
          max: 50
        },
        polar: {
        },
        series: this.data
        // [{
        //   type: 'bar',
        //   data: data[0],
        //   coordinateSystem: 'polar',
        //   stack: 'as',
        //   name: '价格范围'
        //   // Set `large` for large data amount
        // }, {
        //   type: 'bar',
        //   data: data[1],
        //   coordinateSystem: 'polar',
        //   stack: 'as',
        //   name: '均值'
        //   // Set `large` for large data amount
        // }]
      })
    }
  }
}
</script>

<style>
* {
  text-decoration: none;
  margin: 0;
  padding: 0;
}
</style>
