<template>
<div class="support">
    <head>
	<title>Support</title>
	<link rel="stylesheet" type="text/css" href="slide navbar style.css">
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
  <button class="button" v-on:click="SubmitDonation">Donate Now</button>
</body>


      </div>
</template>

<script>
export default {

}
</script>

<style>
#app > div.support {
	justify-content: center;
  padding-top:5px;
	align-items: center;
	min-height: 100vh;
	font-family: 'Jost', sans-serif;
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
   border-radius:20px;
}
#body > button {
  background-color:black
  
}


h1 {
  color: white;
  text-align: center;
}
p {
  color: white;
  text-align: center;
}
* {
  font-family: "Jost";
}
</style>