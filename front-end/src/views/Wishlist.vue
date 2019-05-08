<template>
  <div class="app">
    <h1>Wish list</h1>
    <div v-if="msg !== 'no'">
      <div v-if="wishlistdata.cosmetics.length != 0">
        <div>
          <div
            v-for="(cosmetic, index) in wishlistdata.cosmetics" :key="index"
            style="display: flex; justify-content: center"
          >
            <WishlistCard :makeup="cosmetic"></WishlistCard>
          </div>
        </div>
      </div>
      <div v-else>
        <h3>ไม่มีรายการเครื่องสำอางใน Wishlist</h3>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
import WishlistCard from "@/components/WishlistCard.vue";
import auth from "../functions/Authen";
import wishlist from "../functions/Wishlist";
export default {
  name: "Wishlist",
  components: {
    WishlistCard
  },
  data() {
    return {
      wishlistdata: null,
      msg: ""
    };
  },
  mounted() {
    this.checklogin();
    this.getUserWishlist();
  },
  methods: {
    ...auth.methods,
    ...wishlist.methods
    // fetchCosmetic() {
    //   axios.get(server + "/wishlist/all",
    //     {
    //       headers: {
    //         Authorization: "Baerer " + localStorage.token
    //       }
    //     }).then(
    //       function(response) {
    //         this.cosmetics = response.data;
    //         console.log(response.data);
    //         this.loading = false;
    //       }.bind(this)
    //     );
    // }
  }
};
</script>

<style scoped></style>
