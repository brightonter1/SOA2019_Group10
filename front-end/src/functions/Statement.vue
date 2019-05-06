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
        getStatement(){
            Axios.get(server + 'statement',{
                headers:{
                'Authorization': 'Baerer ' + localStorage.token
                }
            }).then(res=>{
                this.listdata = res.data
            }).catch(e=>{
                console.log(e)
            })
        },
         addStatement(data){
            Axios.post(server+ 'statement', data, {
                headers:{
                    'Authorization': 'Baerer ' + localStorage.token
                }
            }).then(res=>{
                console.log(res)
            }).catch(e=>{
                console.log(e)
            })
        },
         deleteStatement(id){
            Axios.delete(server+ 'statement'+ id, {
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
