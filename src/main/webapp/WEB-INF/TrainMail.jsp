<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>javamail.com</title>
</head>
<body>

<h1>Welcome to Java Mail </h1>

<form action = "readMailMessage" method = "post">
<h3 style = "color :red">${MailMessage}</h3>

<label>TO</label>
<input type = "email" name = "toEmail">
<label>Subject</label>
<input type = "text" name = "subject">
<label>BodyText</label>
<input type = "text" name = "bodyText">

<input type = "submit" value = "send">


</form>


</body>
</html>