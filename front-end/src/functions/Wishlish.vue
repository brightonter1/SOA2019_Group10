<script>
import Axios from 'axios';
export default {
    methods:{
        getUserWishlist(data){
            Axios.post('path', data, {
                headers:{
                    'Authorization': localStorage.token
                }
            }).then(res=>{
                return res.data
            }).catch(e=>{
                console.log(e)
            })
        }
    }
}
</script>
