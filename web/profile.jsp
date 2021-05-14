<%-- 
    Document   : profile
    Created on : Apr 2, 2021, 8:03:24 PM
    Author     : Reyvaldo
--%>

<%@page import="iotbay.model.Staff"%>
<%@page import="iotbay.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/layout.css">
        <title>Profile Page</title>
    </head>
    <body>
        <h1>Profile</h1>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            Staff staff = (Staff) session.getAttribute("staff");
            String[] address = customer.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }
        %>
        <span id="links"> <a href="main.jsp"> Main</a> | <a href="EditServlet?email='<%= customer.geteMail()%>'
                             &password='<%=customer.getPassword()%>'
                             &first_name='<%=customer.getFirstName()%>'
                             &last_name='<%=customer.getLastName()%>'
                             &gender='<%=customer.getGender()%>'
                             &address='<%=customer.getAddress()%>'
                             &phone_number='<%=customer.getPhoneNumber()%>'"> Edit</a> | <a href="logout.jsp"> Logout</a></span>
        <div class="mainTable">
        <table>
            <tr><th>Name</th> <td>${customer.firstName} ${customer.lastName}</td></tr>
            <tr><th>Email</th> <td>${customer.eMail}</td></tr>
            <tr><th>Password</th> <td>${customer.password}</td></tr>
            <tr><th>Gender</th> <td>${customer.gender}</td></tr>
            <tr><th>Address</th> <td><table class ="address">
                        <tr><th>street number</th> <td><%=address[0]%></td></tr>
                        <tr><th>Street name</th> <td><%=address[1]%></td></tr>
                        <tr><th>Suburb</th> <td><%=address[2]%></td></tr>
                        <tr><th>State</th> <td><%=address[3]%></td></tr>
                        <tr><th>Zip code</th> <td><%=address[4]%></td></tr>
                    </table></td></tr>
            <tr><th>Phone Number</th> <td>${customer.phoneNumber}</td></tr>
        </table>
        </div>
    </body>
</html>
