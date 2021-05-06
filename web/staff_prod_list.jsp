<%-- 
    Document   : staff_prod_list
    Created on : May 2, 2021, 6:27:13 PM
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
        <span id="links"> <a href="main.jsp"> main</a> | <a href="product_upload.jsp"> new product</a></span>
        <link rel="stylesheet" href="css/staff_prod_list.css">
        <title>STAFF VIEW</title>
    </head>
    <body>
        <h1>Product list</h1>
        <%
            response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server  
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBProductManager db = new DBProductManager(conn);
            String filt = "";
            if (request.getParameter("filter") != null) {
                filt = request.getParameter("filter");
            }
            ArrayList<Product> products = db.searchProducts(filt);
            int length = products.size();
        %>
    item count: <%=length%>
        <form action="staff_prod_list.jsp" method="post">
            <input type="text" name="filter">
            <input type="submit" id="submit" name="submit" value="search">
        </form>
        <div class="mainTable">
        <table>
            <th>Number</th><th>Picture</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th><th>Edit</th><th>Delete</th>
                <%
                    for (Product product : products) {
                %>
            <tr>
                <td><%=product.getProductID()%></td>
                <td><img src="productPictures/<%=product.getProductID()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="64" width="64"></td>
                <td><%=product.getName()%></td>
                <td><%=product.getCategory()%></td>
                <td><%=product.getPrice()%></td>
                <td><%=product.getStock()%></td>
                <td><a href="product_edit.jsp?ID=<%=product.getProductID()%>">edit</a></td>
                <td><a href="" onclick="">delete</a></td>
            </tr>
                <%}%>
        </table>
        </div>
    </body>
</html>
