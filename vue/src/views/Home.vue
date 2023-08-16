<template>
<div id="home">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
<h3 class="title"  id="allpets">Pets for Adoption</h3>
<div class="container">  
  <div class="content" v-for="pets in filteredSpecies" :key="pets.id" > 
      <div class="content-overlay"></div>
        <img class="content-image" v-bind:src= "pets.picture">
      <div class="content-details fadeIn-bottom">
        <p class="content-title">{{pets.petName}}</p>
        <p class="content-text">{{pets.description}}</p>
        <p class="content-text">{{pets.age}}</p>
        <p class="content-text">{{pets.sex}}</p>
        <button v-on:click="updatePet">Edit Pet</button>
        <button v-on:click="deletePet">Delete Pet</button>

      </div>
  </div>
<div class="container">
    <div class="content">
     <div class="content-overlay"></div>
        <img class="content-image" src="..\public\logo-png.png">
      <div class="content-details fadeIn-bottom">
  
      <form v-on:submit.prevent="submitForm">
        <p for ="petName" class="new-content-title">Add A Pet</p>
        <input type="text" id="name" v-model="pets.petName" placeholder="Name" required />

        <p for ="petDescription" class="new-content-title"></p> 
        <input for ="text" id="description" v-model="pets.description" placeholder="Description" required />
        
        <label for ="petAge" class="new-content-title"></label> 
        <input type="text" id="age" v-model="pets.age" placeholder="Age" required />
        
        <label for ="petSex" class="new-content-title" ></label> 
        <input type="text" id="gender" v-model="pets.sex" placeholder="Gender" required />

        <label for ="petSpecies" class="new-content-title"></label> 
        <input type="text" id="species" v-model="pets.species" placeholder="Species" required />

         <label for ="petUrl" class="new-content-title"></label> 
        <input type="text" id="url" v-model="pets.picture" placeholder="Picture Url" required />

        <label for ="Status" class="new-content-title"></label> 
        <input type="text" id="url" v-model="pets.isAdopted" placeholder="Adopted? true/false" required />
        <button type="submit" >Submit</button> 


</form>
  </div>
  </div>
</div>
  </div>
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
        pet_id: '',
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
          const filteredSpecies=this.petList.filter(pets => !pets.adopted);
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
  
    
  
    submitForm() {
      petService
        .addPet(this.pets)
        .then((response) => {
          if (response.status == 201) {
            this.resetForm()
            alert("Pet Sucessfully Added!")
            location.reload()
            
          }
        })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    resetForm() {
      this.pets.name = '',
      this.pets.age ='',
      this.pets.sex='',
      this.pets.species='',
      this.pets.picture='',
      this.pets.description=''
   },
   deletePet() {
     if ( confirm("Are you sure you want to delete this pet"))
     PetService.deletePet(this.pets.pet_id)
     .then(response => {
       if (response.status === 200) {
         alert("Pet successfully deleted");
         this.$router.push(`/${this.pets.pet_id}`)
       }
     })
     }
	},
    updatePet() {
      PetService.updatePet(this.pets.pet_id)
      .then(response => {
       if (response.status === 200) {
         alert("Pet successfully selected");
       }
      })
      
  }

    
};
    
</script>


<style scoped>
#home {
	justify-content: center;
    padding-top:5px;
	align-items: center;
	min-height: 100vh;
	font-family: 'Jost', sans-serif;
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
    border-radius:20px;
}
div.main {
  
}
.container {
  display:flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
  margin-right:80px;
  margin-left:80px;
  background-color: white;
  border-radius:20px;
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
  width: 400px;
  height:400px;
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
  height: 400px;
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
#home > div > div.container > div > div.content-details.fadeIn-bottom > form > p:nth-child(1) {
  font-size:35px;
}
</style>