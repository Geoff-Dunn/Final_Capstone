<template>
  <div id="dogs">
      <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
      <h3 class="title" id="dogsection">Dogs for Adoption</h3>
<div class="container">  
  
  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_1.jpg">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  
  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_2.webp">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  
  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_3.jpg">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_4.jpg">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_5.webp">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_6.webp">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_7.webp">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>

  <!-- <h3 class="title">Text fadeIn bottom</h3> -->
  <div class="content">
    <!-- <a href="..\public\img\cats\cat_2.jpg" target="_blank"> -->
      <div class="content-overlay"></div>
      <img class="content-image" src="..\public\img\dogs\dog_8.jpg">
      <div class="content-details fadeIn-bottom">
        <h3 class="content-title">This is a title</h3>
        <p class="content-text">This is a short description</p>
      </div>
    <!-- </a> -->
  </div>
</div>
  </div>
</template>

<script>
export default {
    name:"dogs",

}
</script>

<style scoped>
#dogs {
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
</style>