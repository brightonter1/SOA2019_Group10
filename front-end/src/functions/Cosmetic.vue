<script>
import axios from 'axios'
import variable from './Globalvar'
const server = variable.data().server
export default {
    data(){
        return{
            listdata:[]
        }
    },
    methods:{
        getCosmetics(){
            axios.get(server + 'cosmetics')
            .then(res=>{
                listdata:res.data
            })
            .catch(err=>{
                console.log("error cosmetic get")
            })
        }
    }
}
</script>
