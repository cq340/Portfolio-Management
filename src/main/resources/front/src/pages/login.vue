<template>
  <div class="wrapper">
    <h2 class="title">Portfolio Manager</h2>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="SOEID">
        <el-input v-model="form.id"></el-input>
      </el-form-item>
      <el-form-item label="Password">
        <el-input type="password" v-model="form.password"></el-input>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="login">Log in</el-button>
  </div>
</template>

<script>
  import USER from '../api/user'
  import PREDICTION from '../util/prediction'
  export default {
    data() {
      return {
        form:{
          id: '',
          password: ''
        }
      }
    },
    methods:{
      login(){
        if (!this.checkForm()) return;
        let params = new URLSearchParams();
        params.append('id', this.form.id);
        params.append('password', this.form.password);
        USER.login(params)
          .then(rep => {
            console.log(rep)
            if(PREDICTION.httpSuccess(rep)){
              this.$store.commit("SET_LOG_FLAG", true);
              this.$store.commit("SET_USER_ID", rep.data.userId);
              this.$store.commit("SET_USER_ROLE", rep.data.role);
              this.$router.push('/main/dashboard');
            }else{
              this.$message.error("log in failed")
            }
          })
      },
      checkForm() {
        if(this.form.id === '' || this.form.password === ''){
          this.$message.error("id or password is missed");
          return false;
//          this.$throw('id or password is missed')
        }
        return true;
      }
    }
  }
</script>

<style scoped lang="scss">
  .wrapper {
    width: 300px;
    margin: 200px auto;
    /*display: flex;*/
    /*justify-content: center;*/
    .title{
      margin-bottom: 50px;
    }
  }
</style>
