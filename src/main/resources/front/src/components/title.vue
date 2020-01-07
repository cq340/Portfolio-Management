<template>
  <p class="title" align="left">
    {{ title }}
  </p>
</template>

<script>
  export default {
    data() {
      return {

      }
    },
    props:{
      title:String
    }
  }

</script>

<style lang="scss" scoped>
  @import "../assets/css/common.scss";
  .title {
    @include vertical-center(40px);
    @include size-color(1rem, $font-color-3);
    background-color: #ecf8ff;
    border-left: 4px solid #50bfff;
    border-radius: 5px;
    padding-left: 20px;
  }
</style>
