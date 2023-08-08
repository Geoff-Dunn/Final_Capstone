<template>

  <div id="app">
    <div id="nav">
      <!-- <img src="src/asset/logo.png"> -->
      <router-link class="navlink" v-bind:to="{ name: 'home' }">|  Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-if="$store.state.token === ''" to="/login">Login/Register  |  </router-link>
      <router-link class="navlink" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'support' }">Support</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style scoped>
#nav {
  display:flex;
  justify-content: center;
  padding: 15px;
	background: #d16602;
}
#nav > a {
  color: black;  
  font-size: 20px;
  text-decoration: none;
}
</style>
