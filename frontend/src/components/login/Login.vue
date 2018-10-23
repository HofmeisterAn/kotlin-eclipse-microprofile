<template>
  <div>
    <button v-on:click="login">Login</button>
  </div>
</template>

<script lang="ts">
import Cookies from 'js-cookie';
import Vue from 'vue';
import { HttpCommon } from '../../common/HttpCommon';

const cookieName = 'access_token';

export default Vue.extend({
  methods: {
    login(): void {
      new HttpCommon().axios.post('login', {
        username: 'username',
        password: 'password'
      })
      .then((response) => {
        Cookies.set(cookieName, response.data.token, { expires: 7 });
      })
      .catch((error) => {
        Cookies.remove(cookieName);
      });
    }
  }
});
</script>
