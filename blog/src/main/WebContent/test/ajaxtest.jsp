<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="box"></div>
<button onclick="idCheck()">아이디 있니?</button>
</body>
<script>
	function idCheck(){
		  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
				 if(this.readyState ==4 && this.status == 200) {
				 	 	if(this.responseText === 'ok') {
				 	 		var box = document.querySelector("#box");
				 	 		box.innerHTML = "다른 아이디를 사용해야 겠군.";
				 	 	} else {
				 	 		alert("해당 아이디를 사용할 수 있습니다.");
				 	 	}
				 }
			  };
		  xhttp.open("GET", "http://localhost:8080/blog/ajax", true);
		  xhttp.send();
	}
</script>

</html>