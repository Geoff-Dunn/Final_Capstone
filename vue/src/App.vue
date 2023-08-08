<template>

  <div id="app">
    <div id="nav">
      
      <router-link class="navlink" v-bind:to="{ name: 'home' }">|  Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-if="$store.state.token === ''" to="/login">Login/Register  |  </router-link>
      <router-link class="navlink" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'support' }">Support</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <div id="banner">
      <img src="..\public\img\Banner.png" alt="picture of animals">
    </div>
    <router-view />
  </div>
</template>


<style scoped>
* {
  font-family: "Jost";
}
#nav {
  color: white;
  display:flex;
  justify-content: center;
  padding: 15px;
	background: linear-gradient(to right, #d16602, #9c4c01, #d16602);
  
}
#nav > a {
  color: white; 
  font-size: 20px;
  text-decoration: none;
  /* font-weight: bolder; */
}
#banner {
  display:flex;
  justify-content: center;
  }
  img {
    width: 75vh;
    /* height: 50vh; */
  }
  
</style>
