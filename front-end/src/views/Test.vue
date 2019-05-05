<template>
  <div>
    <ul>
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
      cosmetic: []
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
        }.bind(this)
      );
    }
  }
};
</script>

<style scoped></style>
