import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Element from "element-ui";
import locale from "element-ui/lib/locale/lang/en";
import Navigation from "./components/Navigation";
import "element-ui/lib/theme-chalk/index.css"
import 'element-ui/lib/theme-chalk/display.css';
import VueLazyload from 'vue-lazyload'

Vue.use(VueLazyload)

Vue.use(Element, { locale });

Vue.component('Navigation', Navigation);

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
