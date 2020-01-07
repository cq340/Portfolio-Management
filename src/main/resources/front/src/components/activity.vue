<template>
  <div class="wrapper">
    <i class=""></i>
    <div class="wrapper-2" align="left">
      <div class="time-wrapper">
        <p class="number">{{ message1 }} {{ time }}</p>
        <p>{{ message2 }}</p>
      </div>
      <div class="person-wrapper">
        <i class="user-icon"></i>
        <div class="person-detail" align="right">
          <p>{{ message3 }}</p>
          <p>{{ message4 }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {}
    },
    props:{
      message1:String,
      message2:String,
      message3:String,
      message4:String,
      time:String
    }
  }
</script>

<style scoped lang="scss">
  $icon-h: 18px;
  $icon-w: 18px;
  p{
    padding: 0;
    margin: 0;
    font-size: 5px;
  }
  .wrapper{
    .wrapper-2{
      display: flex;
      justify-content: space-between;
      padding: 8px 0;
      border-bottom: 1px solid  #f2f3f5;
      .time-wrapper{
        .number{
          color: #f89a73;
        }
      }
      .person-wrapper{
        display: flex;
        align-items: center;
        .user-icon{
          background-image: url("../assets/svg/user.svg");
          background-size: $icon-w $icon-h;
          width: $icon-w;
          height: $icon-h;
          display: inline-block;
          margin: 0 15px 0 4px;
        }
        .person-detail{
          p{

          }
        }
      }
    }
  }
</style>
