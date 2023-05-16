<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="box"></div>
<button onclick="idCheck()">아이디 있니?</button>
</body>
<script>
	function idCheck(){
		$.ajax("http://localhost:8080/blog/ajax").done(function(data){
			alert(data);		
		});
	}
</script>

</html>