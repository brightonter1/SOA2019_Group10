<script>
import Axios from "axios";
import variable from "./Globalvar";
const server = variable.data().wishlist;
export default {
  data() {
    return {
      wishlistdata: []
    };
  },
  methods: {
    getUserWishlist() {
      Axios.get(server + "wishlist/all", {
        headers: {
          Authorization: "Baerer " + localStorage.token
        }
      })
        .then(res => {
          this.wishlistdata = res.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    addWishlist(data) {
      Axios.post(server + "wishlist/add", data, {
        headers: {
          Authorization: "Baerer " + localStorage.token
        }
      })
        .then(res => {
          console.log(res);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteWishlist(id) {
      Axios.post(server + "wishlist", id, {
        headers: {
          Authorization: "Baerer " + localStorage.token
        }
      })
        .then(res => {
          console.log(res);
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>
