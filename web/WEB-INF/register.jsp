<%-- 
    Document   : register
    Created on : Oct 4, 2018, 12:07:12 PM
    Author     : 707114
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="list">
        Username: <input type="text" name="username" value="user" >
        
<!--        <a href="<c:url value='/list' />"> Register Name </a>-->
        <input type="submit" value="action" name="register">
    ${error}
        </form>
    </body>
</html>
