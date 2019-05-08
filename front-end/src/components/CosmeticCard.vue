<template>
  <div style="margin: 10px;">
    <el-card
      :body-style="{ padding: '0px' }"
      style="margin-bottom: 1em;height:auto;width:100%; position: relative;"
      shadow="hover"
    >
      <div
        v-bind:style="{ 'background-image': 'url(' + image + ')' }"
        style="background-size:cover;width:100%;max-height:300px;height:300px; width: auto; object-fit: cover; "
      ></div>
      <!-- <img v-bind:src="image" height="auto" width="100%"/> -->
      <div style="padding: 1em;">
        <span>{{ name }}</span>
        <!--<div class="bottom clearfix">-->
          <!--&lt;!&ndash;<el-button type="text" class="button">Click</el-button>&ndash;&gt;-->
          <!--<el-button-->
            <!--@click="dialogVisible = true"-->
            <!--icon="el-icon-plus"-->
            <!--circle-->
          <!--&gt;</el-button>-->
        <!--</div>-->
      </div>
      <div v-if="msg === 'yes'" style="position: absolute; top:0; right:0; margin: 5px">
        <el-tooltip
          effect="dark"
          :content="
            inWishlist ? 'ลบออกจากรายการที่ต้องการ' : 'เพิ่มลงรายการที่ต้องการ'
          "
          placement="top"
        >
          <i class="material-icons" @click="toggleStar(id)">
            {{ inWishlist ? "star" : "star_border" }}
          </i>
        </el-tooltip>
      </div>
    </el-card>
    <el-dialog title="เพิ่มในรายการ" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form" :model="description" label-width="120px">
        <span>
          <el-form-item label="วันที่ซื้อ">
            <el-date-picker
              class="input-box"
              v-model="description.buyDate"
              type="date"
              placeholder="วันที่ซื้อ"
              format="yyyy/MM/dd"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="วันหมดอายุ">
            <el-date-picker
              class="input-box"
              v-model="description.expDate"
              type="date"
              placeholder="วันหมดอายุ"
              format="yyyy/MM/dd"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="ราคา">
            <el-input
              class="input-box"
              placeholder="ราคา"
              v-model="description.price"
              type="number"
            ></el-input>
          </el-form-item>
        </span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">ยกเลิก</el-button>
          <el-button type="primary" @click="dialogVisible = false"
            >ยืนยัน</el-button
          >
        </span>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
    import wishlist from "../functions/Wishlist";
export default {
  props: {
    name: String,
    image: String,
    id: Number,
      wishlistdata: [],
      msg: String,
  },
  name: "CosmeticCard",
  data() {
    return {
      inWishlist: false,
      dialogVisible: false,
      description: {
        buyDate: "",
        expDate: "",
        price: ""
      }
    };
  },
  created() {
    if (this.wishlistdata !== 'undefined' && this.wishlistdata.length > 0) {
        console.log(this.wishlistdata);
        console.log('.....');
        this.inWishlist = this.checkInWishlist(this.wishlistdata, this.id);
    };
  },
  methods: {
      ...wishlist.methods,
    toggleStar(id) {
          if (this.inWishlist === false) {
              this.addWishlist(id);
              console.log(id);
          } else {
              this.deleteWishlist(id);
              console.log('delete from wishlist');
              console.log(id);
          }

      this.inWishlist = !this.inWishlist;
    },
    checkInWishlist(wishlistdata, objToFind) {
      this.inWishlist = wishlistdata.some(item => _.isEqual(item, objToFind));
    }
  }
};
</script>

<style scoped>
div {
}
.material-icons {
  font-size: 2.5em;
  user-select: none;
  color: #ffd91c;
}
.material-icons:hover {
  transition: 0.2s;
  text-shadow: 0px 0px 10px #ababab;
}
.input-box {
  width: auto;
}
</style>
