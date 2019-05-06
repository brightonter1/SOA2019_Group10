<template>
  <div>
    <el-card
      :body-style="{ padding: '0px' }"
      style="margin-bottom: 1em;"
      shadow="hover"
    >
      <img src="../assets/cosmetic-img.jpg"/>
      <div style="padding: 1em;">
        <span>{{ name }}</span>
        <div class="bottom clearfix">
          <el-button type="text" class="button">Click</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import { prototype } from 'events';
export default {
  props:{
    name:String
  },
  name: "CosmeticCard",
}
</script>

<style scoped>
div {
  margin: 5px;
}
</style>
