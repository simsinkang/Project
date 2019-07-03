<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex md12>
        <material-card color="purple" title="회원 목록" text="Here is a subtitle for this table">
          <v-form>
          <v-data-table :headers="headers" :items="items" hide-actions>
            <template slot="headerCell" slot-scope="{ header }">
              <span class="subheading font-weight-light text-success text--darken-3" v-text="header.text" />
            </template>
            <template slot="items" slot-scope="{ item }">
              <td>{{ item.Email }}</td>
              <td>{{ item.name }}</td>
              <td>{{ item.Phone }}</td>
              <td class="text-xs-right">{{ item.city }}</td>
            </template>
          </v-data-table>
            <v-flex xs11 sm5>
              <v-btn class="mx-0 font-weight-light" color="success" @click="list">
                목록 보기
              </v-btn>
            </v-flex>
          </v-form>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    headers: [
      {
        sortable: false,
        text: 'Email',
        value: 'email',
      },
      {
        sortable: false,
        text: 'Name',
        value: 'name'
      },
      {
        sortable: false,
        text: 'Phone',
        value: 'Phone'
      },
      {
        sortable: false,
        text: 'City',
        value: 'city',
        align: 'right'
      },
    ],
    items: [
      
    ]
  })
}
</script>
