<template>
  <div>
    <button v-on:click="login">Login</button>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import { HttpCommon } from '../../common/HttpCommon';

export default Vue.extend({
  methods: {
    login(): void {
      new HttpCommon().axios.post('login')
      .then((response) => {
        localStorage.setItem('user-token', response.data);
      })
      .catch((error) => {
        localStorage.removeItem('user-token');
      });
    }
  }
});
</script>
