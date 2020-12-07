
var elements = document.getElementsByClassName("header");

for (var i = 0; i < elements.length; i++) {
    elements[i].addEventListener('mouseover', showbug);
	elements[i].addEventListener('mouseout', hidebug);
}

document.getElementById("home_tab").addEventListener("click", displayHome);
document.getElementById("profile_tab").addEventListener("click", displayProfile);


function showbug() {
	document.getElementById("bug").style.visibility="visible";
}

function hidebug() {
	document.getElementById("bug").style.visibility="hidden";
}

function displayHome() {
  document.getElementById("home_page").style.display="block";
 document.getElementById("profile_page").style.display="none";
}

function displayProfile() {
 document.getElementById("profile_page").style.display="block"; 
 document.getElementById("home_page").style.display="none";
}

