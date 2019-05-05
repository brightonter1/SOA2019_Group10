
<script>
import axios from 'axios'
import variable from './Globalvar'
const server = variable.data().server
export default {
    data(){
        return{
            msg:''
        }
    },
    methods: {
        login(user){
            console.log(server)
            axios.post(server + 'user/signin', user)
            .then(res=>{
                localStorage.setItem('token', res.data.token)
                this.msg = 'login success'
                this.$router.push('/')
            }).catch(err=>{
                this.msg = 'fail'
            })
        },
        register(username, email, password){
            let user = {
                username: username,
                email: email,
                password: password
            }
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
            axios.get(server + 'user/information', {
                headers:{
                    'Authorization': 'Baerer ' + localStorage.token
                }
            }).then(res=>{
                console.log(res)
                return res.data
            })
            .catch(err=>{
                localStorage.clear()
                console.log('not login')
            })
        }
    },
}
</script>