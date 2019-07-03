/**
 * Define all of your application routes here
 * for more information on routes, see the
 * official documentation https://router.vuejs.org/en/
 */
export default [
  {
    path: '/dashboard',
    view: 'Dashboard'
  },
  {
    path: '/user-profile',
    name: 'User Profile',
    view: 'UserProfile'
  },
  {
    path: '/joinform',
    name: 'joinform',
    view: 'JoinForm'
  },
  {
    path: '/login',
    name: 'Login',
    view: 'Login'
  },
  {
    path: '/table-list',
    name: 'Table List',
    view: 'TableList'
  },
  
  {
    path: '/notifications',
    view: 'Notifications'
  }
]
