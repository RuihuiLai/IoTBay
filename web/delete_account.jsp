<%@page import="iotbay.model.Customer"%>
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
        <h1>You have successfully deleted your account!</h1>
        <p><a href="index.jsp"> go back to landing page</p>
        <% session.invalidate();%>
    </body>
</html>
