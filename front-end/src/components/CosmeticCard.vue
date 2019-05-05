<template>
  <div>
    <el-card
      :body-style="{ padding: '0px' }"
      style="margin-bottom: 1em; height: 350px"
      shadow="hover"
    >
      <img :src="makeup.image_link" style="height: 200px; width: auto; padding: 20px"/>
      <div style="padding: 1em;">
        <span>{{ makeup.name }}</span>
        <div class="bottom clearfix">
          <el-button type="text" class="button">Operation</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CosmeticCard",
    props: {
      makeup: Object
    }
};
</script>

<style scoped>
div {
  margin: 5px;
}
</style>
