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
		<a class="btn" href="logout">Изход</a>
		<a class="btn" href="users">Потребители</a>
	</header>
	
	<div class="main">
		<div class="shell">
		<%	if(session.getAttribute("user")!=null && session.getAttribute("message")==null){ %>
			<h1>Welcome To Tu-Varna</h1>
			<% session.setAttribute("message","true"); } %>
			<div class="profile">
				<div class="profile-image">
					<img src="resources/images/male.svg" />
				</div>
				
				<div class="profile-description">
					<h2>
						Профилна Информация <span><a href="editAccount.jsp">Edit Account</a></span>
					</h2>
					
					
					<jsp:useBean id = "user" class = "Model.User" scope="session">
						<jsp:setProperty name = "user" property = "name" value = '<%=((Model.User)session.getAttribute("user")).getName()%>'/>
						<jsp:setProperty name = "user" property = "job" value = '<%=((Model.User)session.getAttribute("user")).getJob()%>'/>
						<jsp:setProperty name = "user" property = "description" value = '<%=((Model.User)session.getAttribute("user")).getDescription()%>'/>
						<jsp:setProperty name = "user" property = "email" value = '<%=((Model.User)session.getAttribute("user")).getEmail()%>'/>
					</jsp:useBean> 
					
					<p>Име: <span> <jsp:getProperty name = "user" property = "name"/> </span> </p>
					<p>Работа: <span><jsp:getProperty name = "user" property = "job"/></span> </p>
					<p>Описание: <span><jsp:getProperty name = "user" property = "description"/></span> </p>
				</div>
			</div>
			
			<h2>
				Умения
			</h2>
			
			<div class="profile-skills">
				<div class="skills-pro">
					<h3>Професионални</h3>
					
					<div class="skills-rating">
						<h5>
							Java
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
					
					<div class="skills-rating">
						<h5>
							HTML
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
					
					<div class="skills-rating">
						<h5>
							CSS
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
					
					<div class="skills-rating">
						<h5>
							JavaScript
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
				</div>
				
				<div class="skills-pro">
					<h3>Личностни</h3>
					
					<div class="skills-rating">
						<h5>
							Комуникативност
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
					
					<div class="skills-rating">
						<h5>
							Екипна Работа
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
					
					<div class="skills-rating">
						<h5>
							Креативност
						</h5>
						
						<div class="skills-bar">
							<div class="skills-bar_top"></div>
						</div>
					</div>
				</div>
			</div>
			
			<h2>
				Контакти
			</h2>
			
			<div class="profile-contacts">
				<div class="contacts">
					<h5>
						Имейл
					</h5>
					
					<a href="email:ivan@tu-varna.bg">
						ivan@tu-varna.bg
					</a>
				</div>
				
				<div class="contacts">
					<h5>
						Град
					</h5>
					
					<a>
						Варна
					</a>
				</div>
				
				<div class="contacts">
					<h5>
						Телефон
					</h5>
					
					<a href="tel:09876543219">
						09876543219
					</a>
				</div>
				
				<div class="contacts">
					<h5>
						Улица
					</h5>
					
					<a>
						Студентска 1
					</a>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="footer-bar">
	</footer>
</body>
</html>
