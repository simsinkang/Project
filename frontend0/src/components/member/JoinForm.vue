<template>
<div>
<Nav></Nav>
    <form class="form-horizontal"  >
  <fieldset>
    <div id="legend">
      <legend class="">회원 가입</legend>
    </div>
    <div class="control-group">
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="User Name" v-model="userName"/>
        <p class="help-block">User name can contain any letters or numbers, without spaces</p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="email">Email</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="Email" v-model="email"/>
        <p class="help-block">Please provide your Email</p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" placeholder="" class="input-xlarge" label="Password" v-model="password"/>
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label"  for="Phone" password>Phone</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="Phone" v-model="phone"/>
        <p class="help-block">Please confirm Phone</p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label"  for="City">City</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="City" v-model="city"/>
        <p class="help-block">Please confirm City</p>
      </div>
    </div>
    <div class="control-group">
      <div class="controls">
        <button class="btn btn-success" @click="save">가입</button>
        <button class="btn btn-success" @click="cancle()">취소</button>
      </div>
    </div>
  </fieldset>
</form><br/><br/>
<Footer></Footer>
</div>
</template>
<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'

export default {
  components:{
    Nav,Footer
  },

  data  ()   {
    return {
      context: 'http://localhost:9000/users',
      userName: '',
      email: '',
      password: '',
      phone: '',
      city: ''
    }
  },

  methods: {
    save(e) {
      e.preventDefault();
      let data = {
        userName: this.userName,
        email: this.email,
        password: this.password,
        phone: this.phone,
        city: this.city
      }
      let headers = {
        'Content-Type': 'application/json',
        'Authorization': 'JWT fefege..'
      }
      axios.post(`${this.context}/save`, JSON.stringify(data), {headers: headers})
        .then(res => {
          alert(res.data.result)
          this.$router.push({path:'/loginform'})
        })
        .catch(e => {
          alert('실패')
        })
    },

    cancle(){
      this.$router.push({path:'/'})
    }
  }
}
</script>