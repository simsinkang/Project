<template>
<div id="mypage">
<Nav></Nav>
    <div class="form-horizontal" >
      <div></div>
  <fieldset>
    <div id="legend">
      <legend class="">마이페이지</legend>
    </div>
    <div class="control-group">
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <p>{{userName}}</p>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label" for="email">Email</label>
      <div class="controls">
        <p>{{email}}</p>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <p>{{password}}</p>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label"  for="Phone" password>Phone</label>
      <div class="controls">
        <p>{{phone}}</p>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label"  for="City">City</label>
      <div class="controls">
        <p>{{city}}</p>
      </div>
    </div>
    <div class="control-group">
      <div class="controls"><br/>
        <input type="button" class="btn btn-success" @click="update" value="수정">
        <input type="button" class="btn btn-warning" @click="remove" value="탈퇴">
      </div>
    </div>
  </fieldset>
</div><br/><br/><br/><br/>
<Footer></Footer>
</div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'
import {store} from '../../store'

export default {
  components:{
    Nav,Footer
  },

  data ()   {
    return {
      context: 'http://localhost:9000/users',
      userName: store.state.userName,
      email: store.state.email,
      password: store.state.password,
      phone: store.state.phone,
      city: store.state.city
    }
  },

  methods: {
    update () {
      this.$router.push({path: '/updatepage'})
    },

    remove(){
      axios.delete(`${this.context}/remove/${this.$store.state.email}`)
      .then(r=>{
        alert("탈퇴성공")
        this.$router.push({path: '/'})
      })
      .catch(e=>{
        alert('ERROR')
      })
    }
  }
}
</script>

<style scoped>


</style>