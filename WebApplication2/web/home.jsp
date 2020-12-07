
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<title>BugOverflow</title>
<link rel="stylesheet" href="home.css">
</head>
<body>
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">

  
<div class="header">

<marquee scrollamount="10">
    
  <div>

  <h1>BugOverflow</h1>
  <h3>Always ready to solve your bugs!</h3>
    </div>

	<div id="bug"> 
	<img src="https://www.kindpng.com/picc/m/156-1568327_clip-art-free-bugs-cliparts-download-cartoon-insects.png" width="250" height="150">
	</div>
	
</marquee>
</div>

<div class="topnav">
  <nav>
  <a href="#" id="home_tab">Home</a>
  <a  href="#" id="profile_tab">Profile</a>
  <a href="FAQ.html">FAQ</a>
    <a href="about.html">About Us</a>
	<a href="contact.jsp">Contact Us</a>
   <a href="login.html" style="float:right">Logout</a>
    </nav>
</div>

<div class="container-fluid">
    <div class="background">
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
      <div class="cube"></div>
    
    
<div id="home_page">
  <div class="column left">
    <h2>Notifications</h2>
  </div>
  
  <div class="column middle">
    <figure>
    <img src="https://blog.hyperiondev.com/wp-content/uploads/2019/01/Blog-Avoid-Bugs-Programming.jpg"width="450" height="300">
</figure>
    <section>
    <h2>For developers, by developers</h2>
    <p><b>Bug Overflow is an open community for anyone that codes. We help you get answers to your toughest coding questions, share knowledge with your coworkers in private, and find your next dream job.</b></p>
   </section>  
    <h2>Create your first post! </h2>  
	
	<button onclick="window.location.href='create_post_register.jsp'">Create Post</button>
        
        <h2>See some existing posts ! </h2>
        <form action="show" method="post">
    <input type="submit" value="View Post" />
   </form>

  </div>
  
  <div class="column right">
 
    <article>
     <%  String username = request.getParameter("username"); %>
    <h2>Welcome, <% out.println(username); %> </h2>
    
      </article>
  
  </div>
  
</div>
    
    <div id="profile_page">
      <h2>My Profile</h2>
	  
	  <img src="https://t3.ftcdn.net/jpg/00/64/67/80/240_F_64678017_zUpiZFjj04cnLri7oADnyMH0XBYyQghG.jpg"> <br>

        <%  
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";
String userId = "root";
String password = "bugoverflow";
String email =null;
  String phone =null;
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet rs = null;

try {
connection = DriverManager.getConnection(
connectionUrl , userId, password);
PreparedStatement ps=connection.prepareStatement(
"select * from profile where username=?");
ps.setString(1,username);

rs=ps.executeQuery();
rs.next();
email=rs.getString("email");
phone=rs.getString("phone");

}

catch (Exception e) {
e.printStackTrace();
}
%>

<div>
  <form action="profile" method="post"> <br>
    <label for="pic">Profile photo</label> <br><br>
    <input type="file" id="pic" name="pic"> <br><br>
    
    <label for="uname">Username</label> <br>
    <input type="text" id="uname" name="uname" value="<% out.println(username); %>" required> <br>

    <label for="pw">Current Password</label> <br>
    <input type="password" id="pw" name="pw" required > <br>
    
    <label for="npw">New Password</label> <br>
    <input type="password" id="npw" name="npw" pattern="[A-Za-z0-9]{8,}" title="at least 8 characters" > <br>
    
    <label for="eid">Email ID</label> <br>
    <input type="email" id="eid" name="eid" value=" <% out.println(email); %>" required > <br>
    
    <label for="mno">Mobile No </label> <br>
    <input type="tel" id="mno" name="mno" pattern="[0-9]{10}" title="10 digit no." value="<% out.println(phone); %>" required > <br>
  
    <br><input type="submit" value="Save Changes">
  </form>
  
  <form action="delete-profile.html">
    <input type="submit" value="Delete Profile" />
   </form>
</div>

     </div>
 
   
<script type="text/javascript" src="home.js"></script>  
</body>
</html>

