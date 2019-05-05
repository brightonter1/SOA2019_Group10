
<script>
import axios from 'axios'
import variable from './Globalvar'
const server = variable.data()
export default {
    data(){
        return{
            msg:''
        }
    },
    methods: {
        login(user){
            axios.post(server + 'user/signin', user)
            .then(res=>{
                localStorage.setItem('token', res.data.token)
                this.msg = 'login success'
                this.$router.push('/')
            }).catch(err=>{
                this.msg = 'fail'
            })
        },
        register(user){
            axios.post(server + 'user/signup', user)
            .then(res=>{
                this.msg = 'register success'
                this.$router.push('/')
            })
            .catch(err=>{
                this.msg = 'register fail please try again'
            })
        },
        checklogin(){
            
        }
    },
}
</script>