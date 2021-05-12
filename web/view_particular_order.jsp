<%-- 
    Document   : view_order
    Created on : 07-May-2021, 09:15:39
    Author     : joshcelik-alvis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.Order"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            Order order = (Order) request.getAttribute("order");
        %>
        <title>Order ID <%=order.getOrderID()%></title>
    </head>
    <body>
        <span id="links"> <a href="DeleteOrderSevlet?ORDERID=<%=order.getOrderID()%>"> Delete Order</a></span>
        <h1>Order ID: <%=order.getOrderID()%></h1>
        Status: <%=order.getStatus()%><br>
        Order Time: <%=order.getOrderTime()%><br>
        Price: $ <%=order.getTotalPrice()%><br>
        Shipment ID: <%=order.getShipmentID()%><br>
        User ID: <%=order.getUserID()%><br>
    </body>
</html>