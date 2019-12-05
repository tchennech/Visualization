<template>
  <!-- 导航 -->
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    active-text-color="#4D7BE2"
    mode="horizontal"
    id="he"
  >
    <el-row
      type="flex"
      justify="space-between"
    >
      <el-col
        :span="4"
        class="hidden-sm-and-down parent"
      >
        <img
          id="headImg"
          class="child"
          src="../assets/img/ghead.png"
        />
      </el-col>
      <el-col>
        <div style="position:absolute;top:30%;">
          <span style="color:#909399;margin-right:15px">|</span>
          XX学校可视化平台
        </div>
      </el-col>
      <el-col :span="8">
        <el-menu-item index="4">
          <span>{{date}}</span>
          <span class="rightParts">{{loginUser.userName}}, 你好</span>
          <span class="rightParts">
            <el-button
              type="text"
              @click="logout"
            >注销</el-button>
          </span>
        </el-menu-item>
      </el-col>
    </el-row>
  </el-menu>
</template>

<script>
import "../assets/css/headLeader.css";
export default {
  name: "gHead",
  data() {
    return {
      activeIndex: "1",
      date: "",
      loginUser: {}
    };
  },
  mounted() {
    this.date = new Date().toLocaleDateString()
    this.loginUser = this.getUser()
  },
  methods: {
    logout() {
      this.delCookie("user")
      this.$router.push('/login')
    }
  }
};
</script>
