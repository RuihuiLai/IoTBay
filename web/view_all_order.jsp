<%-- 
    Document   : view_order
    Created on : 07-May-2021, 09:14:56
    Author     : joshcelik-alvis
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.Order"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/layout.css">
        <title>Order View All</title>
    </head>
    <body>
        <span id="links"> <a href="MainPageServlet"> main</a> | <a href="logout.jsp"> Logout</a> | <a href="ViewAllOrderServlet"> View All Orders</a></span>
        <h1>Main page</h1>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("list");
        %>
        <div class="mainTable">
            <form action="ViewAllOrderServlet" method="post" autocomplete="off">
                <input type="number" name="filter" placeholder="Order ID">
                <input type="submit" id="submit" name="submit" value="search">
            </form>
            <table>
                <%for (Order order : orders) {%>
                <td>
                    <a href="ViewParticularOrderServlet?ID=<%=order.getOrderID()%>">
                        Status: <%=order.getStatus()%><br>
                        Order Time: <%=order.getOrderTime()%><br>
                        Price: $ <%=order.getTotalPrice()%><br>
                        Shipment ID: <%=order.getShipmentID()%><br>
                        User ID: <%=order.getUserID()%><br>
                        </center>
                    </a>
                </td>

                <%}%>
            </table>
        </div>
    </body>
</html>

