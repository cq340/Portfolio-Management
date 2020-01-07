<template>
  <el-container class="app-container" :style="window">
    <el-header class="header">
      <a class="app-name" href="/#">Portfolio Manager</a>
      <span class="profile"  style="display: flex; justify-content: center">
        <img class="avatar" src="../assets/logo.png" style="margin-right: 10px"/>
        <el-dropdown  trigger="click">
          <span class="el-dropdown-link">
            {{ userName }}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <!--<el-dropdown-item>Profile</el-dropdown-item>-->
            <el-dropdown-item><span @click="logout">Log out</span></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </span>
    </el-header>

    <el-container>
      <el-aside class="side-nav" width="200px">
        <el-menu class="menu" router>
          <el-menu-item index="/main/dashboard" align="left">
            <template slot="title"><i class="graph-icon"></i>Dashboard</template>
          </el-menu-item>
          <el-menu-item index="/main/manager" v-if="role === 'admin'" align="left">
            <template slot="title"><i class="discover-icon"></i>Managers</template>
          </el-menu-item>
          <el-menu-item index="/main/assign-portfolio" v-if="role === 'admin'" align="left">
            <template slot="title"><i class="discover-icon"></i>Portfolio</template>
          </el-menu-item>
          <el-menu-item index="/main/portfolio" v-if="role === 'manager'" align="left">
            <template slot="title"><i class="discover-icon"></i>Portfolio</template>
          </el-menu-item>
          <el-menu-item index="/main/upload" v-if="role === 'admin'" align="left">
            <template slot="title"><i class="monitor-icon"></i>Upload</template>
          </el-menu-item>
          <!--<el-menu-item index="/main/aggregation" align="left">-->
            <!--<template slot="title"><i class="graph-icon"></i>Report</template>-->
          <!--</el-menu-item>-->
          <!--<el-menu-item index="/main/visualize" align="left">-->
            <!--<template slot="title"><i class="setting-icon"></i>Visualize</template>-->
          <!--</el-menu-item>-->
        </el-menu>
      </el-aside>
      <el-main class="main">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import USER from '../api/user'
  import PREDICTION from '../util/prediction'
  import { mapState } from 'vuex'
  export default {
    data(){
      return {
        window:{
          height:''
        }
      }
    },
    computed:mapState(['userId','role','userName']),
    methods:{
      logout(){
//        USER.logout({
//          id: this.userId
//        })
//          .then(rep => {
//          if (PREDICTION.httpSuccess(rep)) {
//            this.$store.commit("SET_LOG_FLAG", false);
//            this.$store.commit("SET_USER_ID", null);
//            this.$store.commit("SET_USER_ROLE", null);
//            this.$router.push('/');
//          }
//          else {
//            this.$message.error(rep.data.msg);
//          }
//        });
        console.log(111)
        this.$router.push('/');
      },
      wh() {
        this.window.height = window.innerHeight + 'px';
      }
    },
    mounted(){
      this.wh()
    }
  }
</script>

<style lang="scss" scoped>
  $icon-h: 18px;
  $icon-w: 18px;
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    height: 100%;
  }
  .app-container {
    padding: 0;
    width:100%;
    height: 100%;
    background-color: #f2f3f5;
    .header {
      background-color: #19a97b;
      display: flex;
      align-items: center;
      color: white;
      overflow: hidden;
      .app-name {
        font-size: 20px;
        text-decoration: none;
        color: white;
      }
      .profile {
        margin-left: auto;
        width: 200px;
        .avatar {
          height: 20px;
          width: 20px;
          border-radius: 50%;
        }
      }
    }
    .side-nav {
      .menu {
        height: 100%;
        .discover-icon {
          background-image: url("../assets/svg/discover.svg");
          background-size: $icon-w $icon-h;
          width: $icon-w;
          height:$icon-h;
          display: inline-block;
          margin: 0 15px 0 4px;
        }
        .monitor-icon {
          background-image: url("../assets/svg/monitor.svg");
          @extend .discover-icon
        }
        .graph-icon {
          background-image: url("../assets/svg/graph.svg");
          @extend .discover-icon
        }
        .setting-icon {
          background-image: url("../assets/svg/setting.svg");
          @extend .discover-icon
        }
      }
    }
    .main {
      margin-left:20px;
      padding:0;
      height: 100%;
    }
  }
</style>
