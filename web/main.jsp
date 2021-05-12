<%-- 
    Document   : main
    Created on : Mar 20, 2021, 5:12:58 PM
    Author     : Reyvaldo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/layout.css">
        <title>Main Page</title>
    </head>
    <body>
        <span id="links"> <a href="product_upload.jsp"> upload</a> | <a href="logout.jsp"> Logout</a> <a href="ViewAllOrderServlet"> View All</a> <a href="edit_order.jsp"> Edit Order</span>
        <h1>Main page</h1>
        <%
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBProductManager db = new DBProductManager(conn);
            ArrayList<Product> products = db.fetchProducts();
            int length = products.size();
        %>
        <div class="mainTable">

            <table>
                <%for (Product product : products) {%>
                <td>
                    <a href="product.jsp?value=<%=product.getProductID()%>">
                        <center><img src="productPictures/<%=product.getName()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="128" width="128"><br>
                        <%=product.getName()%><br>
                        $ <%=product.getPrice()%><br>
                        </center>
                    </a>
                </td>
        
            <%}%>
            </table>
        </div>
    </body>
</html>
