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
        <a href="?action=logout">Log Out</a>
        <h2>List</h2>
        <br>
        <form method="post">
            Add item: <input type="text" name="item">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>
        <form method="post">
            <ul>
                <c:forEach var="item" items="${items}">
                    <input checked type="radio" name="radio" value="${item}"> ${item} <br>
                </c:forEach>
            </ul>
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete">
        </form> 
    </body>
</html>
