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
        <input type="button" class="btn btn-success" @click="check" value="확인">
        <input type="button" class="btn btn-warning" @click="cancle" value="취소">
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
    check () {
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
      axios.put(`${this.context}/${this.$store.state.email}`, JSON.stringify(data), {headers: headers})
        .then(res => {
          alert('수정 성공')
          this.$store.state.userName = res.data.userName
          this.$store.state.email = res.data.email
          this.$store.state.password = res.data.password
          this.$store.state.phone = res.data.phone
          this.$store.state.city = res.data.city
          this.$router.push({path: '/mypage'})
        }).catch(e => {
          alert('ERROR')
        })
    },

    cancle(){
        this.$router.push({path:'/mypage'})
    }
  }
}
</script>