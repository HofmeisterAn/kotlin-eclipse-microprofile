<template>
  <div>
    <button v-on:click="preview">Preview</button>
    <span>{{ id }}</span>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import { HttpCommon } from '../../common/HttpCommon';

export default Vue.extend({
  data() {
    return {
      id: ''
    };
  },
  methods: {
    preview(): void {
      new HttpCommon().axios.get('students/query', {
        params: {
          start: 1,
          size: 10
        }
      })
      .then((response) => {
        this.id = response.data.id;
      })
      .catch((error) => {
        this.id = error;
      });
    }
  }
});
</script>
