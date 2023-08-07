<template>
  <div id="login">
    <form @submit.prevent="login">
      <!-- <h1 >Please Sign In</h1> -->
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

    <head>
	<title>Slide Navbar</title>
	<link rel="stylesheet" type="text/css" href="slide navbar style.css">
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">

			<div class="signup">
        <!-- <div class="form-input-group">
				<form>
					<label for="chk" aria-hidden="true">Sign up</label>
					<input type="text" name="txt" placeholder="User name" required="">
					
					<input type="password" name="pswd" placeholder="Password" required="">
					<button>Sign up</button>
				</form>
        </div> -->
			
      <div id="register" class="text-center">
    <form @submit.prevent="register">
      <label for="chk" aria-hidden="true">Register</label>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        
        <input type="text" id="username" v-model="newUser.username" placeholder="Username" required autofocus />
      </div>
      <div class="form-input-group">
       
        <input type="password" id="password" v-model="newUser.password" placeholder="Password" required />
      </div>
      <div class="form-input-group">
      
        <input type="password" id="confirmPassword" v-model="newUser.confirmPassword" placeholder="Confirm Password" required />
      </div>
      <button type="submit">Create Account</button>
      <!-- <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p> -->
    </form>
  </div>
      
      
      </div>

			<div class="login">
        <div class="form-input-group">
				<form>
					<label for="chk" aria-hidden="true">Login</label>
					<input type="text" name="text" id="username" placeholder="Username" v-model="user.username" required="">
					<input type="password" name="password" id="password" placeholder="Password" v-model="user.password" required="">
          </form>
      <button type="submit">Sign in</button>
      <!-- <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p> -->
        </div>
			</div>
	</div>
</body>


    </form>
  </div>





</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      newUser: {
        username: "",
        password: '',
        confirmPassword: '',
        role: 'user',

      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
      invalidCredentials: false
    };
    
  },
  methods: {
    login() {
      authService
        .login(this.user)
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
    register() {
      if (this.newUser.password != this.newUser.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.newUser)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
  
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
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
}
.main{
	width: 350px;
	height: 500px;
	background: red;
	overflow: hidden;
	background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
	border-radius: 10px;
	box-shadow: 5px 20px 50px #000;
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
	background: #573b8a;
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
	background: #6d44b8;
}
.login{
	height: 460px;
	background: #eee;
	border-radius: 60% / 10%;
	transform: translateY(-180px);
	transition: .8s ease-in-out;
}
.login label{
	color: #573b8a;
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