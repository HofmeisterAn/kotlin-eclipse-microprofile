<template>
  <diV>
    <CountOfStudents />
    <DetailOfStudent />
    <PreviewOfStudents />
  </diV>
</template>

<script>
import CountOfStudents from '@/components/students/CountOfStudents.vue';
import DetailOfStudent from '@/components/students/DetailOfStudent.vue';
import PreviewOfStudents from '@/components/students/PreviewOfStudents.vue';

export default {
  name: 'students',
  components: {
    CountOfStudents,
    DetailOfStudent,
    PreviewOfStudents
  }
};
</script>
