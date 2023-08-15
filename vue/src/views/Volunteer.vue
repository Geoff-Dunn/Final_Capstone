<template>
  <div id="volunteer">

    <head>
	<title>Slide Navbar</title>
	<!-- <link rel="stylesheet" type="text/css" href="slide navbar style.css"> -->
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="main">  	
			<div class="volunteerform" v-if="this.hideForm()">
			
      <div id="form" class="text-center">

    <form v-on:submit.prevent="submitForm">
      
      <label for="chk" aria-hidden="true">Volunteer Signup</label>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group"> 
        <input type="text" id="Name" v-model="newVolunteer.name" placeholder="Full Name" required autofocus />
      </div>
      <div class="form-input-group">
        <input type="number" id="age" v-model="newVolunteer.age" placeholder="Age" required />
      </div>
      <div class="form-input-group">
        <input type="tel" id="phone" v-model="newVolunteer.phoneNumber" placeholder="Phone Number" required />
      </div>
      <div class="form-input-group">
        <input type="text" id="address" v-model="newVolunteer.address" placeholder="Address" required />
      </div>
      <div class="form-input-group">
        <input type="email" id="email" v-model="newVolunteer.email" placeholder="Email" required />
      </div>
      <button type="submit" >Submit</button> 
    </form>

  </div>     
      </div>
    <!-- Volunteer list goes here -->
    <div class="volunteerList" v-if="this.showVolunteer()">
      <table>
        <tr id="vList">
          <th>Name</th>&nbsp;&nbsp;
          <th>Phone Number</th>&nbsp;&nbsp;
          <th>Active</th>
        </tr>
        <tr id="vList" v-for="volunteer in volunteerList" v-bind:key="volunteer.id">
          <td>{{volunteer.fullName}}</td>&nbsp;&nbsp;
          <td>{{volunteer.phoneNumber}}</td>&nbsp;&nbsp;
          <td>{{volunteer.isActive}}</td>&nbsp;&nbsp;
          <td>
            <button class="btnActivateDeactivate" v-on:click="toggleStatus(volunteer)">{{volunteer.isActive === "Active" ? "Deactivate" : "Activate" }}</button>
          </td>&nbsp;&nbsp;
        </tr>
      </table>
    </div>

    <div class="volunteerList" v-if="this.showAdmin()">
      <table>
        <tr id="vList">
          <th id="label">Name</th>&nbsp;&nbsp;&nbsp;&nbsp;
          <th id="label">Phone Number</th>&nbsp;&nbsp;
          <th id="label">Active</th>&nbsp;&nbsp;
          <th id="label">Address</th>&nbsp;&nbsp;
          <th id="label">Email</th>&nbsp;&nbsp;
          <th id="label">Age</th>&nbsp;&nbsp;
          <th id="label">Change Status</th>&nbsp;&nbsp;
          <th id="label">Delete</th>
        </tr>
        <tr id="vList" v-for="volunteer in volunteerList" v-bind:key="volunteer.id">
          <td>{{volunteer.fullName}}</td>&nbsp;&nbsp;
          <td>{{volunteer.phoneNumber}}</td>&nbsp;&nbsp;
          <td>{{volunteer.isActive}}</td>&nbsp;&nbsp;
          <td>{{volunteer.address}}</td>&nbsp;&nbsp;
          <td>{{volunteer.email}}</td>&nbsp;&nbsp;
          <td>{{volunteer.age}}</td>&nbsp;&nbsp;
          <td>
            <button class="btnActivateDeactivate" v-on:click="toggleStatus(volunteer)">{{volunteer.isActive === "Active" ? "Deactivate" : "Activate" }}</button>
          </td>&nbsp;&nbsp;
          <td><button v-on:click= "deleteVolunteer">Delete</button></td>
       
        </tr>
      </table>
    </div>

	</div>
</body>
   
  </div>

</template>

<script>
import axios from 'axios';
import volunteerService from  '../services/VolunteerService';
import VolunteerService from '../services/VolunteerService';

export default {
  name: "volunteer",
  components: {},

  
  data() {
    return {
      volunteerList:[],
      newVolunteer: {
        name: '',
        age: '',
        phoneNumber: '',
        address: '',
        email: '',
        role: 'volunteer',
        isActive: false
      },

      


      registrationErrors: false,
      registrationErrorMsg: 'The form could not be sumbitted.',
      invalidCredentials: false
    };
  },

  created() {
      VolunteerService.getVolunteers()
          .then ((response) => {
          this.volunteerList = response.data;
      });
  },
  methods: {
    
    submitForm() {
      this.newVolunteer.fullName = this.newVolunteer.name;
      volunteerService
        .volunteerSubmission(this.newVolunteer)
        // axios.post('/volunteer', this.newVolunteer)
        .then((response) => {
          if (response.status == 201) {
            this.resetForm()
            alert("Volunteer Form Sumbitted Sucessfully!")
            
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
    
    displayVolunteers(){
      VolunteerService.displayVolunteers()
      axios.get(`/volunteer`)
      .then ( (response) => {
          this.volunteerList = response.data
      });
    },

    hideForm() {
      if (this.$store.state.user.authorities[0].name !== 'ROLE_ADMIN' && this.$store.state.user.authorities[0].name !== 'ROLE_volunteer'){
        return true
      }
    },

    showAdmin() {
      if (this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'){
        return true
      }
    },

    showVolunteer() {
      if (this.$store.state.user.authorities[0].name === 'ROLE_volunteer'){
        return true
      }
    },
    resetForm() {
      this.newVolunteer.name = '',
      this.newVolunteer.age ='',
      this.newVolunteer.phoneNumber='',
      this.newVolunteer.address='',
      this.newVolunteer.email=''
   }
	},
  toggleStatus(volunteer){
      if (volunteer.isActive === "Active"){
        volunteer.isActive = "Inactive"
      }
      else {volunteer.isActive = "Active"}
    },
    deleteVolunteer(){
      
    }
};
</script>

<style scoped>
#label{
  font-size:22px;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

.volunteerList {
  color: white;
  display:flex;
  /* padding-left: 50px; */
  justify-content: space-evenly;

}

th td{
  display: flex;
  flex-direction: column;
  align-content: center;
  align-items: center;
  
}

button{
	width: 90%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: #fff;
	background: #d16602;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	outline: none;
	border: none;
	border-radius: 5px;
	transition: .2s ease-in;
	cursor: pointer;
}
button:hover{
	background: #444cb8;
}

/* ///// */

body{
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	font-family: 'Jost', sans-serif;
	/* background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e); */
    border-radius:20px;
  justify-content: center;
  padding-top:5px;
  border-radius:20px;
  
}
* {
  font-family: "Jost";
}
.main{
  width: 850px;
	height: 600px;
  margin-bottom: 330px;
	background: red;
	overflow: hidden;
	background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
	border-radius: 10px;
	box-shadow: 5px 20px 50px #000;
  

}
div.main {
  
  background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
  margin-top: 0%;
  margin-top:0px;
  width:2000px;
  

}
#chk{
	display: none;
}
.signup{
	position: relative;
	width:100%;
	height: 100%;
}
label{
	color: #fff;
	font-size: 2.3em;
	justify-content: center;
	display: flex;
	margin: 60px;
	font-weight: bold;
	cursor: pointer;
	transition: .5s ease-in-out;
}
input{
	width: 60%;
	height: 20px;
	background: #e0dede;
	justify-content: center;
	display: flex;
	margin: 20px auto;
	padding: 10px;
	border: none;
	outline: none;
	border-radius: 5px;
 
}
button{

	cursor: pointer;
}

.login{
	height: 460px;
	background: #eee;
	border-radius: 60% / 10%;
	transform: translateY(-180px);
	transition: .8s ease-in-out;
}
.login label{
	color: #d16602;
	transform: scale(.6);
}

#chk:checked ~ .login{
	transform: translateY(-500px);
}
#chk:checked ~ .login label{
	transform: scale(1);	
}
#chk:checked ~ .signup label{
	transform: scale(.6);
}

</style>