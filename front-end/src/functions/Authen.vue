<script>
import axios from "axios";
import variable from "./Globalvar";
const server = variable.data();
export default {
  data() {
    return {
      msg: ""
    };
  },
  methods: {
    login(user) {
      axios
        .post(server.auth + "user/signin", user)
        .then(res => {
          localStorage.setItem("token", res.data.token);
          this.msg = "login success";

          window.location.replace("/");
        })
        .catch(err => {
          this.msg = "fail";
        });
    },
    register(username, email, password) {
      let user = {
        username: username,
        email: email,
        password: password
      };
      axios
        .post(server.auth + "user/signup", user)
        .then(res => {
          this.msg = "register success";

          window.location.replace("/");
        })
        .catch(err => {
          this.msg = "register fail please try again";
        });
    },
    checklogin() {
      axios
        .get(server.auth + "user/information", {
          headers: {
            Authorization: "Baerer " + localStorage.token
          }
        })
        .then(res => {
          console.log(res.data);
          localStorage.setItem("username", res.data.username);
          this.msg = "yes";
        })
        .catch(err => {
          localStorage.clear();
          this.msg = "no";
        });
    },
    signout() {
      localStorage.clear();
      window.location.replace("/");
    }
  }
};
</script>
