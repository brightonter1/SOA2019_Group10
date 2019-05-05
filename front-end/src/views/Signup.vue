<template>
  <div class="app" style="text-align: center">
    <div class="login-box">
      <h1>สมัครสมาชิก</h1>
      <el-form :model="signupForm" :rules="rules" ref="signupForm">
        <el-form-item label="ชื่อผู้ใช้งาน" prop="username">
          <el-input
            id="username"
            v-model="signupForm.username"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item label="อีเมล" prop="email">
          <el-input v-model="signupForm.email" type="email"></el-input>
        </el-form-item>
        <el-form-item label="รหัสผ่าน" prop="password">
          <el-input
            id="password"
            v-model="signupForm.password"
            type="password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="ยืนยันรหัสผ่าน" prop="repassword">
          <el-input
            id="repassword"
            v-model="signupForm.repassword"
            type="password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="วันเกิด" prop="birthday">
          <!--<div class="input-label" style="user-select: none"><span style="color: red;">*</span> วันเกิด</div>-->
          <el-date-picker
            id="birthday"
            type="date"
            placeholder="เลือกวันที่"
            v-model="signupForm.birthday"
            style="width: 100%"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="register(signupForm)"
            >สมัครสมาชิก</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import firebase from 'firebase';
import auth from '../functions/Authen'

export default {
  name: "Signup",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("กรุณากรอกรหัสผ่าน"));
      } else {
        if (this.signupForm.repassword !== "") {
          this.$refs.signupForm.validateField("repassword");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("กรุณากรอกยืนยันรหัสผ่าน"));
      } else if (value !== this.signupForm.password) {
        callback(new Error("ยืนยันรหัสผ่านไม่ถูกต้อง"));
      } else {
        callback();
      }
    };
    return {
      signupForm: {
        username: "",
        email: "",
        password: "",
        repassword: "",
        birthday: ""
      },
      rules: {
        username: [
          {
            required: true,
            message: "กรุณากรอกชื่อผู้ใช้งาน",
            trigger: "blur"
          },
          {
            min: 8,
            message: "ชื่อผู้ใช้งานต้องมีความยาว 8 ตัวอักษรขึ้นไป",
            trigger: "blur"
          }
        ],
        email: [
          {
            required: true,
            message: "กรุณากรอก email",
            trigger: "blur"
          },
          {
            type: "email",
            message: "email ของท่านไม่ถูกต้อง",
            trigger: ["blur", "change"]
          }
        ],
        password: [
          {
            min: 8,
            message: "รหัสผ่านต้องมีความยาว 8 ตัวอักษรขึ้นไป",
            trigger: "blur"
          },
          {
            required: true,
            validator: validatePass,
            trigger: "blur"
          }
        ],
        repassword: [
          {
            required: true,
            validator: validatePass2,
            trigger: "blur"
          }
        ],
        birthday: [
          {
            type: "date",
            required: true,
            message: "กรุณาเลือกวันที่",
            trigger: "change"
          }
        ]
      }
    };
  },
  methods: {
    ...auth.methods,
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
         // alert(this.signupForm.username);
          
          // this.$confirm('This will permanently delete the file. Continue?', {
          //     confirmButtonText: 'OK',
          //     cancelButtonText: 'Cancel',
          // }).then(() => {
          //     this.$message({
          //         type: 'success',
          //         message: 'สมัครสมาชิกเสร็จสิ้น'
          //     });
          // }).catch(() => {
          //
          // });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    
  }
};
</script>

<style scoped></style>
