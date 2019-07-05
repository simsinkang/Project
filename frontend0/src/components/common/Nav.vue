<template>
   <div>
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"><router-link to="/">SSK</router-link></a></li>
      <li><a href="#"><router-link to="/loginform">로그인</router-link></a></li>
      <li><a href="#"><router-link to="/joinform">회원가입</router-link></a></li>
      <li><a href="#"><router-link to="/mypage">마이페이지</router-link></a></li>
      <li><a href="#"><router-link to="/memberlist">회원목록</router-link></a></li>
    </ul>
    <div class="controls" v-if="this.$store.state.email != ''">
      <button class="btn btn-success" @click="logout">로그아웃</button>
    </div>
  </div>
</nav>
   </div> 
</template>

<script>

export default {
  
}
</script>
<style scoped>
  

</style>