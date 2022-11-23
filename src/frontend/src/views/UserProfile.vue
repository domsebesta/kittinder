<template>
<div>
  <h1>Profile</h1>
  <button><router-link to="/logout">Logout</router-link></button>
</div>
</template>

<script>
import {getAPI} from "@/axios-api"
import {mapState} from "vuex"
export default {
  name: "UserProfile",
  onIdle () {
    this.$store.dispatch('userLogout')
        .then(() => {
          this.$router.push({name: 'login'})
        })
  },
  computed: mapState(['APIData']),
  created() {
    getAPI.get('/api/', { headers: { Authorization: `Bearer ${this.$store.state.accessToken}`}})
        .then(response => {
          console.log('Get API has received data')
          this.$store.state.APIData = response.data
        })
        .catch(err => {
          console.log(err)
        })
  }
}
</script>

<style scoped>

</style>