<template>
  <div :id="id"
       :style="{height:height,width:width}"
       ref="myEchart">
  </div>
</template>
<script>
import echarts from 'echarts'
export default {
  name: 'mbarChart',
  props: {
    id: {
      type: String,
      default: 'yourID'
    },
    width: {
      type: String,
      default: '350px'
    },
    height: {
      type: String,
      default: '350px'
    },
    xAxis: {
      type: Array
    },
    data: {
      type: Array
    },
    legend: {
      type: Array
    },
    title: {
      type: String
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
    initChart () {
      this.chart = echarts.init(this.$refs.myEchart)
      // 把配置和数据放这里
      this.chart.setOption({
        title: {
          text: this.title
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: this.legend
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          data: this.xAxis
        },
        yAxis: {
          type: 'value'
        },
        series: this.data
      })
    }
  }
}
</script>
