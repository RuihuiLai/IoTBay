<%-- 
    Document   : pwelcome
    Created on : Mar 19, 2021, 12:40:08 PM
    Author     : Reyvaldo
--%>
<%@page import="java.util.Date"%>
<%@page import="iotbay.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/welcome.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="welcome">
            <h1> Welcome!</h1>
            <p>Welcome to the IoTBay Website!</p><br>
            <h6>Please <a href="main.jsp"> click here</a> to be moved to main page</h6>
        </div>
        <%
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String streetNumber = request.getParameter("streetNumber");
            String streetName = request.getParameter("streetName");
            String suburb = request.getParameter("suburb");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String phoneNumber = request.getParameter("phone_number");
            String address = streetNumber + "§" + streetName + "§" + suburb + "§" + state + "§" + zipcode;
            Date date = new Date();
            Customer customer = new Customer(1, firstName, lastName, email, password, gender, address,date, phoneNumber, false);
            session.setAttribute("customer", customer);
        %>
    </body>
</html>
