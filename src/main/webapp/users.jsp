<%@page import="Model.UserDB"%>
<%@ page pageEncoding="UTF-8"%>
<%
	session = request.getSession();
%>
<html>
<head>
	<meta charset="utf-8">
	
	<title>
		Web Application
	</title>
	
	<link rel="stylesheet" href="resources/css/main.css" />
</head>
<body>
	<header class="header-bar">
	<% if(session.getAttribute("user")!=null){ %>
		<a class="btn" href="logout">Изход</a>
		<a class="btn" href="index.jsp">Моят Профил</a>
	<% } else { %>
		<a class="btn" href="login">Влез</a>
		<a class="btn" href="register">Регистриране</a>
		<% } %>
		<a class="btn" href="users">Потребители</a>
	</header>
	
	<div class="main">
		<div class="shell">
		
		<h1>All Users</h1>
    	<table border="1">
        <tr>
            <th>Потребител:</th>
            <th>Работа</th>
            <th>Информация</th>
        </tr>
	        <%
	        if(session.getAttribute("users")!=null){
	        	java.util.List<Model.User> users = ((Model.UserDB)session.getAttribute("users")).getUsers();
			    for(Model.User u : users){
			        out.print("<tr><td><a href='user?id="+u.getID()+"'>"+u.getName()+"</td>");
			        out.print("<td>"+u.getJob()+"</td> <td>"+u.getDescription()+"</td></tr>");
			    }
	        }
			%>
    	</table> 

		</div>
	</div>
	
	<footer class="footer-bar">
	</footer>
</body>
</html>
