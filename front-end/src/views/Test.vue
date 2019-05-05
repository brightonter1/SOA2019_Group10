<template>
  <div>
    <ul v-loading="loading">
      <li v-for="i in cosmetic" v-bind:key="i.id">
        {{ i.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Test",
  data() {
    return {
      cosmetic: [],
      loading: true
    };
  },
  mounted() {
    this.fetchCosmetic();
  },
  methods: {
    fetchCosmetic() {
      axios.get("http://localhost:8080/cosmetics/").then(
        function(response) {
          this.cosmetic = response.data;
          console.log(response.data);
          this.loading = false;
        }.bind(this)
      );
    }
  }
};
</script>

<style scoped></style>
