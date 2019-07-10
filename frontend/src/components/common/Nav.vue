<template>
  <div class="nav">
    <nav class="nav">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#" ><router-link to="/"><img src="/static/tiger.PNG" v-on="img"></router-link></a></li>
        <li><a href="#"><router-link to="/loginform">로그인</router-link></a></li>
        <li><a href="#"><router-link to="/joinform">회원가입</router-link></a></li>
        <li><a href="#"><router-link to="/mypage">마이페이지</router-link></a></li>
        <li v-if="this.$store.state.email != ''"><a href="#"><router-link to="/memberlist">회원목록</router-link></a></li>
      </ul>
        <input type="button" v-if="this.$store.state.email != ''" class="btn btn-warning" @click="logout" value="로그아웃">
    </nav>
  </div> 
</template>

<script>
import {store} from '@/store/index'

export default {
  methods:{
    logout(){
        this.$store.state.userName = ''
        this.$store.state.email = ''
        this.$store.state.password = ''
        this.$store.state.phone = ''
        this.$store.state.city = ''
        this.$router.push({path: '/'})
    }
  }
}
</script>
<style scoped>
img{
  width: 70px;
  height: 55px;
}

.nav{
  background-color: #c9e1f5;  
  margin:0;  
  font-size: 30px;
  font-weight: bold;
  text-align: right;
  padding-right:15%;
}

input{
	height:35px;
	margin-right:175px;
  font-size: 20px;
  font-weight: bold;
  text-align: right;
}
</style>