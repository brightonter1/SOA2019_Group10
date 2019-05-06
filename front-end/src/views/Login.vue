<template>
  <div class="app" style="text-align: center">
    <div class="login-box">
      <h1>เข้าสู่ระบบ</h1>
      <el-form
        ref="form"
        id="login-form"
        :model="form"
        style="width: 100%;"
      >
        <el-form-item required label="Username" prop="username">
          <el-input
            id="username"
            placeholder="Username"
            v-model="form.username"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item required label="Password" prop="password">
          <el-input
            id="password"
            type="password"
            placeholder="Password"
            v-model="form.password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="login(form)">เข้าสู่ระบบ</el-button>
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
import authen from '../functions/Authen'
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: ""
      },
      // rules: {
      //   username: [
      //     {
      //       required: true,
      //       message: "กรุณากรอกชื่อผู้ใช้งาน",
      //       trigger: ["blur", "change"]
      //     }
      //   ],
      //   password: [
      //     {
      //       required: true,
      //       message: "กรุณารหัสผ่าน",
      //       trigger: ["blur", "change"]
      //     }
      //   ]
      // }
    };
  },
  methods: {
    ...authen.methods,
  }
};
</script>

<style scoped></style>
