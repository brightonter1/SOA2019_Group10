<template>
  <div>
    <el-card
      :body-style="{ padding: '0px' }"
      style="margin-bottom: 1em;height:auto;width:100%"
      shadow="hover"
    >
    <div v-bind:style="{ 'background-image': 'url(' + image + ')' }" style="background-size:cover;width:100%;max-height:300px;height:300px"></div>
      <!-- <img v-bind:src="image" height="auto" width="100%"/> -->
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
    name:String,
    image:String
  },
  name: "CosmeticCard",
}
</script>

<style scoped>
div {
  margin: 5px;
}
</style>
