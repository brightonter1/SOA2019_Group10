import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";

Vue.use(Router);

const router = new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home,
      meta: {
        title: "Welcome"
      }
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "./views/About.vue")
    },
    {
      path: "/login",
      name: "login",
      component: () => import("./views/Login.vue"),
      meta: {
        title: "Login"
      }
    },
    {
      path: "/signup",
      name: "signup",
      component: () => import("./views/Signup.vue"),
      meta: {
        title: "Sign up"
      }
    },
    {
      path: "/statement",
      name: "statement",
      component: () => import("./views/Statement.vue"),
      meta: {
        title: "Statement"
      }
    },
    {
      path: "/wishlist",
      name: "wishlist",
      component: () => import("./views/Wishlist.vue"),
      meta: {
        title: "Wish list"
      }
    },
    {
      path: "/test",
      name: "test",
      component: () => import("./views/Test.vue"),
      meta: {
        title: "Test"
      }
    },
    {
      path: "/cosmetic",
      name: "cosmetic",
      component: () => import("./views/UserCosmetic.vue"),
      meta: {
        title: "Cosmetic"
      }
    }
  ],
  mode: "history"
});

export default router;

const DEFAULT_TITLE = "Welcome";
// eslint-disable-next-line no-unused-vars
router.afterEach((to, from) => {
  document.title = to.meta.title || DEFAULT_TITLE;
});
