<template>
  <div class="wrapper">
    <div class="">
      <!--Title-->
      <h3 class="title" align="left">Positions</h3>

      <div class="top-bar">
        <!--Buttons-->
        <div class="btn-group">
          <el-button title="back" type="success" icon="el-icon-arrow-left" circle @click="back"></el-button>
          <el-button title="buy others" type="success" icon="el-icon-plus" circle @click="linkToBuyPage"></el-button>
        </div>
        <p class="cur-cash"> Current Cash: {{ currentCash }} $</p>
      </div>


      <!--Position Table-->
      <div class="table-wrapper">
        <el-table
          class="position-table"
          stripe
          border
          :data="positions"
          style="width: 95%"
          :default-sort = "{ prop: 'positionDate', order: 'descending'}"
          align="left"
          @sort-change="handleSort"
        >
          <el-table-column
            prop="positionId"
            label="Id"
            sortable
            :width="70">
          </el-table-column>
          <el-table-column
            prop="itemName"
            label="Name"
            sortable
            :width="100">
          </el-table-column>
          <el-table-column
            prop="type"
            label="Type"
            :width="labelWidth">
          </el-table-column>
          <el-table-column
            prop="positionDate"
            label="Date"
            sortable
            :width="160"
            :formatter="dateFormat">
          </el-table-column>
          <el-table-column
            prop="qty"
            label="Qty"
            :width="80"
            sortable>
          </el-table-column>
          <el-table-column
            prop="iniPrice"
            label="Initial Price($)"
            :width="labelWidth">
          </el-table-column>
          <el-table-column
            prop="curPrice"
            label="Current Price($)"
            :width="labelWidth">
          </el-table-column>
          <el-table-column
            prop="totalValue"
            label="Total Value($)"
            :width="labelWidth">
          </el-table-column>
          <el-table-column label="Operate">
            <template slot-scope="scope">
              <el-button size="mini" @click="detail(scope.row.id)">Detail</el-button>
              <el-button size="mini" type="success" @click="buy(scope.row)">Buy</el-button>
              <el-button size="mini" type="danger" @click="sell(scope.row)">Sell</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!--Position Detail-->
      <el-dialog align="left" title="Performance" :visible.sync="detailDialogVisible" width="50%" style="height: 700px">
        <iframe src="http://localhost:8080/#/positionDetail" width="800" height="400" frameborder="0" scrolling="auto" ></iframe>
      </el-dialog>

      <!-- Buy Form -->
      <el-dialog align="left" title="Buy" :visible.sync="buyFormVisible">
        <el-form :model="form">
          <el-form-item label="Name" :label-width="formLabelWidth">
            <el-input v-model="form.name" disabled></el-input>
          </el-form-item>
          <el-form-item label="price($)" :label-width="formLabelWidth">
            <el-input v-model="form.price" disabled></el-input>
          </el-form-item>
          <el-form-item label="Qty" :label-width="formLabelWidth">
            <el-input v-model="form.qty"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="buyFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="submitBuyForm">Confirm</el-button>
        </div>
      </el-dialog>

      <!-- Sell Form -->
      <el-dialog align="left" title="Sell" :visible.sync="sellFormVisible">
        <el-form :model="form">
          <el-form-item label="Name" :label-width="formLabelWidth">
            <el-input v-model="form.name" disabled></el-input>
          </el-form-item>
          <el-form-item label="Price($)" :label-width="formLabelWidth">
            <el-input v-model="form.price" disabled></el-input>
          </el-form-item>
          <el-form-item label="Qty" :label-width="formLabelWidth">
            <el-input v-model="form.qty"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="sellFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="submitSellForm">Confirm</el-button>
        </div>
      </el-dialog>

      <!-- Pagination-->
      <div class="page-container">
        <el-tag class="amount">Page size : {{ pageSize }} , Total data: {{ total }} </el-tag>
        <el-pagination layout="prev, pager, next" background @current-change="handleCurrentChange" :total="pageNum" class="pagination"></el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
  import POSITION from '../api/position'
  import PORTFOLIO from '../api/portfolio'
  import PREDICTION from '../util/prediction'
  import G2 from '@antv/g2';
  import { format } from '../util/date'
  export default {
    props: {
      portfolioId: String
    },
    data() {
      return {
        positions: [],
        form:{
          positionId:null,
          name:'',
          price:'',
          qty:null,
          type:''
        },
        currentCash:0,
        total:0,
        pageNum:0,
        pageSize:4,
        detailDialogVisible:false,
        buyFormVisible:false,
        sellFormVisible:false,
        labelWidth:"110",
        formLabelWidth:"120",
        order_type:'position_id',
        sequence:"DESC"
      }
    },
    methods:{
      handleCurrentChange(page) {
        this.getPositions(this.pageSize * (page - 1));
      },
      getPositions(start = 0){
        let params = {
          params:{
            from:start,
            size:this.pageSize,
            portId: this.portfolioId,
            order_type:this.order_type,
            sequence:this.sequence
          }
        };
        POSITION.getPositions(this.portfolioId ,params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)) {
              this.total = rep.data.size;
              this.pageNum = rep.data.size / this.pageSize * 10;
              this.positions = rep.data.positions;
              this.currentCash = rep.data.currentCash;
            }
          })
      },
      buy(row){
        this.form.name = row.itemName;
        this.form.price = row.curPrice;
        this.form.type = row.type;
        this.buyFormVisible = true;
      },
      submitBuyForm(){
        let params = new URLSearchParams();
        params.append('name', this.form.name);
        params.append('qty', this.form.qty);
        params.append('type', this.form.type);
        params.append('portfolio_id', this.portfolioId);
        PORTFOLIO.buy(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.$message.success("success");
              this.getPositions();
            }
            this.buyFormVisible = false;
          })
      },
      sell(row){
        this.form.name = row.itemName;
        this.form.price = row.curPrice;
        this.form.type = row.type;
        this.form.positionId = row.positionId;
        this.sellFormVisible = true;
      },
      submitSellForm(){
        let params = new URLSearchParams();
        params.append('name', this.form.name);
        params.append('qty', this.form.qty);
        params.append('position_id', this.form.positionId);
        params.append('type', this.form.type);
        POSITION.sell(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.$message.success("success");
              this.getPositions();
            }
            else {
              this.$message.error(rep.message);
            }
            this.sellFormVisible = false;
          })
      },
      linkToBuyPage(){
        this.$router.push('/main/stock/' + this.portfolioId);
      },
      detail(positionId){
        POSITION.getPositionDetail(positionId)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
            }
            else {
              this.$message.error(rep.message)
            }
          });
        this.detailDialogVisible = true;
      },
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
      back() {
        this.$router.go(-1);
      },
      dateFormat(row, column) {
        let date = row[column.property];
        if (date === undefined) {
          return "";
        }
        return format(date);
      },
      handleSort(info){
        if (info.prop === 'positionId'){
          this.order_type = 'position_id';
        }
        else if(info.prop === 'positionName') {
          this.order_type = 'position_name';
        }
        else if(info.prop === 'qty'){
          this.order_type = 'qty';
        }
        if (info.order === 'descending'){
          this.sequence = "DESC";
        }
        else if(info.order === 'ascending') {
          this.sequence = "ASC";
        }
        this.getPositions();
      }
    },
    mounted(){
      this.getPositions();
    }
  }
</script>

<style scoped lang="scss">
  @import "../assets/css/common";
  .wrapper {
    background-color: white;
    width: 100%;
    .top-bar {
      display: flex;
      align-items: center;
      .cur-cash {
        margin-left: auto;
        margin-right: 40px;
        color:#b6b6b6;
      }
    }
    .table-wrapper {
      height: 350px;
      .position-table {
        margin: 20px;
      }
    }
  }
</style>
