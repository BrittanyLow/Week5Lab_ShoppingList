<%-- 
    Document   : shoppingList
    Created on : Oct 4, 2018, 12:07:22 PM
    Author     : 707114
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shopping Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${user} 
        <a href="list?action=logout" > Logout</a>
        <br>
        <h2> List </h2>
        <br>
        
        <form method="post" action="list"> 
        Add items: <input type="text" name="add">
                   <input type="submit" value="Add" name="action">
        
                   <%--for every add item make to array list on a radio--%>
         
                   <c:forEach items="${listitem}" var="item" varStatus="status">
                        <input type="radio" value="${status.add}" name="index">
                        <c:out value="${item}"></c:out>
                   </c:forEach>
        
            <%--delete from the array --%>
            <input type="submit" value="delete" name="delete">
       </form> 
    </body>
</html>
