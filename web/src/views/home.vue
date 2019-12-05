<template>
  <div>
    {{user.userName}}, {{user.password}}, {{user.role}}
  </div>
</template>

<script>

export default {
  data () {
    return {
      user: {}
    }
  },
  mounted () {
    let uerTemp = this.getCookie('user')
    if (uerTemp == null || uerTemp === '' || uerTemp === undefined) {
      this.$router.push('/login')
    } else {
      this.user = JSON.parse(uerTemp)
    }
  },
  methods: {
  }
}
</script>
<style>
</style>
