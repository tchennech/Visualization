<template>
  <!-- 1295px -->
  <div>
    <gHead activeIndex='3'></gHead>
  <el-row :gutter="0" style="margin-top: 20px">
    <el-col :span="12"
            :offset="4"
            >
            班级:
      <el-select v-model="select"   placeholder="请选择级段">
        <el-option label="高一" value="高一"></el-option>
        <el-option label="高二" value="高二"></el-option>
        <el-option label="高三" value="高三"></el-option>
      </el-select>
      <el-select v-model="select2"   placeholder="请选择班级">
        <el-option label="一班" value="(01)"></el-option>
        <el-option label="二班" value="(02)"></el-option>
        <el-option label="三班" value="(03)"></el-option>
        <el-option label="四班" value="(04)"></el-option>
        <el-option label="五班" value="(05)"></el-option>
        <el-option label="六班" value="(06)"></el-option>
        <el-option label="七班" value="(07)"></el-option>
        <el-option label="八班" value="(08)"></el-option>
        <el-option label="九班" value="(09)"></el-option>
        <el-option label="十班" value="(10)"></el-option>
      </el-select>
    </el-col>
    <el-col :span="2">
       <el-button v-on:click="search" type="primary">班级检索</el-button>
    </el-col>
  </el-row>
  <el-col :offset="2">
      <barChart :name="'各班级数量'"
              :id="teaDisData.id"
              :data="teaDisData.data"
              :xLabel="teaDisData.xLabel"
              :text="'级段各班级数量'"
              :width='"1800px"'
              v-if='teaDisData.flag'>
    </barChart>
  </el-col>
  <el-row>
    <el-col 
    :span="8"
    :offset="4"
    >
      <pieCHart :name="pieSexData.name"
              :id="pieSexData.id"
              :data="pieSexData.data"
              v-if='pieSexData.flag'>
    </pieCHart>
    </el-col>
    <el-col 
    :span="4"
    :offset="2"
    >
      <pieCHart :name="pieBirthData.name"
              :id="pieBirthData.id"
              :data="pieBirthData.data"
              v-if='pieBirthData.flag'
              >
    </pieCHart>
    </el-col>
  </el-row>
  <el-row>
    <el-col 
    :span="8"
    :offset="4"
    >
      <pieCHart :name="pieNameData.name"
              :id="pieNameData.id"
              :data="pieNameData.data"
              v-if='pieNameData.flag'
              >
    </pieCHart>
    </el-col>
    <el-col 
    :span="4"
    :offset="2"
    >
      <pieCHart :name="pieLocationData.name"
              :id="pieLocationData.id"
              :data="pieLocationData.data"
              v-if='pieLocationData.flag'
              >
    </pieCHart>
    </el-col>
  </el-row>

  </div>
</template>
<script>
import gHead from '@/components/head.vue'
import barChart from '@/components/barChart.vue'
import pieCHart from '@/components/pieChart.vue'
export default {
  components: {
    gHead,
    barChart,
    pieCHart
  },
  data () {
    return {
      select:null,
      select2:null,
      teaDisData:{
        id:"CLASS_DETAIL",
        data:[],
        xLabel:[],
        flag: false
      },
      pieSexData: {
        id: 'sexDis',
        name: '班级学生性别分布',
        data: [{ value: 335, name: '男' },
          { value: 310, name: '女' }
        ],
        flag: false
      },
      pieBirthData: {
        id: 'sexDis',
        name: '班级学生出生年份分布',
        data: [{ value: 335, name: '男' },
          { value: 310, name: '女' }
        ],
        flag: false
      },
      pieNameData: {
        id: 'sexDis',
        name: '班级学生姓氏分布',
        data: [{ value: 335, name: '男' },
          { value: 310, name: '女' }
        ],
        flag: false
      },
      pieLocationData: {
        id: 'sexDis',
        name: '班级学生生源地分布',
        data: [{ value: 335, name: '男' },
          { value: 310, name: '女' }
        ],
        flag: false
      }
    }
  },
  mounted () {
    // this.classstudents()
  },
  methods: {
    search:function(){
      if(this.select===null || this.select2===null)
          alert("请选择正确的班级");
      else{
        let classname=this.select+this.select2;
        this.$http.get('/api//selectStubyClassname.action?classname=' + classname).then(
          function (res) {
            let result = JSON.parse(JSON.parse(res.bodyText))
            let res2=JSON.parse(result.data)
            this.pieSexData.data=[{ value: res2.male, name: '男' },
                  { value: res2.famale, name: '女' }]
                   this.pieSexData.flag=true

            this.pieLocationData.data=[{ value: res2.location.宁波, name: '宁波' },
                  { value: res2.location.其他, name: '其他' }]
                   this.pieLocationData.flag=true
            this.pieBirthData.data=[{ value: res2.brith_year[2000], name: '2000' },
                 { value: res2.brith_year[2001], name: '2001' },
                 { value: res2.brith_year[2002], name: '2002' }]
                this.pieBirthData.flag=true
                let names=[]
            for(let key in res2.name){
              names.push({value: res2.name[key], name:key})
            }
              this.pieNameData.data=names
              this.pieNameData.flag=true
              console.log(res2)
          })
      }
    },
    classstudents:function(){
      let _this=this
      
        this.$http.get('/api//selectClassStu.action').then(
          function (res) {
            let result = JSON.parse(JSON.parse(res.bodyText))
            console.log(result[0].num,result[0].cla_Name)
            for(let i =0 ; i < result.length;i++)
            {
              this.teaDisData.data.push(result[i].num)
              this.teaDisData.xLabel.push(result[i].cla_Name)
            }
            this.teaDisData.flag=true;

          })
    }
    
  }
}
</script>
<style>
</style>
