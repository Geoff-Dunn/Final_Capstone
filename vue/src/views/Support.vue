<template>
<div id="cats">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
<h3 class="title"  id="allpets">Pets Who Found Their Forever Home</h3>
<div class="container">  
  <div class="content" v-for="pets in filteredSpecies" :key="pets.id" > 
      <div class="content-overlay"></div>
        <img class="content-image" v-bind:src= "pets.picture">
      <div class="content-details fadeIn-bottom">
        <p class="content-title">{{pets.petName}}</p>
        <p class="content-text">{{pets.description}}</p>
        <p class="content-text">{{pets.age}}</p>
        <p class="content-text">{{pets.sex}}</p>
      </div>
  </div>
  </div>
  <footer> 
    <body>

<form action="https://clevelandapl.org/donate/make-a-donation/" method="get" target="_blank">
         <button type="submit">Donate Now</button>
      </form>

</body>
  </footer>
</div>


  
</template>

<script>
import axios from 'axios';
import petService from '../services/PetService';
import PetService from '../services/PetService';

export default {
  name: "pets",
  component: {},

    data() {
    return {
      filteredSpecies:[],
      petList:[],
      pets: {
        petName: '',
        species: '',
        sex: '',
        age: '',
        isSpayedNeutered: '',
        description: '',
        picture: '',
        isAdopted: false
      },

      registrationErrors: false,
      registrationErrorMsg: 'The form could not be sumbitted.',
      invalidCredentials: false
    };
    },

  created() {
    
      PetService.getPets().then ( (response) => {
          this.petList = response.data;
          const filteredSpecies=this.petList.filter(pets => pets.adopted);
          this.filteredSpecies= filteredSpecies;
      });
      

      
        
  },

  computed: {
    getPetPicture() {return require(this.pets.picture);}
  },


  methods: {
    displayPets(){
      petService.displayPets()
      axios.get(`/`)
      .then ( (response) => {
          this.petList = response.data; 
          
      });
    },
    }
  

};
    
</script>


<style scoped>
#cats {
	justify-content: center;
    padding-top:5px;
	align-items: center;
	min-height: 100vh;
	font-family: 'Jost', sans-serif;
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
    border-radius:20px;
}

footer {
  display:flex;
  justify-content: center;
}
.container {
  display:flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
  margin-right:100px;
  margin-left:100px;
  background-color: white;
  border-radius:20px;
}
body > form > button {
  width: 80%;
	height: 150px;
  width: 300px;
  margin-top: 100px;
  margin-bottom: 150px;
	justify-content: center;
	display: block;
	color: #fff;
	background: #d16602;
	font-size: 2em;
	font-weight: bold;
	outline: none;
	border: none;
	border-radius: 10px;
	cursor: pointer;
}
h1 {
  color: white;
  text-align: center;
  font-size: 80px;
}

.title {
  color: white;
  text-align: center;
  font-size: 40px;
}
.adoptiontitle {
  color: white;
  text-align: center;
  font-size: 60px;
}
p {
  color: white;
  text-align: center;
}
* {
  font-family: "Jost";
}
.main-title{
  color: #1d1d1d;
  text-align: center;
  text-transform: capitalize;
  padding: 0.7em 0;
}

.container .title{
  color: #333;
  text-align: center;
}

.content {
  position: relative;
  width: 90%;
  width: 250px;
  height:250px;
  /* margin: auto; */
  margin-top: 20px;
  margin-bottom: 20px;
  overflow: hidden;
  border-radius: 20px;
	box-shadow: 2.5px 10px 25px #000
}

.content .content-overlay {
  background: rgba(0,0,0,0.7);
  position: absolute;
  height: 100%;
  width: 100%;
  left: 0;
  top: 0;
  bottom: 0;
  right: 0;
  opacity: 0;
  -webkit-transition: all 0.4s ease-in-out 0s;
  -moz-transition: all 0.4s ease-in-out 0s;
  transition: all 0.4s ease-in-out 0s;
}

.content:hover .content-overlay{
  opacity: 1;
}

.content-image{
  width: 100%;
  height: 250px;
}

.content-details {
  position: absolute;
  text-align: center;
  padding-left: 1em;
  padding-right: 1em;
  width: 100%;
  top: 50%;
  left: 50%;
  opacity: 0;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  -webkit-transition: all 0.3s ease-in-out 0s;
  -moz-transition: all 0.3s ease-in-out 0s;
  transition: all 0.3s ease-in-out 0s;
}

.content:hover .content-details{
  top: 50%;
  left: 50%;
  opacity: 1;
}

.content-details h3{
  color: #fff;
  font-weight: 500;
  letter-spacing: 0.15em;
  margin-bottom: 0.5em;
  text-transform: uppercase;
}

.content-details p{
  color: #fff;
  font-size: 0.8em;
}

.fadeIn-bottom{
  top: 80%;
}

.container a:visited {
    text-decoration: none;
}

.container a:hover {
    text-decoration: none;
}
p.content-title{
  font-size: 50px;
  text-decoration: underline;
}

p.content-text{
  font-size: 20px;
}
</style>