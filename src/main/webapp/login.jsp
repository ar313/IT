<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<title>Влизане в профил</title>

	<link rel="stylesheet" href="resources/css/main.css" />
</head>
</head>
<body>

	<header class="header-bar">
		<a class="btn" href="login">Влез</a>
		<a class="btn" href="register">Регистриране</a>
		<a class="btn" href="users">Потребители</a>
	</header>

<form class="form" action="login" method="POST">
		<h2>
			Влезте в системата	
		</h2>

		<div class="form-group">
			<div class="form-field">
				<label for="username">Потребителско име: </label>
				
				<input placeholder="Въведете имейл адрес" type="email" required="true" name="username" id="username">		
			</div>

			<div class="form-field">
				<label for="password">Парола: </label>
				
				<input placeholder="Въведете парола поне с 8 символа" type="password" required="true" minlength="8" name="password" id="password">		
			</div>

			<div class="form-button">
				<input class="btn" value="Вход" type="submit" name="submit">
			</div>
		</div>
	</form>

</body>
</html>