<template>
  <div class="app">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="Face Care" name="first">
        <el-row style="margin: 80px">
          <el-col :span="6" v-for="cosmetic in cosmetics">
            <CosmeticCard :makeup="cosmetic"></CosmeticCard>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="Base Makeup" name="second"> </el-tab-pane>
      <el-tab-pane label="Makeup" name="third"> </el-tab-pane>
      <el-tab-pane label="Perfume" name="fourth"> </el-tab-pane>
      <el-tab-pane label="Hair Care" name="fifth"> </el-tab-pane>
      <el-tab-pane label="Body Care" name="sixth"> </el-tab-pane>
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
      activeName: "first"
    };
  },
    mounted() {
        this.fetchCosmetic();
    },
    methods: {
        fetchCosmetic() {
            axios.get("https://makeup-api.herokuapp.com/api/v1/products.json?product_type=blush").then(
                function(response) {
                    this.cosmetics = response.data;
                    console.log(response.data);
                    //this.loading = false;
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
