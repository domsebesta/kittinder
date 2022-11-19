<template>
<div>{{APIData}}</div>
</template>

<script>
import {getAPI} from "@/axios-api"
import {mapState} from "vuex"
export default {
  name: "UserProfile",
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