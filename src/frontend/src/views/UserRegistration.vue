<template>
<div>
  <form v-on:submit.prevent="register">
    <h1>Register</h1>
    <p v-if="error">{{error}}</p>
    <div>
      <label for="username">Username:</label>
      <input type="text" required id="username" v-model="userDTO.username" placeholder="Enter your username">
    </div>
    <div>
      <label for="email">E-mail:</label>
      <input type="email" required id="email" v-model="userDTO.email" placeholder="Enter your e-mail address">
    </div>
    <div>
      <label for="pw">Password:</label>
      <input type="password" required id="pw" v-model="userDTO.password" placeholder="Enter your password">
    </div>
    <div>
      <label for="pw2">Password 2:</label>
      <input type="password" required id="pw2" v-model="password2" placeholder="Password confirmation">
    </div>
    <button type="submit">Register</button>
  </form>
</div>
</template>

<script>
import {getAPI} from "@/axios-api"

export default {
  name: "UserRegistration",
  data() {
    return {
      userDTO : {
        username: '',
        password: '',
        email: ''
      },
      password2: '',
      error: ''
    }
  },
  methods: {
    register() {
      if(this.checkPasswords()){
        getAPI.post('/api/register', {
          userRegistrationDTO: this.userDTO
        })
            .then(() => {
              console.log('PostAPI has received data')
              this.$router.push('/login')
            })
            .catch((err) => {
              console.log(err)
            })
      } else {
        this.error = 'Passwords must match!'
      }

    },
    checkPasswords(){
      return this.userDTO.password === this.password2
    }
  }
}
</script>

<style scoped>

</style>