<template>
  <div
    class="app"
  >
    <el-tabs v-model="activeName">
      <el-tab-pane label="Pencil" name="pencil"> </el-tab-pane>
      <el-tab-pane label="Lipstick" name="lipstick"> </el-tab-pane>
      <el-tab-pane label="Liquid" name="liquid"> </el-tab-pane>
      <el-tab-pane label="Powder" name="powder"> </el-tab-pane>
      <el-tab-pane label="Gel" name="gel"> </el-tab-pane>
      <el-tab-pane label="Cream" name="cream"> </el-tab-pane>
      <el-tab-pane label="Concealer" name="concealer"> </el-tab-pane>
      <el-tab-pane label="Highlighter" name="highlighter"> </el-tab-pane>
      <el-row style="margin: 80px" v-loading="loading">
        <el-col :span="6" v-for="cosmetic in cosmetics" :key="cosmetic.id">
          <CosmeticCard :makeup="cosmetic"></CosmeticCard>
        </el-col>
      </el-row>
    </el-tabs>
  </div>
</template>

<script>
import axios from "axios";
import CosmeticCard from "@/components/CosmeticCard.vue";
export default {
  name: "UserCosmetic",
  components: {
    CosmeticCard
  },
  data() {
    return {
      cosmetics: [],
      activeName: "pencil",
      loading: true
    };
  },
  mounted() {
    this.fetchCosmetic();
  },
  methods: {
    fetchCosmetic() {
      axios.get("http://localhost:8091/category/" + this.activeName).then(
        function(response) {
          this.cosmetics = response.data;
        }.bind(this)
      );
      this.loading = false;
    },
  },
  watch: {
    activeName: function(val) {
      if (val) {
        this.fetchCosmetic();
      }
    }
  }
};
</script>

<style scoped></style>
