<%-- 
    Document   : login
    Created on : Jun 4, 2022, 11:34:31 AM
    Author     : LENOVO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <h1>login</h1>
  <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:8080/SWP39_LostAndFound/login-google&response_type=code
    &client_id=287706363103-nelsjcm2sdr3ruldha94fink89tk87tg.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
   <%String err = (String) request.getAttribute("errormessage"); %>
   <br/>
   <%    if(err != null){ %> <font color="red" > <%= err %></font><% } %>
</body>
</html>
