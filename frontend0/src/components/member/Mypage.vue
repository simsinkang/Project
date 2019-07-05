<template>
<div>
<Nav></Nav>
    <form class="form-horizontal" action='' method="POST">
      <div></div>
  <fieldset>
    <div id="legend">
      <legend class="">마이페이지</legend>
    </div>
    <div class="control-group">
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="User Name" v-model="userName"/>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label" for="email">Email</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="Email" v-model="email"/>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" placeholder="" class="input-xlarge" label="Password" v-model="password"/>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label"  for="Phone" password>Phone</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="Phone" v-model="phone"/>
      </div>
    </div><br/>
    <div class="control-group">
      <label class="control-label"  for="City">City</label>
      <div class="controls">
        <input type="text" placeholder="" class="input-xlarge" label="City" v-model="city"/>
      </div>
    </div>
    <div class="control-group">
      <div class="controls"><br/>
        <button class="btn btn-success">수정</button>
        <button class="btn btn-success">탈퇴</button>
      </div>
    </div>
  </fieldset>
</form><br/><br/><br/><br/>
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

  data: () => {
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
      let data = {
        userName: '',
        email: '',
        password: '',
        phone: '',
        city: ''
      }
      let headers = {
        'Content-Type': 'application/json',
        'Authorization': 'JWT fefege..'
      }
      axios.put(`${this.username}/update`, JSON.stringify(data), {headers: headers})
        .then(res => {
          this.$store.state.userName = res.data.user.userName
            this.$store.state.email = res.data.user.email
            this.$store.state.password = res.data.user.password
            this.$store.state.phone = res.data.user.phone
            this.$store.state.city = res.data.user.city
          alert(res.data)
        }).catch(e => {
          alert('ERROR' + e)
        })
    },

    deleteById () {
      axios.delete(`${this.context}/1`)
        .then(res => {
          alert(`탈퇴 성공`)
        })
        .catch(e => {
          alert('ERROR')
        })
    }
  }
}
</script>