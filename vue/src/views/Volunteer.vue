<template>
  <div id="volunteer">
    <form v-on:submit.prevent="volunteerSubmit">

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
      <!-- <h2  v-if="$store.state.user.authorities[0].name === 'ROLE_ADMIN'">You are an admin!</h2> -->
      <label for="chk" aria-hidden="true">Volunteer Signup</label>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group"> 
        <input type="text" id="Name" v-model="newVolunteer.fullName" placeholder="Full Name" required autofocus />
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
    <div class="volunteerList" v-if="!this.hideForm()">
      <table>
        <tr id="vList">
          <th>Name</th>&nbsp;&nbsp;
          <th>Phone Number</th>&nbsp;&nbsp;
          <th>Active</th>
        </tr>
        <tr id="vList" v-for="volunteer in volunteerList" v-bind:key="volunteer.id">
          <td>{{volunteer.fullName}}</td>&nbsp;&nbsp;
          <td>{{volunteer.phoneNumber}}</td>&nbsp;&nbsp;
          <td>{{volunteer.isActive}}</td>
        </tr>
      </table>
    </div>
	</div>
</body>


    </form>
  </div>

</template>

<script>
import axios from 'axios';
import volunteerService from "../services/VolunteerService";
import VolunteerService from '../services/VolunteerService';

export default {
  name: "volunteer",
  components: {},

  
  data() {
    return {
      volunteerList:[],
      newVolunteer: {
        fullName: '',
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
          .then ( (response) => {
          this.volunteerList = response.data;
      });
  },
  methods: {
    submitForm() {
      volunteerService
        .volunteerSubmission(this.newVolunteer)
        axios.post('/volunteer', this.newVolunteer)
        .then(response => {
          if (response.status == 200) {

            
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
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
      VolunteerService.getVolunteers()
      axios.get(`/volunteer`)
      .then ( (response) => {
          this.volunteerList = response.data
      });
    },

    hideForm() {
      if (this.$store.state.user.authorities[0].name !== 'ROLE_ADMIN' && this.$store.state.user.authorities[0].name !== 'volunteer'){
        return true
      }
    }
    
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

.volunteerList {
  color: white;
  display:flex;
  justify-content: space-evenly;
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
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
  padding-top:5px;
  border-radius:20px;
  
}
* {
  font-family: "Jost";
}
.main{
  width: 500px;
	height: 600px;
  margin-bottom: 100px;
	background: red;
	overflow: hidden;
	background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
	border-radius: 10px;
	box-shadow: 5px 20px 50px #000;
  

}
div.main {
  background: linear-gradient(to bottom, #3225a3, #221a6b, #161142);
  margin-top: 0%;
  margin-top:0px;
  

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
	width: 60%;
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