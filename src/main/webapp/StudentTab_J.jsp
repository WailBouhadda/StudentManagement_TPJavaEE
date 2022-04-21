
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

<jsp:include page="NavBar_J.jsp"></jsp:include>

<%if(st != null){ %>

<form action="StudentTab_S" method="get">

<div class="delete">
 
  <input type="number" name="age" placeholder="Students age..." required>
  
  <input type="submit" name="delete" value="Delete">
  
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
HttpSession ss = request.getSession();
	
	for(int i = 0 ; i < st.size() ; i++) {	
	
%>



	<% 	s = st.get(i);%>
	<tr class="<%=s.getId()%>"> 
	<form action="StudentTab_S" method="get">
	
	<td><input class="<%=s.getId()%>" type="text" name="id" value="<%=s.getId()%>" readonly></td>
	<td><input class="<%=s.getId()%>" type="text" name="lastname" value="<%=s.getLastName()%>" disabled></td>
	<td><input class="<%=s.getId()%>" type="text" name="firstname" value="<%=s.getFirstName()%>" disabled></td> 
	<td><input class="<%=s.getId()%>" type="text" name="age" value="<%=s.getAge()%>" disabled></td> 
	<td><input class="<%=s.getId()%>" type="text" name="cne" value="<%=s.getCne()%>" disabled></td>
	<td class="action"><input  class="<%=s.getId()%>" type="submit" name="action" value="delete"><input class="<%=s.getId()%>" type="button" name="action" value="update"></td>
	</form>
	
	
	<!-- Change Rows to input by clicking Update button -->
	<script>
	var input = document.querySelectorAll("input");
	var but =  document.getElementsByName("action");
	var row = document.querySelectorAll("tr");
	var delet = "";
	var del = "";
	var Srow = "";
	var update = "";
	for(var i = 0 ; i < but.length ; i++){
		if(but[i].value === "update"){
			update = but[i];	
		}
		
	}
	
	update.onclick = function(){
		
		
		for(var i = 0 ; i < row.length ; i++){
			if(row[i].className === this.className){	
				Srow = row[i];
				
				Srow.style = "background-color: #9e9e9e21;"
			}
		}
		
		for(var i = 0 ; i < input.length ; i++){
		if(input[i].className === this.className){	
			
			if(input[i].disabled){
				input[i].disabled = false;
			}
			
			if(input[i].value === "delete"){
				delet = input[i];
				
				delet.value ="cancel";
			}
	
		
		}
		
		this.onclick = function(){
			
			Srow.style = "background-color: white;"
			this.type="submit";
			delet.value = "delete";
		}
		
		
		
		
		
	}
		console.log(delet.className);
	
	}
	
	</script>
	</tr>
	
<%}%>
<%}else{%>
	<jsp:forward page="StudentTab_S"></jsp:forward>	
<%}%>

</tbody>
</table>

</body>
</html>