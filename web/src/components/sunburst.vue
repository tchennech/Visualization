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
  name: 'sunBurst',
  props: {
    name: {
      type: String,
      default: '考勤'
    },
    id: {
      type: String,
      default: 'sunBurst'
    },
    width: {
      type: String,
      default: '700px'
    },
    height: {
      type: String,
      default: '700px'
    },
    data: {
      type: Array,
      default: null
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
      this.chart.setOption({ title: {
        text: this.name,
        textStyle: {
          fontSize: 14,
          align: 'center'
        },
        subtextStyle: {
          align: 'center'
        }
      },
      series: {
        type: 'sunburst',
        highlightPolicy: 'ancestor',
        data: this.data,
        radius: [0, '95%'],
        sort: null,
        levels: [{}, {
          r0: '15%',
          r: '35%',
          itemStyle: {
            borderWidth: 2
          },
          label: {
            rotate: 'tangential'
          }
        }, {
          r0: '35%',
          r: '70%',
          label: {
            align: 'right'
          }
        }, {
          r0: '70%',
          r: '72%',
          label: {
            position: 'outside',
            padding: 3,
            silent: false
          },
          itemStyle: {
            borderWidth: 3
          }
        }]
      }
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
