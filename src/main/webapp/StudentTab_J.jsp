
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
  <script src="https://kit.fontawesome.com/e2991dfebd.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet"> 
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

<div class="filter"><input id="filterid" type="text" name="search" placeholder="Search ..."> 	<i class="fa-solid fa-magnifying-glass"></i></div>

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
	
	
	<script>
	
	<!-- Change Rows to input by clicking Update button -->

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
	}
	
	<!-- filter/search function -->
	
	var filtervalue = document.getElementById("filterid");
	
	
	filtervalue.onkeyup = function(){
		
		var value = this.value.toLowerCase();
		var table = document.getElementsByTagName("table")[0];
		var rows = document.getElementsByTagName("tr");
		
		for(var i = 1 ; i < rows.length ; i++){
				
			var LNI = rows[i].getElementsByTagName("td")[1].querySelector("input");
			var FNI = rows[i].getElementsByTagName("td")[2].querySelector("input");
			var CNEI = rows[i].getElementsByTagName("td")[4].querySelector("input");
			
			if(LNI || FNI || CNEI){
				var LN = LNI.value;
				var FN = FNI.value;
				var CNE = CNEI.value;
				
				if(LN.toLowerCase().indexOf(value) > -1 || FN.toLowerCase().indexOf(value) > -1 || CNE.toLowerCase().indexOf(value) > -1){
			
					rows[i].style.display ="";				
				}else{
					rows[i].style.display ="none";				

				}
			}
			}
		
		
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