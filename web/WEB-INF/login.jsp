<%-- 
    Document   : login
    Created on : 25-Feb-2022, 7:40:06 PM
    Author     : Jaren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyLogin</title>
    </head>
    <body>
        
        <h1>Login</h1>
        
        <div>
            <form action="login" method="post">
                Username: <input type="text" name="username" value="${username}"><br>
                Password: <input type="text" name="password" value="${password}"><br>
                
                <input type="submit" name="login" value="Login">
            </form>
        </div>
            
        <div>
            <c:if test="${(loggedOut == '' && loggedOut != null) || (invalid == '' && invalid != null)}">${message}</c:if>
        </div>
        
    </body>
</html>
