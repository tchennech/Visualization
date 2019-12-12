<template>
  <!-- 导航 -->
  <el-menu :default-active="activeIndex"
           class="el-menu-demo"
           active-text-color="#4D7BE2"
           mode="horizontal"
           id="he"
           @select="handleSelect">
    <el-row type="flex"
            justify="space-between">
      <el-col :span="3"
              class="hidden-sm-and-down parent">
        <img id="headImg"
             class="child"
             src="../assets/img/ghead.png" />
      </el-col>
      <el-col :span="2">
        <div style="position:absolute;top:30%;">
          <span style="color:#909399;margin-right:15px">|</span>
          XX学校可视化平台
        </div>
      </el-col>
      <el-col :span="3">
        <el-menu-item index="1">首页</el-menu-item>
      </el-col>
      <el-col :span="3">
        <el-submenu index="2">
          <template slot="title">检索功能</template>
          <el-menu-item index="2-1">班级检索</el-menu-item>
          <el-menu-item index="2-2">学生检索</el-menu-item>
          <el-menu-item index="2-3">教师检索器</el-menu-item>
        </el-submenu>
      </el-col>
      <el-col :span="3">
        <el-menu-item index="3">考试</el-menu-item>
      </el-col>
      <el-col :span="3">
        <el-menu-item index="4">考勤</el-menu-item>
      </el-col>
      <el-col :span="3">
        <el-menu-item index="4">消费</el-menu-item>
      </el-col>
      <el-col :span="4">
        <el-menu-item index="4">
          <span>{{date}}</span>
          <span class="rightParts">{{loginUser.userName}}, 你好</span>
          <span class="rightParts">
            <el-button type="text"
                       @click="logout">注销</el-button>
          </span>
        </el-menu-item>
      </el-col>
    </el-row>
  </el-menu>
</template>

<script>
import '../assets/css/headLeader.css'
export default {
  name: 'gHead',
  props: {
    activeIndex: {
      type: String,
      default: '1'
    }
  },
  data () {
    return {
      date: '',
      loginUser: {}
    }
  },
  mounted () {
    this.date = new Date().toLocaleDateString()
    this.loginUser = this.getUser()
  },
  methods: {
    logout () {
      this.delCookie('user')
      this.$router.push('/login')
    },
    handleSelect (key, keyPath) {
      if (key === '1') {
        this.$router.push('/')
      } else if (key === '3') {
        this.$router.push('/exam')
      }
    }
  }
}
</script>
