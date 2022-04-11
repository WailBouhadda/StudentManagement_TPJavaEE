
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="myPackage.Student"%>
  <%
  ArrayList<myPackage.Student> st = (ArrayList<Student>)request.getAttribute("StuArrList");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style.css">
<title>Students Table</title>
</head>
<body>

<form action="StudentTab_S" method="get">

<div class="delete">
 
  <input type="number" name="age" placeholder="Students age..." required>
  
  <button type="submit">Delete</button>
  
  <% if(request.getAttribute("RowsDeleted") == null){ %>
 	 <span>0</span>
  <%}else{ %>
	 <span><%=request.getAttribute("RowsDeleted") %></span>
  <%}%>
  
</div>

</form>

<table class="table">
<thead>

<tr>
<th>ID</th>
<th>Last Name</th>
<th>First Name</th>
<th>Age</th>
<th>CNE</th>
</tr>

</thead>

<tbody>

<%
Student s = new Student();
for(int i = 0 ; i < st.size() ; i++) {
%>
	<tr> 
	<% 	s = st.get(i);%>
	<td><%= s.getId()%></td>
	<td><%=s.getLastName()%></td>
	<td><%=s.getFirstName()%></td> 
	<td><%=s.getAge()%></td> 
	<td><%=s.getCne()%></td>
	</tr>
<%}%>

</tbody>
</table>

</body>
</html>