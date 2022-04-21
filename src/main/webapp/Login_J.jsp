<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="Style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;600;800&family=Fredoka:wght@300;400;500;600&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">

<title>Login Form</title>
</head>
<body>


<form action="Login_S" method="post" class="LoginForm">

<h1>Login</h1>

<% String LoFai = (String)request.getAttribute("Failed");

if(LoFai != null){
	if(LoFai.equals("true")){
	
%>
<p style="color:red;">Username or Password Incorrect, Please try again!</p>
	<% 
}}
%>

<input type="text" name="username" placeholder="Username ..." required/>
<input type="password" name="password" placeholder="Password ..."  required/>

<input type="submit" name="Login" value="Login"/>


</form>

</body>
</html>