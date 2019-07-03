<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex xs12 md8>
        <material-card color="pink">
          <div slot="header">
            <div class="title font-weight-light mb-2">공지사항</div>
            <div class="category">
              Please check the notice
              <v-icon size="17">
                mdi-heart
              </v-icon>
            </div>
          </div>
          <v-card-text>
            <v-layout row wrap>
              <v-flex text-xs-center>
                <h2 class="title font-weight-light">신규 업데이트</h2>
                <material-notification class="mb-3" color="error" dismissible icon="mdi-bell-plus" >
                  운영정책 변경 안내
                </material-notification>
                <material-notification class="mb-3" color="warning" dismissible icon="mdi-bell-plus">
                  개인정보처리방침 변경 사전 안내
                </material-notification>
                <material-notification class="mb-3" color="success" dismissible icon="mdi-bell-plus">
                  이용약관 변경 안내
                </material-notification>
                <material-notification class="mb-3" color="info" dismissible icon="mdi-bell-plus">
                  회원 서비스 점검 안내
                </material-notification>
                <material-notification class="mb-3" color="purple" dismissible icon="mdi-bell-plus">
                  휴면 아이디 탈퇴 안내
                </material-notification>
              </v-flex>
            </v-layout>
            <v-container grid-list-lg>
              <v-layout justify-center row wrap>
                <v-flex xs12 sm4>
                  <v-btn block color="success" @click="snack('top', 'left')">
                    <strong>Click</strong>
                  </v-btn>
                </v-flex>
              </v-layout>
            </v-container>
            <v-snackbar :color="color" :bottom="bottom" :top="top" :left="left" :right="right" v-model="snackbar" dark>
              <v-icon color="white" class="mr-3">
                mdi-bell-plus
              </v-icon>
              <div>Welcome to <b>Vue Material Dashboard</b> - a beautiful freebie for every web developer.</div>
              <v-icon size="16" @click="snackbar = false">
                mdi-close-circle
              </v-icon>
            </v-snackbar>
          </v-card-text>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    color: null,
    colors: [
      'pink',
      'info',
      'success',
      'warning',
      'error'
    ],
    top: true,
    bottom: false,
    left: false,
    right: false,
    snackbar: false
  }),

  methods: {
    snack (...args) {
      this.top = false
      this.bottom = false
      this.left = false
      this.right = false

      for (const loc of args) {
        this[loc] = true
      }

      this.color = this.colors[Math.floor(Math.random() * this.colors.length)]

      this.snackbar = true
    }
  }
}
</script>
