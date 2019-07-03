<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex xs12 md8>
        <material-card color="green" title="회원 가입" text="Complete your profile">
          <v-form>
            <v-container py-0>
              <v-layout wrap>
                <v-flex xs12 md6>
                  <v-text-field label="User Name" class="green-input" v-model="userName"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Email" class="green-input" v-model="email"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Password" class="green-input" v-model="password"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Phone" class="green-input" v-model="phone"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="City" class="blue-input" v-model="city"/>
                </v-flex>
                <v-layout justify-center>
                  <v-flex xs11 sm4>
                    <v-btn class="mx-0 font-weight-light" color="success" @click="save">
                      가입
                    </v-btn>
                  </v-flex>
                  <v-flex xs11 sm4>
                    <v-btn class="mx-0 font-weight-light" color="success">
                      취소
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
    userName : '',
    email: '',
    password: '',
    phone: '',
    city: ''
    }
  },

  methods: {
    save() {
      let data = {
        userName : this.userName,
        email : this.email,
        password : this.password, 
        phone : this.phone, 
        city : this.city
      }
      let headers = {
        'Content-Type' : 'application/json',
        'Authorization' : 'JWT fefege..'
      }
      axios.post(`${this.context}`, JSON.stringify(data), {headers: headers})
      .then(res=>{
        alert(`회원가입 성공`)
      })
      .catch(e=>{
        alert('ERROR')
      })
    }
  }
}
</script>
