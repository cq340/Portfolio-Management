<template>
  <div class="wrapper">

    <!--Buttons-->
    <!--<div class="btn-group">-->
      <!--<el-button type="success" icon="el-icon-arrow-left" circle @click="back"></el-button>-->
    <!--</div>-->
    <div class="top-bar">
      <div class="btn-group">
        <el-button type="success" icon="el-icon-arrow-left" circle @click="back"></el-button>
      </div>
      <div class="search">
        <!--<el-input placeholder="value" v-model="value" class="input-with-select">-->
          <!--<el-select v-model="select" slot="prepend" placeholder="Select" style="width: 120px">-->
            <!--<el-option label="By Name" value="1"></el-option>-->
            <!--<el-option label="By Type" value="2"></el-option>-->
          <!--</el-select>-->
          <!--<el-button slot="append" icon="el-icon-search" @click="getItems(0)"></el-button>-->
        <!--</el-input>-->

        <el-autocomplete
          class="value"
          v-model="value"
          :fetch-suggestions="querySearch"
          placeholder="请输入内容"
          @select="handleSelect">
          <el-select v-model="select" slot="prepend" placeholder="Select" style="width: 120px">
          <el-option label="By Name" value="1"></el-option>
          <el-option label="By Type" value="2"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search" @click="getItems(0)"></el-button>
        </el-autocomplete>
      </div>
      <p class="cur-cash"> Current Cash: {{ currentCash }} $</p>
    </div>

    <div style="height: 350px">
      <el-table
        stripe
        border
        :data="stocks"
        style="width: 97%"
        :default-sort = "{ prop: 'name', order: 'descending'}"
        align="left"
        @sort-change="handleSort"
      >
        <el-table-column
          prop="name"
          label="Name"
          sortable
          :width="100">
        </el-table-column>
        <!--<el-table-column-->
        <!--prop="type"-->
        <!--label="Type"-->
        <!--sortable-->
        <!--:width="80">-->
        <!--</el-table-column>-->
        <el-table-column
          prop="date"
          label="Date"
          sortable
          :width="155"
          :formatter="dateFormat">
        </el-table-column>
        <el-table-column
          prop="price"
          label="Price($)"
          sortable
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="openPrice"
          label="Open Price"
          sortable
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="highPrice"
          label="High Price"
          sortable
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="lowPrice"
          label="Low Price"
          sortable
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="vol"
          label="Vol"
          sortable
          :width="90">
        </el-table-column>
        <el-table-column
          prop="chg"
          label="CHG"
          :width="80">
        </el-table-column>
        <el-table-column label="Operate">
          <template slot-scope="scope">
            <el-button size="mini" @click="detail(scope.row.name)">Detail</el-button>
            <el-button size="mini" type="success" @click="buy(scope.$index)">Buy</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog align="left" title="Performance" :visible.sync="buyFormVisible">
      <div>
        <div>
          <div id="c1"></div>
        </div>
      </div>
    </el-dialog>

    <el-dialog align="left" title="Buy" :visible.sync="buyFormVisible">
      <el-form :model="form">
        <el-form-item label="Name:" label-width="10">
          <el-input v-model="form.name" disabled></el-input>
        </el-form-item>
        <el-form-item label="Price($):" label-width="10">
          <el-input v-model="form.price" disabled></el-input>
        </el-form-item>
        <el-form-item label="Qty:" :label-width="formLabelWidth">
          <el-input v-model="form.qty"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="buyFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="submitBuyForm">Confirm</el-button>
      </div>
    </el-dialog>

    <div class="page-container">
      <el-tag class="amount">page size : {{ pageSize }} , total data: {{ total }} </el-tag>
      <el-pagination layout="prev, pager, next" background @current-change="handleCurrentChange" :total="pageNum" class="pagination"></el-pagination>
    </div>
  </div>
</template>

<script>
  import PORTFOLIO from '../api/portfolio'
  import PREDICTION from '../util/prediction'
  import { format } from '../util/date'
  export default {
    props: {
      portfolioId: String
    },
    data() {
      return {
        restaurants: [],
        stocks:[],
        form:{
          name:'',
          price:'',
          qty:null
        },
        total:0,
        pageNum:4,
        pageSize:5,
        currentCash:0,
        labelWidth:"120",
        formLabelWidth:"50",
        detailFormVisible:false,
        buyFormVisible:false,
        select:"2",
        value:'commodities',
        order_type:'comm_date',
        sequence:"DESC"
      }
    },
    methods:{
      getItems(from = 0) {
        if (this.select === "2" && this.value ==='stocks' && this.order_type.startsWith('comm')){
          this.order_type = 'stocks_date'
        }
        else if (this.select === "2" && this.value ==='commodities' && this.order_type.startsWith('stocks')){
          this.order_type = 'comm_date'
        }
        let params = {
          params: {
            from: from,
            size: this.pageSize,
            select: this.select,
            value: this.value,
            portId: this.portfolioId,
            order_type:this.order_type,
            sequence:this.sequence
          }
        };
          PORTFOLIO.getItems(params)
          .then(rep => {
            if (PREDICTION.httpSuccess(rep)) {
              this.stocks = rep.data.list[0];
              this.currentCash = rep.data.curCash;
              this.total = rep.data.size;
              this.pageNum = this.total / this.pageSize * 10;
            }
            else {
              this.$message.error(rep.message)
            }
          })
      },
      buy(index){
        let item = this.stocks[index];
        this.form.name = item.name;
        this.form.price = item.price;
        this.buyFormVisible = true;
      },
      detail(name){
        let params = {
          params:{
            name:name
          }
        };
        PORTFOLIO.getStockDetail(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.detailFormVisible = true;
            }
          })
      },
      submitBuyForm(){
        let params = new URLSearchParams();
        params.append('name', this.form.name);
        params.append('qty', this.form.qty);
        params.append('type', this.value);
        params.append('portfolio_id', this.portfolioId);
        PORTFOLIO.buy(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.$message.success("success")
            }
            else{
              this.$message.error(rep.message)
            }
            this.buyFormVisible = false;
          })
      },
      handleCurrentChange(page) {
        this.getItems(this.pageSize * (page - 1));
      },
      render() {
        var data = [{
          year: '1991',
          value: 3
        }, {
          year: '1992',
          value: 4
        }, {
          year: '1993',
          value: 3.5
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
        if (info.prop === 'name'){
          if (this.select === "2" && this.value === "stocks"){
            this.order_type = 'stocks_name';
          }
          else{
            this.order_type = 'commodities_name';
          }
        }
        else if(info.prop === 'date') {
          if (this.select === "2" && this.value === "stocks"){
            this.order_type = 'stocks_date';
          }
          else{
            this.order_type = 'comm_date';
          }
        }
        else if(info.prop === 'price'){
          this.order_type = 'price';
        }
        else if(info.prop === 'openPrice'){
          this.order_type = 'open_price';
        }
        else if(info.prop === 'lowPrice'){
          this.order_type = 'low_price';
        }
        else if(info.prop === 'highPrice'){
          this.order_type = 'high_price';
        }
        else if(info.prop === 'vol'){
          this.order_type = 'vol';
        }
        if (info.order === 'descending'){
          this.sequence = "DESC";
        }
        else if(info.order === 'ascending') {
          this.sequence = "ASC";
        }
        this.getItems();
      },
      querySearch(queryString, cb) {
        var restaurants = this.restaurants;
        var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
        cb(results);
      },
      createFilter(queryString) {
        return (restaurant) => {
          return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAll() {
        return [
          { "value": "stocks", "address": "stocks" },
          { "value": "commodities", "address": "commodities" },
        ];
      },
      handleSelect(item) {
        console.log(item);
      }
    },
    mounted(){
      this.getItems();
      this.restaurants = this.loadAll();
    }
  }
</script>

<style scoped lang="scss">
  @import "../assets/css/common";
  .wrapper{
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
    .search{
      margin: 15px 0 15px 0;
      width: 400px;
    }
  }
</style>
