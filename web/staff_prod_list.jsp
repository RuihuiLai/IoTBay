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
    <span id="links"> <a href="MainPageServlet"> main</a> | <a href="product_upload.jsp"> new product</a></span>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/staff_prod_list.css">
    <title>STAFF VIEW</title>
</head>
<body>
    <h1>Product list</h1>
    <%
        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("list");
        ArrayList<String> listCategory = (ArrayList<String>) request.getAttribute("cate");
        String filter = (String) request.getAttribute("filter");
        String cat = (String) request.getAttribute("cat");
        int length = products.size();
    %>
    item count: <%=length%>
    <form action="ProductListServlet" method="post" autocomplete="off">
        <input type="text" name="filter" value="<%=(filter != null ? filter : "")%>" placeholder="item name">
        <input list="categories" name="category" value="<%=(cat != null ? cat : "")%>" placeholder="category">
        <datalist id = "categories">
            <option value="ALL">
                <%for (String category : listCategory) {%>
            <option value="<%=category%>">
                <%}%>
        </datalist>
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
                <td><a href="ProductEditServlet?ID=<%=product.getProductID()%>">edit</a></td>
                <td><a href="ProductDeleteServlet?ID=<%=product.getProductID()%>" onclick="">delete</a></td>
            </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
