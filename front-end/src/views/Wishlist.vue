<template>
  <div class="app">
    <h1>Wish list</h1>
    <div v-loading="loading">
      <div
        v-for="cosmetic in cosmetics"
        style="display: flex; justify-content: center"
      >
        <WishlistCard :makeup="cosmetic"></WishlistCard>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import WishlistCard from "@/components/WishlistCard.vue";
export default {
  name: "Wishlist",
  components: {
    WishlistCard
  },
  data() {
    return {
      cosmetics: [],
      activeName: "first",
      loading: true
    };
  },
  mounted() {
    this.fetchCosmetic();
  },
  methods: {
    fetchCosmetic() {
      axios.get("http://localhost:8091/cosmetics").then(
        function(response) {
          this.cosmetics = response.data;
          console.log(response.data);
          this.loading = false;
        }.bind(this)
      );
    },
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>

<style scoped></style>
