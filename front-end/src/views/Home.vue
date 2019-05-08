<template>
  <div class="home app">
    <!--<el-carousel trigger="click" indicator-position="outside">-->
      <!--<el-carousel-item v-for="item in 4" :key="item">-->
        <!--<h3>{{ item }}</h3>-->
      <!--</el-carousel-item>-->
    <!--</el-carousel>-->
    <!--<HelloWorld msg="Welcome to Your Vue.js App" />-->
    <div>
      <el-row v-for="i in 5" :key="i" style="margin: 80px">
        <el-col :span="6" v-for="o in 4" :key="o">
          <CosmeticCard :msg="msg" :wishlistdata="wishlistdata.cosmetics" :id="listdata[i*o].id" v-bind:name="listdata[i*o].name" v-bind:image="listdata[i*o].image_link"></CosmeticCard>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import CosmeticCard from "@/components/CosmeticCard.vue"
import Cosmetic from '../functions/Cosmetic'
import wishlist from "../functions/Wishlist";
import auth from '../functions/Authen'

export default {
  name: "home",
  data(){
    return{
        wishlistdata: [],
      listdata: [],
        msg: ''
    }
  },
  components: {
    CosmeticCard
  },
  methods:{
      ...wishlist.methods,
    ...Cosmetic.methods,
      ...auth.methods
  },
  created(){
    this.getCosmetics();
      this.getUserWishlist();
  },
    mounted(){
        this.checklogin()
    }
};
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
