<%-- 
    Document   : form.jsp
    Created on : Jun 4, 2022, 9:13:59 PM
    Author     : LENOVO
--%>

<%-- 
    Document   : bookform
    Created on : Mar 1, 2022, 11:21:05 PM
    Author     : Masterkien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPTU Lost And Found</title>
    </head>
    <body>
        <h3>
            Article Form
        </h3> <br>

        <c:if test="${!postURL.isEmpty()}"><p>Your image: </p><br/> 
                    <div style="width: 300px"><img src="images/${postURL}" width="100%"></div></c:if>
        <form <c:if test="${action eq 'create'}"> enctype='multipart/form-data'</c:if> method="POST">
            <table>
                <tr>
                            <td>Content</td>
                            <td>: <input type="text" name="txtContent" value="${content}"<font color="red">${contentError}</font></td>
			</tr>      
                    
                <tr>
                <td>Article Type</td>
                    <td>:
                         <select name="txtArticleType" >
                             <c:forEach var="dt" items="${ListArticleType}" >                                  
                                 <option <c:if test="${dt.typeID eq postTypeId}">selected </c:if>
                                 value="${dt.typeID}"> <c:out value="${dt.typeName}"/> </option>
                             </c:forEach>
                         </select> 
                    </td>            
                </tr>
                <tr>
                <td>Item Type</td>
                    <td>:
                         <select name="txtItem" >
                             <c:forEach var="dt" items="${ListItemType}" >                                  
                                <option <c:if test="${ dt.itemID eq itemId}">selected </c:if>
                                value="${dt.itemID}"><c:out value="${dt.itemName}"/></option>
                             </c:forEach>
                         </select> 
                    </td>            
                </tr>
                <c:if test="${action eq 'create'}">         
                <tr>
                    <td>Post image </td>
                    <td>: <input type="file" name="photo"/><font color="red"> ${errorURL} </font></td>               
                </tr>
                </c:if>
                 <tr>
                    <td colspan="2">                   
                    <c:if test="${action eq 'create'}">
                    <input type="hidden" name="articleURL" value="${postURL}">
                    <button formaction="CreateServlet" type="submit">Create</button></c:if>
                    <c:if test="${action eq 'update'}">
                    <input type="hidden" name="articleURL" value="${postURL}">
                    <input type="hidden" name="idUpdate" value="${idUpdate}">
                    <button formaction="UpdateServlet" type="submit">Update</button></c:if>
                    </td>
                </tr>
            </table>         
        </form>
                        <a href="ListPostServlet">Home</a>
       
    </body>
</html>

