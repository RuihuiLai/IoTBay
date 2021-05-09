<%-- 
    Document   : product
    Created on : Apr 30, 2021, 8:03:51 PM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.Product"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <span id="links"><a href="MainPageServlet"> main</a> | <a href="logout.jsp"> Logout</a></span>
        <%
            Product prod = (Product) request.getAttribute("product");
        %>
        <title><%=prod.getName()%></title>
    </head>
    <body>
        <h1><%=prod.getName()%></h1>
        <img src="productPictures/<%=prod.getProductID()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="256" width="256"><br>
        categories: <%=prod.getCategory()%><br>
        Price: $ <%=prod.getPrice()%><br>
        Stock <%=prod.getStock()%><br>
        Description <%=prod.getDescription()%><br>
    </body>
</html>
