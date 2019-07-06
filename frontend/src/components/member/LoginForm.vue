<template>
<div>
  <Nav></Nav>
  <form>
    <div id="legend">
      <legend class="">로그인</legend>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" label="Email" v-model="email" placeholder="Enter Email"/>
      <br/><br/>
      <label for="password">Password</label>
      <input type="password" class="form-control" label="Password" placeholder="Enter Password"  v-model="password"/>
    </div>
    <input type="button" class="btn btn-success" @click="login" value="로그인">
    <input type="button" class="btn btn-warning" @click="join" value="회원가입">
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
            alert('로그인 성공')
            this.$store.state.userName = res.data.user.userName
            this.$store.state.email = res.data.user.email
            this.$store.state.password = res.data.user.password
            this.$store.state.phone = res.data.user.phone
            this.$store.state.city = res.data.user.city
            this.$router.push({path: '/mypage'})
          } else {
            alert('Email과 Password를 확인하세요')
          }
        })
        .catch(e => {
          alert('axios 실패')
        })
    },

    join(){
      this.$router.push({path: '/joinform'})
    }
  }
}
</script>

<style scoped>
</style>