<template>
  <div>
    <button v-on:click="detail">Detail</button>
    <span>{{ fullName }}</span>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import { HttpCommon } from '../../common/HttpCommon';

export default Vue.extend({
  data() {
    return {
      id: '00000000-0000-0000-0000-000000000000',
      fullName: ''
    };
  },
  methods: {
    detail(): void {
      new HttpCommon().axios.get(`students/${this.id}`)
      .then((response) => {
        this.fullName = response.data.fullName;
      })
      .catch((error) => {
        this.fullName = error;
      });
    }
  }
});
</script>
