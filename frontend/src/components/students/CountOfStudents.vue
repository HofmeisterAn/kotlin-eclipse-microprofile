<template>
  <div>
    <span class="emphasis">{{ count }}</span>
    dadasd
  </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
    props: {
      count22: Number
    },
    data() {
        return {
            count: 9
        }
    },
    methods: {
        foo(): string { return "foo"; },
        bar(): string { return "bar"; }
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