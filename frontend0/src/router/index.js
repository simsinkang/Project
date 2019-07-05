import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Mypage from '@/components/member/Mypage'
import JoinForm from '@/components/member/JoinForm'
import LoginForm from '@/components/member/LoginForm'
import MemberList from '@/components/member/MemberList'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {path: '/', name: 'Home', component: Home},
    {path: '/mypage', name: 'mypage', component: Mypage},
    {path: '/joinform', name: 'JoinForm', component: JoinForm},
    {path: '/loginform', name: 'loginform', component: LoginForm},
    {path: '/memberlist', name: 'memberlist', component: MemberList}
  ]
})
