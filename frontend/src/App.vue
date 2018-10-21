<template>
  <div id="app">
    <div id="nav">
      <router-link to="/students">Students</router-link>
    </div>
    <router-view/>
    <Login />
  </div>
</template>

<script>
import Login from '@/components/login/Login.vue';

export default {
  name: 'App',
  components: {
    Login
  }
};
</script>
