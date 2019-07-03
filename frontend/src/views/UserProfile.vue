<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex xs12 md8>
        <material-card color="blue" title="개인 정보" text="Please enter your personal information.">
          <v-form>
            <v-container py-0>
              <v-layout wrap>
                <v-flex xs12 md6>
                  <v-text-field label="User Name" class="blue-input" v-model="userName"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Email" class="blue-input" v-model="email"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Password" class="blue-input" v-model="password"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="Phone" class="blue-input" v-model="phone"/>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field label="City" class="blue-input" v-model="city"/>
                </v-flex>
                <v-layout justify-center>
                  <v-flex xs11 sm4>
                    <v-btn class="mx-0 font-weight-light" color="success">
                      수정
                    </v-btn>
                  </v-flex>
                  <v-flex xs11 sm4>
                    <v-btn class="mx-0 font-weight-light" color="success" @click="deleteById">
                      탈퇴
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
    userName: '',
    email: '',
    password: '',
    phone: '',
    city: ''
    }
  },

  methods: {
    deleteById(){
      axios.delete(`${this.context}/1`)
      .then(res=>{
        alert(`탈퇴 성공`)
      })
      .catch(e=>{
        alert("ERROR")
      })
    }
  }
}
</script>
