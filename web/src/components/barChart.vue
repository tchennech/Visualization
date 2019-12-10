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
  name: 'barChart',
  props: {
    name: {
      type: String,
      default: '统计'
    },
    id: {
      type: String,
      default: 'barChart'
    },
    width: {
      type: String,
      default: '500px'
    },
    height: {
      type: String,
      default: '500px'
    },
    xLabel: {
      type: Array,
      default: []
    },
    color: {
      type: String,
      default: '#57C4A9'
    },
    yLabel: {
      type: String,
      default: 'value'
    },
    data: {
      type: Array,
      default: []
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
        color: [this.color],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        xAxis: [
          {
            data: this.xLabel,
            axisTick: {
              alignWithLabel: true
            }
          }
        ],
        yAxis: [
          {
            type: this.yLabel
          }
        ],
        series: [{
          name: this.name,
          type: 'bar',
          barWidth: '60%',
          data: this.data
        }]
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
