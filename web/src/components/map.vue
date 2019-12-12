<template>
  <div :id="id"
       :style="{height:height,width:width}"
       ref="myEchart">
  </div>
</template>
<script>
import echarts from 'echarts'
import china from '../../static/china'
export default {
  name: 'mapChart',
  props: {
    name: {
      type: String,
      default: '统计'
    },
    id: {
      type: String,
      default: 'yourID'
    },
    width: {
      type: String,
      default: '800px'
    },
    height: {
      type: String,
      default: '500px'
    },
    data: {
      type: Array,
      default: null
    }
  },
  data () {
    return {
      chart: null,
      geoCoordMap: {
        '宁波': [121.56, 29.86],
        '温州': [120.65, 28.01],
        '台州': [121.420757, 28.656386],
        '辽宁': [123.38, 41.8],
        '安徽': [117.27, 31.86],
        '福建': [119.3, 26.08],
        '河南': [113.65, 34.76],
        '湖北': [114.31, 30.52],
        '四川': [104.06, 30.67],
        '陕西': [108.95, 34.27],
        '江苏': [118.78, 32.04],
        '山东': [117, 36.65],
        '吉林': [125.35, 43.88],
        '黑龙江': [126.63, 45.75],
        '甘肃': [103.73, 36.03],
        '浙江': [120.19, 30.26]
      },
      bmap: {}
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
        geo: {
          map: 'china', // 地图类型为中国地图,要是世界那就是world,要是省市区：例如beijing、shanghai
          itemStyle: { // 定义样式
            normal: { // 普通状态下的样式
              areaColor: '#F8EECA',
              borderColor: '#000'
            },
            emphasis: { // 高亮状态下的样式
              areaColor: '#e9fbf1'
            }
          }
        },
        backgroundColor: '#ffffff',
        title: {
          text: this.name,
          // subtext: '部分数据',
          left: 'center',
          textStyle: {
            color: '#003f43'
          }
        },
        tooltip: {
          trigger: 'item',
          textStyle: {
            align: 'left'
          },
          formatter: function (obj) {
            console.log(obj)
            return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">' +
              obj.seriesName + ' ' +
              '</div>' +
              obj.name + '<br>' +
              obj.value[2] + '人<br>'
          }
        },
        color: 'red',
        series: [{
          name: this.name,
          type: 'scatter',
          coordinateSystem: 'geo',
          data: this.convertData(this.data),
          symbolSize: [20, 20],
          symbol: 'pin',
          itemStyle: {
            normal: {
              color: '#ddb926'
            }
          }
        }],
        // 添加视觉映射组件
        visualMap: {
          type: 'continuous', // 连续型
          min: 0, // 值域最小值，必须参数
          max: 820, // 值域最大值，必须参数
          calculable: false, // 是否启用值域漫游
          inRange: {
            color: ['lightskyblue', 'yellow', 'orangered']
            // 指定数值从低到高时的颜色变化
          },
          textStyle: {
            color: '#fff' // 值域控件的文本颜色
          }
        }
      })
    },
    convertData (data) {
      let res = []
      for (let i = 0; i < data.length; i++) {
        let geoCoord = this.geoCoordMap[data[i].name]
        if (geoCoord) {
          res.push({
            name: data[i].name,
            value: geoCoord.concat(data[i].value)
          })
        }
      }
      return res
    }
  }
}
</script>
