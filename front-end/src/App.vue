<template>
  <div id="app">
    <div id="nav">
      <Navigation></Navigation>
    </div>
    <router-view></router-view>
    <div>
      <BottomNav></BottomNav>
    </div>
  </div>
</template>

<script>
import Navigation from "./components/Navigation";
import BottomNav from "./components/BottomNav";
export default {
  name: "app",
  components: { Navigation, BottomNav },
  component: {
    Navigation: Navigation,
      BottomNav: BottomNav
  }
};
</script>

<style>

  @import url('https://fonts.googleapis.com/css?family=Kanit');

  * {
    font-family: 'Kanit', sans-serif;
  }

  .app {
    margin-left: 2%;
    margin-right: 2%;
  }

  #app {
  font-family: 'Kanit', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
  .login-box {
    text-align: center;
    width: 400px;
    display: inline-block;
  }
  .input-label {
    float: left;
  }
</style>
