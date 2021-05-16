<%-- 
    Document   : ViewCustomerlist
    Created on : 2021年5月10日, 下午2:54:33
    Author     : 13725
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="iotbay.model.dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/Main.css">
        <link rel="stylesheet" href="css/form.css">
        <title>View Customer list</title>
    </head>
    <body>
        <span id="links"> <a href="customer_upload.jsp"> upload</a></span> | <a href="logout.jsp"> Logout</a> <a href="ViewCustomerlist.jsp"> Viewcustomerlist </a></span>
        <h1> Main page</h1>
        <%
            DBConnector connector = new DBConnector();
            Connection conn = connector.connection();
            CustomerManager db = new CustomerManager(conn);
            ArrayList<Customer> customers = db.fetchCustomers();
            %>
            
            <table>
                <%for (Customer customer:customers)>{%>
                <td>
                    <a href="view">
                }
    </body>
</html>
