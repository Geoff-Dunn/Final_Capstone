<template>
  <div class="home">
    <h1>Paw Prints Pet Rescue</h1>
    <p>Everyone can see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>


<style scoped>
#app > div.home {
	justify-content: center;
  padding-top:5px;
	align-items: center;
	min-height: 100vh;
	font-family: 'Jost', sans-serif;
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
}
h1 {
  color: white;
  text-align: center;
}
p {
  color: white;
  text-align: center;
}
</style>