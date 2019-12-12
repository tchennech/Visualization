<template>
  <div :id="id"
       :style="{height:height,width:width}"
       ref="myEchart">
  </div>
</template>
<script>
import echarts from 'echarts'
import 'echarts/extension/bmap/bmap.js'
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
      default: '1800px'
    },
    height: {
      type: String,
      default: '1800px'
    },
    data: {
      type: Array,
      default: []
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
    console.log(this.data)
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
        backgroundColor: 'transparent',
        title: {
          text: this.name,
          // subtext: '部分数据',
          left: 'center',
          textStyle: {
            color: '#fff'
          }
        },
        tooltip: {
          trigger: 'item'
        },
        bmap: {
          center: [105, 36],
          zoom: 5,
          roam: true,
          mapStyle: {
            // styleJson:
            styleId: 'c687cf794e6cddb155b236f7ab88d8c6'
          }
        },
        series: [{
          name: this.name,
          type: 'scatter',
          coordinateSystem: 'bmap',
          data: this.convertData(this.data.sort(function (a, b) {
            return b.value - a.value
          }).slice(0, 6)),
          symbolSize: function (val) {
            return val[2] / 10
          },
          label: {
            normal: {
              formatter: '{b}',
              position: 'right',
              show: false
            },
            emphasis: {
              show: true
            }
          },
          itemStyle: {
            normal: {
              color: '#ddb926'
            }
          }
        }]
      })
      this.bmap = this.chart.getModel().getComponent('bmap').getBMap()
      this.bmap.setMinZoom(3) // 设置地图最小缩放比例
      this.bmap.setMaxZoom(12) // 设置地图最大缩放比例
      this.bmap.addControl(new BMap.MapTypeControl()) // 不显示地图右上方的控件
      // this.bmap.addControl(new BMap.ScaleControl({ anchor: BMAP_ANCHOR_BOTTOM_LEFT })) // 在左下角显示比例尺控件
      const _this = this
      // 监听地图比例缩放， 可以根据缩放等级控制某些图标的显示
      this.bmap.addEventListener('zoomend', function () {
        _this.mapZoom = _this.bmap.getZoom()
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
      console.log('res')
      console.log(res)
      return res
    }
  }
}
</script>
