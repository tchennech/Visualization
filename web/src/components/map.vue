<template>
  <div :id="id"
       :style="{height:height,width:width}"
       ref="myEchart">
  </div>
</template>
<script>
import echarts from 'echarts'
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
      default: '700px'
    },
    height: {
      type: String,
      default: '700px'
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
      }
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
          center: [104.114129, 37.550339],
          zoom: 5,
          roam: true,
          mapStyle: {
            styleJson: [
              {
                'featureType': 'water',
                'elementType': 'all',
                'stylers': {
                  'color': '#044161'
                }
              },
              {
                'featureType': 'land',
                'elementType': 'all',
                'stylers': {
                  'color': '#004981'
                }
              },
              {
                'featureType': 'boundary',
                'elementType': 'geometry',
                'stylers': {
                  'color': '#064f85'
                }
              },
              {
                'featureType': 'railway',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'highway',
                'elementType': 'geometry',
                'stylers': {
                  'color': '#004981'
                }
              },
              {
                'featureType': 'highway',
                'elementType': 'geometry.fill',
                'stylers': {
                  'color': '#005b96',
                  'lightness': 1
                }
              },
              {
                'featureType': 'highway',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'arterial',
                'elementType': 'geometry',
                'stylers': {
                  'color': '#004981'
                }
              },
              {
                'featureType': 'arterial',
                'elementType': 'geometry.fill',
                'stylers': {
                  'color': '#00508b'
                }
              },
              {
                'featureType': 'poi',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'green',
                'elementType': 'all',
                'stylers': {
                  'color': '#056197',
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'subway',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'manmade',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'local',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'arterial',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              },
              {
                'featureType': 'boundary',
                'elementType': 'geometry.fill',
                'stylers': {
                  'color': '#029fd4'
                }
              },
              {
                'featureType': 'building',
                'elementType': 'all',
                'stylers': {
                  'color': '#1a5787'
                }
              },
              {
                'featureType': 'label',
                'elementType': 'all',
                'stylers': {
                  'visibility': 'off'
                }
              }
            ]
          }
        },
        series: [{
          name: this.name,
          type: 'scatter',
          coordinateSystem: 'bmap',
          data: this.convertData(this.data),
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
