<template>
  <div>
    <el-row :gutter="10">
      <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
        <div class="grid-content bg-purple">
        </div>
      </el-col>
      <el-col :xs="15" :sm="15" :md="15" :lg="16" :xl="16">
        <div class="grid-content bg-purple-light nav">
          <router-link to="/"><el-button>หน้าหลัก</el-button></router-link>
          <router-link to="/statement/"><el-button>Statement</el-button></router-link>
          <router-link to="/wishlist/"><el-button>Wish list</el-button></router-link>
          <router-link to="/test/"><el-button>Test</el-button></router-link>
          <router-link to="/cosmetic/"><el-button>รายการเครื่องสำอาง</el-button></router-link>
        </div>
      </el-col>
      <el-col :xs="5" :sm="5" :md="5" :lg="4" :xl="4">
        <div class="grid-content bg-purple">
          <router-link v-if="msg == 'no'" to="/login/" class="hidden-sm-and-down">
            <el-button  icon="el-icon-user-solid">สมัครสมาชิก/เข้าสู่ระบบ</el-button>
          </router-link>
          <el-button v-else v-on:click="signout()" icon="el-icon-user-solid">ออกจากระบบ</el-button>
          <router-link to="/login/" v-if="msg == 'no'" class="hidden-md-and-up"
            ><el-button icon="el-icon-user-solid"></el-button
          ></router-link>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import auth from '../functions/Authen'
export default {
  name: "Navigation",
  data(){
    return{
      msg:''
    }
  },
  methods:{
    ...auth.methods
  },
  mounted(){
    this.checklogin()
  }
};
</script>

<style>
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 40px;
  padding: 5px;
}
.nav {
  text-align: left;
}
</style>
