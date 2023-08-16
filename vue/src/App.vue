<template>
  <div id="app">
    <div id="nav">
      <!-- <img id="paws" src="..\public\pawprintswhite.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       -->
      <ul>
      <li class="dropdown">
          <router-link class="navlink" id="dropbtn" v-bind:to="{ name: 'home' }">Adopt</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="dropdown-content">
            <router-link class="navlink" v-bind:to="{ name: 'cats' }">Cats</router-link>
            <router-link class="navlink" v-bind:to="{ name: 'dogs' }">Dogs</router-link>
            <router-link class="navlink" v-bind:to="{ name: 'rabbits' }">Rabbits</router-link>
          </div>
      </li>
      </ul>
      <router-link class="navlink" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'support' }">Support</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-if="$store.state.token === ''" to="/login">Login/Register</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <!-- <img id="paws" src="..\public\pawprintswhitemirror.png">
     -->
    </div>

    <div class="banner" id="banner">
      <img id="dogslogo" src="..\public\img\1.png">
      <img id="pawlogo" src="..\public\logo-png.png">
      <img id="catslogo" src="..\public\img\2.png">
    </div>
    <router-view />

    <footer>
      <p>©Copyright 2023 All Rights Reserved "Paw Prints Pet Rescue"</p>
    </footer>

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
	background: linear-gradient(to right, #ff7b00, #d16602, #ff7b00);
  border-radius: 10px; 
  height:33px;
}

#banner{
  display:flex;
 justify-content: center;
  height:125px;
  }

  .banner img {

    
  } 
   #nav a:hover{
    background-color: #ffffff;
    border-radius: 5px;;
    color: #d16602;
  } 

  #nav > a {
  color: white; 
  font-size: 20px;
  text-decoration: none;
  
}
  a {
  box-shadow: inset 0 0 0 0 #d16602;
  color: #ffffff;
  padding: 0 .25rem;
  margin: 0 -.25rem;
  transition: color .3s ease-in-out, box-shadow .3s ease-in-out;
  border-radius: 8px;
}
a:hover {
  color: #d16602;
  box-shadow: inset 200px 0 0 0 #ffffff;
  border-radius: 8px;
}


a {
  color: #ffffff;
  font-size: 20px;
  line-height: 1.5;
  text-decoration: none;
}


li.dropdown {
  display: inline-block;
  
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 100px;
  z-index: 1;
  color: #d16602;
  border-radius: 5px;
  box-shadow: 2.5px 10px 25px #000;
 
}

.dropdown-content a {
  color: #d16602;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
  
}

.dropdown-content a:hover {
  /* background-color: #d16602; */

  
  }

.dropdown:hover .dropdown-content {
  display: block;
  
 
}
#app > footer > p {
  display: flex;
  justify-content: center;
}
  
</style>
