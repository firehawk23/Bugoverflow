
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Contact us</title>
<script>
    function mouseOver() {
        document.getElementById("backd").style.backgroundColor= "red";
    }

    function mouseOut() {
        document.getElementById("backd").style.backgroundColor= "yellow";
    }


    function verify()
    {
        var name=document.forms["ContactForm"]["Name"];
        var email=document.forms["ContactForm"]["EMail"];
        var mobile=document.forms["ContactForm"]["Mobile"];
        var what=document.forms["ContactForm"]["Subject"];
        var comment=document.getElementById("Comment");

        if (name.value == "")
        {
            window.alert("Please enter your name.");
            name.focus();
            return false;
        }
        else if(/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(name.value)==false){
            window.alert("Please enter only alphabets.");
            name.focus();
            return false;
        }

        if (email.value == "")
        {
            window.alert("Please enter a e-mail address.");
            email.focus();
            return false;
        }
        else if(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email.value)==false){
            window.alert("Please enter a valid e-mail address.");
            email.focus();
            return false;
        }

        if (mobile.value == "")
        {
            window.alert("Please enter your mobile number.");
            phone.focus();
            return false;
        }
        else if(/^\d+$/.test(mobile.value)==false){
            window.alert("Please enter only numbers in mobile");
            phone.focus();
            return false;
        }
        else if(/^\d{10}$/.test(mobile.value)==false){
            window.alert("Mobile number should be 10 digits");
            phone.focus();
            return false;
        }

        if (what.selectedIndex < 1)
        {
            alert("Please select a query.");
            what.focus();
            return false;
        }

        if (comment.value == "")
        {
            window.alert("Please enter your comments.");
            comment.focus();
            return false;
        }
        if(comment.value.length>500){
            window.alert("Character Limit is 500");
            comment.focus();
            return false;
        }
        window.alert("Submission Successful");
        return true;
    }

    function yesnoCheck(that) {
        if (that.value == "Other") {
            document.getElementById("ifYes").style.display = "block";
        } else {
            document.getElementById("ifYes").style.display = "none";
        }
    }

</script>
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
        height: 100%;
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
    
    <header>
        <div class="logo"><span><img src="logo.png" width="35px" height="40px"></span></div>
        <section class="header-content">

	<button style="margin:auto;display:block;" onclick="window.location.href='home.jsp'">Home</button>

            <div id="one" onmouseover="mouseOver()" onmouseout="mouseOut()">
                <center>
                    <h1 align=center>Contact Us</h1>
                </center>
                <br>
                <form action="ContactServlet" name="ContactForm" onsubmit="return verify()" method="post">

                    <p>Name: <input type="text" size=65 name="Name"> </p><br>
                    <p>E-mail: <input type="text" size=65 name="EMail"> </p><br>
                    <p>Mobile: <input type="text" size=65 name="Mobile"> </p><br>

                    <p>SELECT QUERY
                        <select type="text" value="" name="Subject" onchange="yesnoCheck(this);">
                            <option default>select</option>
                            <option>Bug Bounty</option>
                            <option>Report Abuse</option>
                            <option>Careers</option>
                            <option>Advertising</option>
                            <option>Sponsorship</option>
                            <option value="Other">Other</option>
                        </select></p>
                    <div id="ifYes" style="display: none;">
                        <label for="car">If selected other, please mention</label> <input type="text" id="car" name="car" /><br />
                    </div>
                    <br>
                    <p>Comments: <textarea cols="55" rows="5" name="Comment" id="Comment"></textarea></p>
                    <p><input type="submit" value="send" name="Submit" class="button">
                        <input type="reset" value="Reset" name="Reset" class="button">
                    </p>
                </form>
                <br>
                <h2> To Meet in Person </h2>
                <p> click left side of image for coimbatore address</p>
                <p> click right side of image for chennai address</p>
                <br>
                <img src="https://miro.medium.com/max/4064/1*qYUvh-EtES8dtgKiBRiLsA.png" alt="map" width="400" height="200" usemap="#google">
                <map name="google">
                    <area shape="rect" coords="0,0,200,199" href="https://www.google.com/maps/place/Coimbatore,+Tamil+Nadu/@11.0117016,76.897195,12z/data=!3m1!4b1!4m5!3m4!1s0x3ba859af2f971cb5:0x2fc1c81e183ed282!8m2!3d11.0168445!4d76.9558321?hl=en" alt="coimbatore">
                    <area shape="rect" coords="201,0,399,199" href="https://www.google.com/maps/place/Chennai,+Tamil+Nadu/@13.0474878,80.0689276,11z/data=!3m1!4b1!4m5!3m4!1s0x3a5265ea4f7d3361:0x6e61a70b6863d433!8m2!3d13.0826802!4d80.2707184?hl=en" alt="chennai">
                </map>
                <br><br>
            </div>


        </section>
    </header>
</div>
</body>
</html>
