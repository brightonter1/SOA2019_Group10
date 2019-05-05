import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Element from "element-ui";
import locale from "element-ui/lib/locale/lang/en";
import Navigation from "./components/Navigation";
import "element-ui/lib/theme-chalk/index.css"
import 'element-ui/lib/theme-chalk/display.css';
<<<<<<< HEAD
import firebase from 'firebase'
=======
import VueSession from 'dwy-vue-session'
 
Vue.use(VueSession,{
  maxAge:1000*60*60*24,
  prefix:'app'
  
});

>>>>>>> 1e09b7532267fbf2421190bb7d5cf669238e4d5e
Vue.use(Element, { locale });

Vue.component('Navigation', Navigation);

Vue.config.productionTip = false;

let config = {
    apiKey: "YOUR_API_KEY",
    authDomain: "YOUR_PROJECT_ID.firebaseapp.com",
    databaseURL: "https://YOUR_PROJECT_ID.firebaseio.com",
    projectId: "YOUR_PROJECT_ID",
    storageBucket: "YOUR_PROJECT_ID.appspot.com",
    messagingSenderId: "YOUR_MESSAGING_SEND_ID"
};
firebase.initializeApp(config);

new Vue({
    router,
    render: h => h(App)
}).$mount("#app");