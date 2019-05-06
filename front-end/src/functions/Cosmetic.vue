<script>
import axios from "axios";
import variable from "./Globalvar";
const server = variable.data().server;
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
    },
    getCosmeticsById(id){
      axios.get(server + 'cosmetics/' + id).then(res=>{
        this.listdata = res.data
      }).catch(e=>{
        console.log(e)
      })
    }
  }
};
</script>
