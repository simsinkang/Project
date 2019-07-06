<template>
<div>
<Nav></Nav>
    <table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable">
      <tbody>
        <tr class="w3-green">
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>City</th>
      </tr>
      </tbody>
      <tbody>
        <tr v-for="user in list" :key="user.id" class=" text-xs-center subheading text--darken-3">
          <td>{{ user.userName }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.phone }}</td>
          <td>{{ user.city }}</td>
        </tr>
      </tbody>
    </table><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    <Footer></Footer>
</div>
</template>
<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'

export default {
  components: {
    Nav,
    Footer
  },

  data: () => ({
    context: 'http://localhost:9000/users',
    headers: [
      {
        sortable: false,
        text: '',
        value: 'email'
      }
    ],

    list: [

    ]
  }),
  created: function () {
    axios.get(`${this.context}`)
      .then(res => {
        this.list = res.data
      })
      .catch(e => {
        alert('ERROR')
      })
  },

  methods: {

  }
}
</script>
<style scoped>

</style>