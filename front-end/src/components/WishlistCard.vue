<template>
  <el-card
    :body-style="{ padding: '0px' }"
    style="margin: 1em; width: 40%"
    shadow="hover"
  >
    <div style="overflow: hidden;">
      <!--<p style="padding-left: 20px; float: left;">{{ makeup.id }}</p>-->
      <div>
        <img
          :src="makeup.image_link"
          onerror="this.onerror=null;this.src='https://image.flaticon.com/icons/png/512/130/130298.png';"
          style="height: 200px; width: 200px; object-fit: cover; padding: 20px; float: left;"
        />
      </div>
      <div>
        <div style="text-align: left">
          <p>{{ makeup.name }}</p>
          <p>{{ makeup.price }} บาท</p>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script>
export default {
  name: "WishlistCard",
  props: {
    makeup: {}
  }
};
</script>

<style scoped></style>
