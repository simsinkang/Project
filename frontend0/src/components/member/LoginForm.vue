<template>
<div>
  <Nav></Nav>
  <form>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" label="Email" v-model="email" placeholder="Enter ID"/>
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" label="Password" placeholder="Enter password"  v-model="password"/>
    </div>
    <input type="button" class="mx-0 font-weight-light" color="success" @click="login" value="로그인">
    <button class="mx-0 font-weight-light" color="success"><router-link to="/joinform">회원가입</router-link></button>
  </form><br/><br/><br/><br/><br/><br/>
  <Footer></Footer>
</div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'
import {store} from '@/store/index'

export default {
  name:'login',
  data: () => {
    return {
      context: 'http://localhost:9000/users',
      email: '',
      password: ''
    }
  },

  components: {
    Nav, Footer
    },
  
  methods: {
    login () {
      let data = {
        email: this.email,
        password: this.password
      }
      let headers = {
        'Content-Type': 'application/json',
        'Authorization': 'JWT fefege..'
      }
      axios.post(`${this.context}/login`, JSON.stringify(data), {headers: headers})
        .then(res => {
          if(res.data.result === '로그인 성공'){
            this.$store.state.userName = res.data.user.userName
            this.$store.state.email = res.data.user.email
            this.$store.state.password = res.data.user.password
            this.$store.state.phone = res.data.user.phone
            this.$store.state.city = res.data.user.city
            this.$router.push({path: '/mypage'})
          }
        })
        .catch(e => {
          alert('axios 실패')
        })
    },

    logout(){

    }
  }
}
</script>

<style scoped>
</style>