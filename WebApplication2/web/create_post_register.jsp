<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Signin and Signup</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="style_1.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">

  <div class="container-fluid">
    <div class="background">
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
       <div class="cube"></div>
      <div class="cube"></div>
    
	<script>
		function validateForm() {
		  var x = document.forms["create_post"]["title"].value;
		  var y = document.forms["create_post"]["lang"].value;
		  var z = document.forms["create_post"]["content"].value;
		  
		if (x == "" ||y==""|| z=="") {
			alert("This field must be filled out");
		}
		if (! isNaN(x) ||! isNaN(y) || ! isNaN(z)) {
				alert("This field cannot be a number");
    
            } 
			return false;
		  
		}
		</script>



<script>
function mOver(obj) {
  obj.className = "panel panel-danger"
}

function mOut(obj) {
  obj.className = "panel panel-info"
}
</script>


<br>


<div class="container">
<div class="row">
    <div class="col-sm-12">


		  <div class="panel panel-info" onmouseover="mOver(this)" onmouseout="mOut(this)" >
			  <div class="panel-heading"><b><h4>BUG OVERFLOW</b></h4></div>
		  </div>
		  <br>
		  
    </div>
</div>
</div>


 
<div class="container">
<div class="row">
	<div class="col-sm-12">
	<br>
	<br>	
	<div class="col-sm-8">
	  <div class="panel panel-danger" onmouseover="mOut(this)" onmouseout="mOver(this)">
	    <div class="panel-heading"><h4>CREATE NEW POST</h4></div>
		<div class="panel-body">
				<form method="post" action="Register"> 
				<div class="form-group">
				  <label for="name">New Post Title:</label>
				  <input type="text" class="form-control" name="title" id="name" placeholder="Enter title" >
				</div>
				<div class="form-group">
				  <label for="email">Language tag:</label>
				  <input type="text" class="form-control" name="lang" id="email" placeholder="Enter language" >
				</div>
				<div class="form-group">
				  <label for="pwd">Content:</label>
				  <input type="text" class="form-control" name="content" id="pwd" placeholder="Enter your question" pattern=".{8,}" title="length of password has to be atleast 8">
				</div>
				
				<button type="submit" class="btn btn-danger">Submit</button>
			  </form>
	  </div>
	  </div>
	</div>
</div>
</div>
</body>
</html>
    