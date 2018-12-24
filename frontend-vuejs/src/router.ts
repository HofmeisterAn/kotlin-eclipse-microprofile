import Vue from 'vue';
import Router from 'vue-router';
import Students from './views/Students.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/students',
      name: 'students',
      component: Students
    }
  ]
});
