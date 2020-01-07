<template>
  <div class="wrapper">
    <p class="dashboard">Dashboard</p>
    <!--<MyTitle title="Dashboard"></MyTitle>-->
    <div class="card-list">
      <Card v-for="i in indices" class="card" :cardName="i.indiciesName" :amount="i.price" :des="i.changeRate" :x="i.x"></Card>
    </div>

    <div class="wrapper-2">
      <div class="performance">
        <div class="top-bar">
          <p class="title" align="left">Performance</p>
          <div class="right">
            <el-dropdown class="select" @command="handleCommand">
            <span class="el-dropdown-link">
              {{ itemType }}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="stocks">Stock</el-dropdown-item>
                <el-dropdown-item  command="commodities">Commodity</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <el-input size="mini" class="input" v-model="itemName" placeholder="Input item"></el-input>
          </div>
        </div>
        <div>
          <div id="c1"></div>
        </div>
        <div class="bottom">
          <div class="item">
            <p class="price"> {{ todayPrice }}</p>
            <p class="label">  Today </p>
          </div>
          <div class="item">
            <p class="price"> {{ yesterdayPrice }}</p>
            <p class="label">  Yesterday </p>
          </div>
        </div>
      </div>

      <div class="rank">
        <div class="top-bar">
          <p class="title" align="left">Rank</p>
          <!--<p class="view-all" @click="viewAll">View All</p>-->
        </div>
        <bar v-for="(r, index) in ranks" class="bar" :number=(index+1) :percentage=r.value :value=r.percent :name=r.userName></bar>
      </div>
    </div>
  </div>
</template>

<script>
  import Card from '../components/card.vue'
  import Bar from '../components/bar.vue'
  import Activity from '../components/activity.vue'
  import MyTitle from '../components/title.vue'
  import G2 from '@antv/g2';
  import PORTFOLIO from '../api/portfolio'
  import PREDICTION from '../util/prediction'
  export default {
    data() {
      return {
        date:'',
        indices:[],
        ranks:[],
        todayPrice:200,
        yesterdayPrice:300,
        itemType:'commodities',
        itemName:'COFF',
        startDate:'',
        endDate:'',
      }
    },
    watch:{
      itemName(){
        this.getPerformance();
      }
    },
    methods:{
      init(){
//        this.startDate = this.dateFormatter(new Date().getTime() - 7*24*60*60*1000);
//        this.endDate = this.dateFormatter(new Date().getTime());
        this.startDate = '2017/12/11';
        this.endDate = '2017/12/15';
      },
      dateFormatter(time){
        let date = new Date(time);
        let year = date.getFullYear(),
          month = date.getMonth() + 1,
          day = date.getDate();
        return year + '/' + month + '/' + day;
      },
      render(data){
        const chart = new G2.Chart({
          container: 'c1',
          width: 500,
          height: 250
        });
        chart.source(data);
        chart.scale('value', {
//          min: 0,
        });
        chart.scale('day', {
          range: [0, 1]
        });
        chart.tooltip({
          crosshairs: {
            type: 'line'
          }
        });
        chart.line().position('day*value').shape('smooth');
        chart.render();
      },
      getIndices(){
        PORTFOLIO.getIndices()
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.indices = rep.data;
              console.log(this.indices)
            }
          })
          .catch(error =>{
            console.log(error)
          })
      },
      getPerformance(){
        let params = {
          params:{
            startDate:this.startDate,
            endDate:this.endDate
          }
        };
        PORTFOLIO.getPerformance(this.itemType, this.itemName, params)
          .then( rep => {
            if(PREDICTION.httpSuccess(rep)){
              let _data = [];
              let date =  this.$moment(this.startDate, "YYYY/MM/DD");
              for(let i = 0; i < rep.data.length; i++){
                _data.push({
                  day: this.$moment(date.add(1, 'day')).format("YYYY/MM/DD"),
                  value: rep.data[i]
                } )
              }
              this.render(_data);
            }
          });
      },
      handleCommand(command){
        this.itemType = command;
      },
      getRanks(){
        PORTFOLIO.getRank()
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              let highest;
              if (rep.data > 0) {
                highest = rep.data[0].percent;
              }
              if(highest <= 0) {
                for(let i = 0; i< rep.data.length; i++ ){
                  rep.data[i].value = 0;
                }
              }
              else{
                for(let i = 0; i< rep.data.length; i++ ){
                  if(rep.data[i].percent > 0) {
                    rep.data[i].value = rep.data[i].percent / highest * 100;
                  }
                  else{
                    rep.data[i].value = 0;
                  }
                }
              }
              this.ranks = rep.data;
              console.log(this.ranks);
            }
          })
      }
    },
    components:{
      Card,
      Bar,
      Activity,
      MyTitle
    },
    mounted(){
      this.init();
      this.getIndices();
      this.getPerformance();
      this.getRanks();
    }
  }
</script>

<style lang="scss" scoped>
  /*@import "../assets/css/common";*/
  .common{
    border: 1px solid #ececee;
    background-color: white;
    margin-right: 20px;
  }
  .wrapper{
    .dashboard{
      text-align: left;
      font-weight: bold;
    }
    .card-list{
      @extend .common;
      display: flex;
      padding: 5px 20px;
      height: 90px;
      .card {
        margin: 10px auto;
      }
    }

    .wrapper-2{
      display: flex;
      margin-top: 10px;
      .performance {
        @extend .common;
        display: block;
        width: 600px;
        height: 430px;
        padding: 0 20px;
        .top-bar {
          display: flex;
          align-items: center;
          .right{
            margin-left: auto;
            .select{
              margin-right: 20px;
            }
            .input {
              width: 95px;
            }
          }
        }
        .bottom{
          display: flex;
          justify-items: center;
          p {
            padding: 0;
            margin: 0;
          }
          .item{
            margin:0 auto;
            .price{
              font-size: 40px;
            }
            .label{
              color: #b6b6b6;
              font-size: 10px;
            }
          }
        }
      }
      .rank{
        @extend .performance;
        width: 450px;
        .bar{
          margin-bottom: 20px;
        }
        .top-bar{
          display: flex;
          justify-content: space-between;
          .view-all{
            color: #729bc4;
          }
        }
      }
    }
    .title{
      font-weight: bold;
    }
  }
</style>
