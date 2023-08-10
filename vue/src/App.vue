<template>

  <div id="app">
    
    <div id="nav">
        <img id="paws" src="..\public\pawprintswhite.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'home' }">Adopt</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'support' }">Support</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-if="$store.state.token === ''" to="/login">Login/Register</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <img id="paws" src="..\public\pawprintswhitemirror.png">
    </div>
    <div id="banner">
     
      <img src="..\public\img\Banner.png" alt="picture of animals"><img src="..\public\img\Banner.png" alt="picture of animals"><img src="..\public\img\Banner.png" alt="picture of animals">
    </div>
    <router-view />
  </div>
</template>


<style scoped>
* {
  font-family: "Jost";
}
#paws{
  height:70px;
  width:300px;
}
#nav {
  color: white;
  display:flex;
  justify-content: center;
  align-items: center;
  padding: 15px;
	background: linear-gradient(to right, #d16602, #9c4c01, #d16602);
  box-shadow: 2.5px 10px 25px #000;
  border-radius: 10px; 
  height:33px;
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}



#banner {
  display:flex;
  color:rgba(255, 255, 255, 0);
  justify-content: center;
  justify-content: space-between;

  /* box-shadow: 5px 20px 50px #000; */
  margin-bottom: 10px;
  margin-top: 10px;
  }

  img {
    width: 75vh;
    
  }
  #nav a:hover{
    /* background-color: #ffffff;
    border-radius: 5px;;
    color: #d16602; */
  }

  #nav > a {
  /* color: white; 
  font-size: 20px;
  text-decoration: none; */
  
}
  a {
  box-shadow: inset 0 0 0 0 #d16602;
  color: #ffffff;
  padding: 0 .25rem;
  margin: 0 -.25rem;
  transition: color .3s ease-in-out, box-shadow .3s ease-in-out;
}
a:hover {
  color: #d16602;
  box-shadow: inset 200px 0 0 0 #ffffff;
  border-radius: 8px;
}

/* Presentational styles */
a {
  color: #ffffff;
  font-size: 20px;
  line-height: 1.5;
  text-decoration: none;
}
  
</style>
