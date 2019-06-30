<template>
  <v-container
    fill-height
    fluid
    grid-list-xl
  >
    <v-layout wrap>
      <v-flex md12 sm12 lg4>
        <material-card>
           <img src="https://picsum.photos/500/600/?random" v-on="img">
        </material-card>
      </v-flex>

      <v-flex md12 sm12 lg4>
        <material-card>
           <img src="https://picsum.photos/500/600/?image=" v-on="img">
        </material-card>
      </v-flex>

      <v-flex md12 sm12 lg4>
        <material-card>
           <img src="https://i.loli.net/2018/11/10/5be6852dec46e.jpeg" v-on="img">
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  
}
</script>

<style>
img {
  width: 350px
}
</style>
