<template>
  <div>
    <gHead></gHead>
  </div>
</template>

<script>
import gHead from "@/components/head.vue"
export default {
  components: {
    gHead
  },
  data () {
    return {
      user: {}
    }
  },
  mounted () {
    this.user = this.getUser()
  },
  methods: {
  }
}
</script>
<style>
</style>
