<script>
import axios from "axios";
import variable from "./Globalvar";
const server = variable.data().cosmetic;
export default {
  data() {
    return {
      listdata: []
    };
  },
  methods: {
    getCosmetics() {
      axios
        .get(server + "cosmetics")
        .then(res => {
          console.log(res)
          this.listdata = res.data;
        })
        .catch(err => {
          console.log("error cosmetic get");
        });
    }
  }
};
</script>
