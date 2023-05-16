<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

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
		fetch("http://localhost:8080/blog/ajax").then(function(data){
			return data.text();		
		}).then(function(data){
			alert(data);
		});
	}
</script>

</html>