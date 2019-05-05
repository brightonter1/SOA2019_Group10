<template>
  <div class="app" style="text-align: center">
    <div class="login-box">
      <h1>เข้าสู่ระบบ</h1>
      <el-form
        ref="login-form"
        id="login-form"
        :model="form"
        style="width: 100%;"
      >
        <el-form-item>
          <div class="input-label">Username</div>
          <el-input
            id="username"
            placeholder="Username"
            v-model="form.username"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <div class="input-label">Password</div>
          <el-input
            id="password"
            type="password"
            placeholder="Password"
            v-model="form.password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="onSubmit">เข้าสู่ระบบ</el-button>
        </el-form-item>
      </el-form>
      <div style="padding: 30px">
        ยังไม่เป็นสมาชิก?
        <router-link to="/signup/">
          <el-button style="margin-left: 10px">สมัครที่นี่</el-button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit() {
      alert("submit!");
    }
  }
};
</script>

<style scoped></style>
