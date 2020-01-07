<template>
  <div>
    <div>
      <div class="text" align="left">
        <span class="name">{{ number }}.{{ name }}</span>
        <span class="percentage">{{ value }}</span>
      </div>
      <el-progress :percentage="percentage" :showText="false"></el-progress>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
      }
    },
    props:{
      number:Number,
      percentage:Number,
      value:Number,
      name:String
    }
  }
</script>

<style scoped lang="scss">
.text{
  .name{
    font-size: 6px;
  }
  .percentage{
    float: right;
    font-size: 6px;
  }
}
</style>
