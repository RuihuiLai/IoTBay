<%-- 
    Document   : logout
    Created on : Mar 19, 2021, 12:48:15 PM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/logout.css">
        <title>logout Page</title>
    </head>
    <body>
        <h1>You have successfully logged out!</h1>
        <p><a href="index.jsp"> go back to landing page</p>
        <% session.invalidate();%>
    </body>
</html>
