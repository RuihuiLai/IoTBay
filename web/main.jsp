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
        <span id="links"><a href="ProductListServlet"> prod_edit</a> | <a href="logout.jsp"> Logout</a></span>
        <h1>Main page</h1>
        <%
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBProductManager db = new DBProductManager(conn);
            String filter = request.getParameter("filter");
            if(filter==null){
                filter = "";
            }
            ArrayList<Product> products = db.searchProducts(filter);
            
        %>
        <div class="mainTable">
            <form action="main.jsp" method="get">
                <input type="text" name="filter" value="<%=(filter != null ? filter : "")%>">
                <input type="submit" id="submit">
            </form>
            <table>
                <%
                    int i = 0;
                    for (Product product : products) {

                        if (i % 5 == 0) {
                %>
                <tr></tr>
                <%
                    }
                    i++;
                %>
                <td>
                    <a href="product.jsp?ID=<%=product.getProductID()%>">
                        <center><img src="productPictures/<%=product.getProductID()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="128" width="128"><br>
                            <%=product.getName()%><br>
                            $ <%=product.getPrice()%><br>
                            Stock <%=product.getStock()%><br>
                        </center>
                    </a>
                </td>
                <%}%>
            </table>
        </div>
    </body>
</html>
