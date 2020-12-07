<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.servlet.http.*,javax.servlet.*,java.sql.*" %>
<html>
<title>Welcome</title>      
<style type="text/css">
body {
  font-family: 'Josefin Sans', sans-serif;
  box-sizing: border-box;
}
.container-fluid{
  height: 100%;
  margin: 0;
  padding: 0;
  width: 100%;
  background: #FFF;
}
.background {
  background: linear-gradient(132deg,#FA8072, #FC415A, #591BC5, #212335);
  background-size: 1000% 1000%;
  animation: Gradient 15s ease infinite;
  position: relative;
  height: 100vh;
  width: 100%;
  overflow: hidden;
  padding:0;
  margin:0px;
}
.cube {
  position: absolute;
  top: 80vh;
  left: 45vw;
  width: 10px;
  height: 10px;
  border: solid 1px #D7D4E4;
  transform-origin: top left;
  transform: scale(0) rotate(0deg) translate(-50%, -50%);
  animation: cube 12s ease-in forwards infinite;
}
.cube:nth-child(2n) {
  border-color: #FFF ;
}
.cube:nth-child(2) {
  animation-delay: 2s;
  left: 25vw;
  top: 40vh;
}
.cube:nth-child(3) {
  animation-delay: 4s;
  left: 75vw;
  top: 50vh;
}
.cube:nth-child(4) {
  animation-delay: 6s;
  left: 90vw;
  top: 10vh;
}
.cube:nth-child(5) {
  animation-delay: 8s;
  left: 10vw;
  top: 85vh;
}
.cube:nth-child(6) {
  animation-delay: 10s;
  left: 50vw;
  top: 10vh;
}
/* ================= Header ============ */
header{
  position: absolute;
  top:0%;
  left: 0%;
  width:100%;
  margin: 0;
  padding: 0;
}
/* navbar */

/* Logo */
.logo{
  width: 40px;
  height: 40px;
  background: #EFEEF5;
  margin: 40px 63px;
  float: left;
  transform: rotate(-30deg);
}
.logo span{
  color: #591BC5;
  font-size: 2em;
  line-height: 1.4;
  padding-left: 5px;
  font-weight: bold;
}
/* Header content & title & button*/
.header-content{
  margin-top:8%;
  text-align: center;
  color:  #EFEEF5;
}
.header-content h1{
  text-transform: uppercase;
  font-size: 3em;
  letter-spacing: 1px;
}
.header-content p {
  font-size: 20px;
  line-height: 1.5;
  margin: 20px auto;
}
.header-content button{
  width: 140px;
  margin:20px 10px;
  color: #591BC5;
  font-size: 17px;
  border:1px solid #EFEEF5;
  font-weight: 500;
  background: #EFEEF5;
  border-radius: 20px;
  padding: 10px;
  cursor:pointer;
  transition: .3s;
}
.header-content button:hover{
  border-radius: 0;
}
/* Animate Background*/
@keyframes Gradient {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
@keyframes cube {
  from {
    transform: scale(0) rotate(0deg) translate(-50%, -50%);
    opacity: 1;
  }
  to {
    transform: scale(20) rotate(960deg) translate(-50%, -50%);
    opacity: 0;
  }
}

</style>
<body>
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">

  <div class="container-fluid">
    <div class="background">
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
      <div class="cube"></div>
    </div>
   <header>
      <div class="logo"><span><img src="logo.png" width="35px" height="40px"></span></div>
      <section class="header-content">
      <h2>Add Student</h2>
      <form name="register" action="newstd" method="POST" >
        
        <div class="form-group">
          <label for="fname">First Name:</label>
          <input type="text" size=65 class="form-control" id="fname" name="fname" pattern="^[A-Z][a-z]+" placeholder="First name" title="Enter First as capital letter followed by small letters(exclude numbers and specialcharacters except space)" required>
          <br>
        </div>
          <br>
        <div class="form-group">
          <label for="lname">Last Name:</label>
          <input type="text" size=65 class="form-control" id="lname" name="lname" pattern="^[A-Z][a-z]+" placeholder="Last name" title="Enter First as capital letter followed by small letters(exclude numbers and specialcharacters except space)" required>
          <br>
        </div>
        <br>
        <div class="form-group">
          <label for="fathername">Father Name:</label>
          <input type="text" size=65 class="form-control" id="fathername" name="fathername" pattern="^[A-Z][a-z]+" placeholder="Father name" title="Enter First as capital letter followed by small letters(exclude numbers and specialcharacters except space)" required>
          <br>
        </div>
        <br>
        <div class="form-group">
          <label for="sex">Sex:</label>
          <input type="radio" name="sex" value="male" size="10" >Male
          <input type="radio" name="sex" value="Female" size="10" >Female
          <br>
        </div>
        <br>
         <div class="form-group">
            <label for="Objective">Course:</label>
            <input type="text" size=65 name="obj" class="form-control"  required>
            <br>
        </div>

<br>
         
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="text" size=65 class="form-control" id="email" name="emailid" pattern="^(([-\w\d]+)(\.[-\w\d]+)*@([-\w\d]+)(\.[-\w\d]+)*(\.([a-zA-Z]{2,5}|[\d]{1,3})){1,2})$" aria-describedby="emailHelp" placeholder="Enter email" title="Your email address" required>
            
            <br>
        </div>
<br>
        <div class="form-group">
            <label for="DOB">Birth Date:</label>
            <input type="text" size=65 class="form-control" id="DOB" name="dob" required>
            <br>
        </div>
<br>

        <div class="form-group">
            <label for="Username">Username:</label>
            <input type="text" size=65 class="form-control" id="Username" name="uname" required>
            <br>
        </div>
       <br>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" size=65 class="form-control" id="password" name="pass" required>
            <br>
        </div>
<br>

        <div class="form-group">
            <label for="address">Contact Address:</label>
            <textarea class="form-control" id="address" name="Address" rows="4" cols="50" placeholder="Mention permanent address" title="Enter your permanent address" required></textarea>
            <br>
        </div>
        <br>
        <div class="form-group">
            <label for="mobileno">Contact Number:</label>
            <input type="text" size=65 class="form-control" id="mobileno" name="mobileno" placeholder="Mobile no" title="Enter your mobile number" required>
            <br>
        </div>
        
       

        <button type="submit" class="btn btn-outline-light btn-md">Register</button>
      </form>

</section>
  </header>
</div>
</body>
</html>