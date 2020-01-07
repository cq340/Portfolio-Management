<template>
  <div class="wrapper">
    <div class="left">
      <i :class="iconClass"></i>
    </div>
    <div class="right">
      <p class="card-name" align="left">{{ cardName }}</p>
      <div class="data-wrapper">
        <span class="amount">{{ amount }}</span>
        <i class="arrow" :class="arrowIcon"></i>
      </div>
      <p class="des" align="left" :class="desColor">{{ des }}</p>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        arrowIcon:"",
        iconClass:"indice-icon",
        desColor:""
      }
    },
    props:{
      cardName:String,
      amount:Number,
      des:String,
      x:Boolean
    },
    mounted(){
      if (this.x){
        this.arrowIcon = "arrow-up up";
        this.desColor = "up"
      }
      else{
        this.arrowIcon = "arrow-down drop";
        this.desColor = "drop"
      }
    }
  }
</script>

<style scoped lang="scss">
  $icon-h: 24px;
  $icon-w: 24px;
  .wrapper {
    display: flex;
    .left{
      margin: auto auto;
    }
    .right{
      margin-right: auto;
    }
    .card-name{
      color: #b6b6b6;
      font-size: 10px;
      margin: 0 auto;
    }
    .data-wrapper{
      display: flex;
      .amount{
        font-size: 35px;
        font-weight: 100;
        margin: 0 auto;
      }
      .arrow{
        margin-right: auto;
      }
    }
    .des{
      margin: 0 auto;
      font-size: 6px;
      font-weight: bold;
    }
    .up {
      color: #ff916e;
    }
    .drop {
      color: #10c7b1;
    }
    .indice-icon {
      background-image: url("../assets/svg/indice.svg");
      background-size: $icon-w $icon-h;
      width: $icon-w;
      height:$icon-h;
      display: inline-block;
      margin: 0 15px 0 4px;
    }
    .arrow-up{
      background-image: url("../assets/svg/up.svg");
      @extend .indice-icon
    }
    .arrow-down{
      background-image: url("../assets/svg/drop.svg");
      @extend .indice-icon
    }
  }
</style>
