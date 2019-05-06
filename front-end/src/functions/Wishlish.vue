<script>
import Axios from 'axios'
import variable from './Globalvar'
const server = variable.data().server
export default {
    data(){
        return{
            listdata:[]
        }
    },
    methods:{
        getUserWishlish(){
            Axios.get(server + 'wishlist/all').then(res=>{
                this.listdata = res.data
            }).catch(e=>{
                console.log(e)
            })
        },
        addWishlish(data){
            Axios.post(server+ 'wishlist/add', data, {
                headers:{
                    'Authorization': 'Baerer ' + localStorage.token
                }
            }).then(res=>{
                console.log(res)
            }).catch(e=>{
                console.log(e)
            })
        },
         deleteWishlist(id){
            Axios.post(server+ 'wishlist'+ id, {
                headers:{
                    'Authorization': 'Baerer ' + localStorage.token
                }
            }).then(res=>{
                console.log(res)
            }).catch(e=>{
                console.log(e)
            })
        }
    }
}
</script>
