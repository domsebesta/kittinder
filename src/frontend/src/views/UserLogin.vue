<template>
<div>
  <form v-on:submit.prevent="login">
    <h1>Login</h1>
    <p v-if="error">{{error}}</p>
    <div>
      <label for="username">Username:</label>
      <input type="text" required id="username" v-model="username">
    </div>
    <div>
      <label for="pw">Password:</label>
      <input type="password" required id="pw" v-model="password">
    </div>
    <button type="submit">Login</button>
  </form>
</div>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      username: '',
      password: '',
      error: ''
    }
  },
  methods: {
    login() {
      this.$store.dispatch('userLogin', {
        username: this.username,
        password: this.password
      })
          .then(() => {
            this.$router.push("/")
          })
          .catch(err => {
            this.error = 'Wrong credentials'
            console.log(err)
          })
    }
  }
}
</script>

<style scoped>

</style>