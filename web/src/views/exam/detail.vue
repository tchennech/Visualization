<template>
  <div>
    <barChart :name='"aass"'>
    </barChart>
  </div>
</template>

<script>
import barChart from '@/components/barChart.vue'
export default {
  components: {
    barChart
  },
  data () {
    return {
      username: '',
      pass: ''
    }
  },
  mounted () {
   
  },
  methods: {
    getClassTeacherNum () {

    }
  }
}
</script>
<style>
</style>
