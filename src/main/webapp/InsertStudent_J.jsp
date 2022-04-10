<%@page import="java.sql.*"%>
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
<title>Test Form</title>
</head>
<body>


<form action="InsertStudent_S" method="get" class="infos">

<h1>Test Form</h1>
 <input type="text" name="lname" placeholder="Last Name" required>
 <input type="text" name="fname" placeholder="First Name" required>
 <input type="text" name="age" placeholder="Age" required>
  <input type="text" name="cne" placeholder="CNE" required>
 
 
 
 <input type="submit" placeholder="Add">

</form>


</body>
</html>