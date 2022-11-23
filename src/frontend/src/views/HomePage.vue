<template>
<div>
  <h1>Welcome on Kittinder!</h1>
  <p>Your token: {{this.$store.state.accessToken}}</p>
</div>
</template>

<script>
export default {
  name: "HomePage",
  onIdle () {
    this.$store.dispatch('userLogout')
        .then(() => {
          this.$router.push({name: 'login'})
        })
  },
}
</script>

<style scoped>

</style>