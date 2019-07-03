<template>
  <v-navigation-drawer id="app-drawer" v-model="inputValue" app dark floating persistent mobile-break-point="991" width="260">
      <v-layout class="fill-height" tag="v-list" column>
        <v-list-tile avatar>
          <v-list-tile-avatar color="white">
            <v-img :src="tiger" height="34" contain />
            </v-list-tile-avatar>
          <v-list-tile-title class="title">
            SSK
          </v-list-tile-title>
        </v-list-tile>
        <v-divider/>
        <v-list-tile v-if="responsive">
          <v-text-field class="purple-input search-input" label="Search..." color="purple" />
        </v-list-tile>
        <v-list-tile v-for="(link, i) in links" :key="i" :to="link.to" :active-class="color" avatar class="v-list-item">
          <v-list-tile-action>
            <v-icon>{{ link.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-title v-text="link.text" />
        </v-list-tile>
        <v-list-tile disabled active-class="primary" class="v-list-item v-list__tile--buy" to="/upgrade">
        </v-list-tile>
      </v-layout>
  </v-navigation-drawer>
</template>

<script>
// Utilities
import {
  mapMutations,
  mapState
} from 'vuex'

export default {
  data: () => ({
    logo: './img/vuetifylogo.png',
    links: [
      {
        to: '/home',
        icon: 'mdi-view-dashboard',
        text: 'Home'
      },
      {
        to: '/login',
        icon: 'mdi-account',
        text: '로그인'
      },
      {
        to: '/joinform',
        icon: 'mdi-account',
        text: '회원 가입'
      },
      {
        to: '/user-profile',
        icon: 'mdi-account',
        text: '개인 정보'
      },
      {
        to: '/table-list',
        icon: 'mdi-clipboard-outline',
        text: '회원 목록'
      },
      {
        to: '/notifications',
        icon: 'mdi-bell',
        text: '공지사항'
      }
    ],
    responsive: false
  }),
  computed: {
    ...mapState('app', ['image', 'color']),
    inputValue: {
      get () {
        return this.$store.state.app.drawer
      },
      set (val) {
        this.setDrawer(val)
      }
    },
    items () {
      return this.$t('Layout.View.items')
    },
    sidebarOverlayGradiant () {
      return `${this.$store.state.app.sidebarBackgroundColor}, ${this.$store.state.app.sidebarBackgroundColor}`
    }
  },
  mounted () {
    this.onResponsiveInverted()
    window.addEventListener('resize', this.onResponsiveInverted)
  },
  beforeDestroy () {
    window.removeEventListener('resize', this.onResponsiveInverted)
  },
  methods: {
    ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
    onResponsiveInverted () {
      if (window.innerWidth < 991) {
        this.responsive = true
      } else {
        this.responsive = false
      }
    }
  }
}
</script>

<style lang="scss">
  #app-drawer {
    .v-list__tile {
      border-radius: 4px;

      &--buy {
        margin-top: auto;
        margin-bottom: 17px;
      }
    }

    .v-image__image--contain {
      top: 9px;
      height: 60%;
    }

    .search-input {
      margin-bottom: 30px !important;
      padding-left: 15px;
      padding-right: 15px;
    }

    div.v-responsive.v-image > div.v-responsive__content {
      overflow-y: auto;
    }
  }
</style>
