<template>
  <div>
    Number of students: <span class="emphasis">{{ count }}</span> {{ fooBar }}.
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import { HttpCommon } from '../../common/HttpCommon';

export default Vue.extend({
  data() {
    return {
      count: -1
    };
  },
  mounted() {
    new HttpCommon().axios.get('students')
    .then((response) => {
      this.count = response.data.length;
    })
    .catch((error) => {
      // Handle errors.
    });
  },
  methods: {
    foo(): string { return 'foo'; },
    bar(): string { return 'bar'; }
  },
  computed: {
    fooBar(): string {
      return this.foo() + this.bar();
    }
  }
});
</script>

<style>
.emphasis {
  color: red;
}
</style>
