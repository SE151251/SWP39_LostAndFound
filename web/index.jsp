<%-- 
    Document   : index
    Created on : Jun 4, 2022, 11:34:38 AM
    Author     : LENOVO
--%>

<%@page import="fu.entities.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<title>index</title>
</head>
<body>
  <h1>Index</h1>
  <%
    Member m = (Member) session.getAttribute("userdata");  
    out.print("Id: " + m.getMemberID());  
    out.print("<br/>Name: " + m.getMemberName());
    out.print("<br/>Email: " + m.getMemberEmail());
    out.print("<br/>Campus: " + m.getCampus().getCampusName());
  %>
  <br/>
  <a href="LogoutServlet">Log out</a>
  <br>
  <p>img</p>
  <br>
  <img src="<%=m.getPicture()%>" alt="">
  <a href="CreateFormServlet">ADD NEW Article</a>    
  <a href="ListPostServlet">Home</a>   
</body>
</html>

