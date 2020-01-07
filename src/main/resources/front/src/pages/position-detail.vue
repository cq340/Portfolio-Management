<template>
  <div class="wrapper-2">
    <div class="performance">
      <div class="top-bar">
        <!--<el-input size="mini" class="input" v-model="input" placeholder="Input Stock" style="width: 110px"></el-input>-->
        <div class="time-picker block">
        <el-date-picker
        size="mini"
        v-model="value6"
        type="daterange"
        range-separator="To"
        start-placeholder="Start Date"
        end-placeholder="End Date">
        </el-date-picker>
        </div>
      </div>
      <div>
        <div id="c1"></div>
      </div>
    </div>
  </div>
</template>

<script>
  import G2 from '@antv/g2';
  export default {
    data() {
      return {
        stockName:'',
        startDate:new Date().getMilliseconds() - 7*24*60*60,
        endDate:new Date().getMilliseconds()
      }
    },
    watch:{

    },
    methods:{
      render(){
        var data = [
          {
            year: '1991',
            value: 3
          }, {
            year: '1992',
            value: 4
          }, {
            year: '1993',
            value: 3.5
          }, {
            year: '1994',
            value: 5
          }, {
            year: '1995',
            value: 4.9
          }];
        const chart = new G2.Chart({
          container: 'c1',
          width: 500,
          height: 200
        });
        chart.source(data);
        chart.scale('value', {
          min: 0
        });
        chart.scale('year', {
          range: [0, 1]
        });
        chart.tooltip({
          crosshairs: {
            type: 'line'
          }
        });
        chart.line().position('year*value').shape('smooth');
//        chart.point().position('year*value').size(4).shape('circle').style({
//          stroke: '#fff',
//          lineWidth: 1
//        });
        chart.render();
      },
      getPerformance(){
        let params = {
          params:{
            name:this.name,
            startDate:this.startDate,
            endDate:this.endDate
          }
        };
        PORTFOLIO.getPerformance(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){

            }
          })
      }
    },
    mounted(){
      this.render();
    }
  }
</script>

<style scoped lang="scss">
  .common{
    border: 1px solid #ececee;
    background-color: white;
    /*margin-right: 20px;*/
  }
  .wrapper-2{
    display: flex;
    /*margin-top: 10px;*/
    .performance {
      @extend .common;
      display: block;
      width: 600px;
      height: 200px;
      padding: 50px 20px;
      .top-bar {
        display: flex;
        align-items: center;
        .time-picker{
          margin-left: auto;
        }
      }
    }
  }
</style>
