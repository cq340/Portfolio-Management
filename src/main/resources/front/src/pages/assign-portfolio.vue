<template>
  <div class="wrapper">

    <div style="margin-top: 15px; margin-bottom: 20px;width: 200px">
      <el-input placeholder="Input manager id" v-model="managerId" class="input-with-select">
        <el-button slot="append" icon="el-icon-search" @click="handleClick"></el-button>
      </el-input>
    </div>
    <div style="height: 400px">
      <el-table
        stripe
        border
        :data="portfolios"
        style="width: 97%"
        :default-sort = "{ prop: 'name', order: 'descending'}"
        align="left"
      >
        <el-table-column
          prop="portId"
          label="ID"
          sortable
          :width="80"
        >
        </el-table-column>
        <el-table-column
          prop="portName"
          label="Name"
          sortable
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="portDate"
          label="Date"
          sortable
          :width="labelWidth"
          :formatter="dateFormat">
        </el-table-column>
        <el-table-column
          prop="portValue"
          label="Init Value($)"
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="currentValue"
          label="Cur Value($)"
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="percent"
          label="CHG"
          :width="labelWidth">
        </el-table-column>
        <el-table-column
          prop="cash"
          label="Cur Cash($)"
          :width="labelWidth">
        </el-table-column>
        <el-table-column label="Operate">
          <template slot-scope="scope">
            <el-button size="mini" @click="open(scope.row)">Assign</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>


    <el-dialog align="left" title="Assign" :visible.sync="formVisible">
      <el-form :model="form">
        <el-form-item label="Id" :label-width="formLabelWidth">
          <el-input v-model="form.id" disabled></el-input>
        </el-form-item>
        <el-form-item label="Current Manager" :label-width="formLabelWidth">
          <el-input v-model="form.preManager" disabled></el-input>
        </el-form-item>
        <el-form-item label="Assign To" :label-width="formLabelWidth">
          <el-input v-model="form.curManager"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="formVisible = false">Cancel</el-button>
        <el-button type="primary" @click="assignPortfolio">Confirm</el-button>
      </div>
    </el-dialog>
    <div class="page-container">
      <el-tag class="amount">Page size : {{ pageSize }} , Total data: {{ total }} </el-tag>
      <el-pagination layout="prev, pager, next" background @current-change="handleCurrentChange" :total="pageNum" class="pagination"></el-pagination>
    </div>

  </div>
</template>

<script>
  import PORTFOLIO from '../api/portfolio'
  import PREDICTION from '../util/prediction'
  import { format } from '../util/date'
  export default {
    data() {
      return {
        managerId:null,
        portfolios:[],
        form:{
          portId:null,
          preManager:null,
          curManager:null
        },
        total:300,
        pageNum:0,
        pageSize:4,
        currentCash:0,
        labelWidth:"140",
        formLabelWidth:"50",
        formVisible:false
      }
    },
    methods:{
      handleCurrentChange(page) {
        this.getPortByManagerId(this.pageSize * (page - 1));
      },
      dateFormat(row, column) {
        let date = row[column.property];
        if (date === undefined) {
          return "";
        }
        return format(date);
      },
      handleClick(){
        this.getPortByManagerId();
      },
      getPortByManagerId(from = 0){
        let params = {
          params:{
            from:from,
            size:this.pageSize
          }
        };
        PORTFOLIO.getPortfolios(this.managerId, params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.total = rep.data.size;
              this.pageNum = rep.data.size / this.pageSize * 10;
              this.portfolios = rep.data.portfolios;
            }
            else {
              this.$message.error(rep.message);
            }
          })
      },
      open(row){
        this.form.portId = row.portId;
        this.form.preManager = row.managerId;
        this.formVisible = true;
      },
      assignPortfolio() {
        let params = new URLSearchParams();
        params.append('former_mid',this.form.preManager );
        params.append('current_mid',this.form.curManager);
        params.append('port_id',this.form.portId);
        PORTFOLIO.assignTo(params)
          .then(rep => {
            if(PREDICTION.httpSuccess(rep)){
              this.getPortByManagerId();
            }
            this.formVisible = false;
          })
      }
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
