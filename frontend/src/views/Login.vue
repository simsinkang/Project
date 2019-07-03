<template>
<v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex xs12 md8>
        <material-card color="orange" title="로그인" text="Please enter your e-mail and password.">
          <v-form>
            <v-container py-0>
              <v-layout wrap>
                <v-flex xs12 md4>
                  <v-text-field class="orange-input" label="Email" v-model="email"/>
                </v-flex>
                <v-flex xs12 md4>
                  <v-text-field label="Password" class="orange-input" v-model="password"/>
                </v-flex> 
                 <v-layout justify-center>
                  <v-flex xs11 sm5>
                    <v-btn class="mx-0 font-weight-light" color="success" @click="login">
                      로그인
                    </v-btn>
                  </v-flex>
                  <v-flex xs11 sm4>
                    <v-btn class="mx-0 font-weight-light" color="success" to="/joinform">
                      회원가입
                    </v-btn>
                  </v-flex>
                </v-layout>
              </v-layout>
            </v-container>
          </v-form>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data:()=>{
    return{
    context: 'http://localhost:9000/users',
    email: '',
    password: ''
    }

    links: [
      {
        name: 'join',
        to:'/joinform'
      }
    ]
  },

methods: {
  login(){
      let data = {
        email : this.email,
        password : this.password
      }
      let headers = {
        'Content-Type' : 'application/json',
        'Authorization' : 'JWT fefege..'
      }
      axios.post(`${this.context}/login`, JSON.stringify(data), {headers: headers})
      .then(res =>{
        alert(res.data.result);
        store.state.email = res.data.email;
        store.state.password = res.data.email;
      })
      .catch(e=>{
        alert('axios 실패')
      })
      this.$router.push('/userprofile')
    }
  }
}
</script>

<style scoped>

</style>