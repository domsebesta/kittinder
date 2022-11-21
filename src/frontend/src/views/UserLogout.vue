<template>
<div>
  <h1>Bye bye</h1>
  <button><router-link to="/login">Beck to login?</router-link></button>
</div>
</template>

<script>
export default {
  name: "UserLogout",
  created(){
    this.$store.dispatch('userLogout')
  }
}
</script>

<style scoped>

</style>