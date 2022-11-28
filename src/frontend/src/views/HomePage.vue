<template>
<div id="container">
  <h1>Welcome on Kittinder!</h1>
  <button class="learn-more" id="left">
    <router-link to="/login">
  <span class="circle" aria-hidden="true">
  <span class="icon arrow"></span>
  </span>
    <span class="button-text">Login</span>
    </router-link>
  </button>
  <button class="learn-more" id="right">
    <router-link to="/register">
  <span class="circle" aria-hidden="true">
  <span class="icon arrow"></span>
  </span>
      <span class="button-text">Register</span>
    </router-link>
  </button>
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
#container{
  margin: 0;
  width: 100%;
  height: 100%;
  background-image: url("../assets/kittens1.jpg");
  background-size: cover;
  position: absolute;

}
h1{
  text-align: center;
  font-weight: lighter;
  margin-top: 30px;
}
button {
  position: relative;
  display: inline-block;
  cursor: pointer;
  outline: none;
  border: 0;
  vertical-align: middle;
  text-decoration: none;
  background: transparent;
  padding: 0;
  font-size: inherit;
font-weight: bold;
  font-family: 'Nunito', sans-serif;
}

button.learn-more {
  width: 12rem;
  height: auto;
}

button.learn-more .circle {
  transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
  position: relative;
  display: block;
  margin: 0;
  width: 3rem;
  height: 3rem;
  background: #282936;
  border-radius: 1.625rem;
}

button.learn-more .circle .icon {
  transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
  position: absolute;
  top: 0;
  bottom: 0;
  margin: auto;
  background: #fff;
}

button.learn-more .circle .icon.arrow {
  transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
  left: 0.625rem;
  width: 1.125rem;
  height: 0.125rem;
  background: none;
}

button.learn-more .circle .icon.arrow::before {
  position: absolute;
  content: "";
  top: -0.29rem;
  right: 0.0625rem;
  width: 0.625rem;
  height: 0.625rem;
  border-top: 0.125rem solid #fff;
  border-right: 0.125rem solid #fff;
  transform: rotate(45deg);
}

button.learn-more .button-text {
  transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  padding: 0.75rem 0;
  margin: 0 0 0 1.85rem;
  color: #282936;
  font-weight: bold;
  line-height: 1.6;
  text-align: center;
  text-transform: uppercase;
  letter-spacing: 2px;
  text-shadow: 3px 4px 7px rgba(81, 67, 21, 0.8);

}

button:hover .circle {
  width: 100%;
}

button:hover .circle .icon.arrow {
  background: #fff;
  transform: translate(1rem, 0);
}

button:hover .button-text {
  color: #fff;
  font-weight: lighter;
}
#left{
  position: absolute;
  top: 30px;
  left: 20px;

}
#right{
  position: absolute;
  top: 30px;
  right: 20px;

}

</style>