<%-- 
    Document   : home
    Created on : 26-Feb-2022, 9:37:47 PM
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
        
        <h1>Home Page</h1>
        <h3>Hello ${user}.</h3>

        <div>
            <a href="login?logout">Log out</a>
        </div>
        
    </body>
</html>
