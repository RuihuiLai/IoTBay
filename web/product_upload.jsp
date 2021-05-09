<%-- 
    Document   : product_upload
    Created on : May 1, 2021, 11:08:16 AM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
    <span id="links"> <a href="ProductListServlet"> staff item view</a></span>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <%
        String name = (String) request.getAttribute("name");
        String cat = (String) request.getAttribute("cat");
        String desc = (String) request.getAttribute("desc");
        Double price = (Double) request.getAttribute("price");
        String stock = (String) request.getAttribute("stock");
        String priceErr = (String) request.getAttribute("priceErr");
        String stockErr = (String) request.getAttribute("stockErr");
        String nameErr = (String) request.getAttribute("nameErr");
        String descErr = (String) request.getAttribute("descErr");
        String catErr = (String) request.getAttribute("catErr");
    %>
    <form action="ProductCreateServlet" method="POST" enctype="multipart/form-data" autocomplete="off">
        <table>
            <tr><td>Item name</td><td><input type="text" name="name" value="<%=(name != null ? name : "")%>" required></td><td><%=(nameErr != null ? nameErr : "")%></td></tr>
            <tr><td>Category</td><td><input type="text" name="category" placeholder="category1/category2/category3" value="<%=(cat != null ? cat : "")%>"required></td><td><%=(catErr != null ? catErr : "")%></td></tr>
            <tr><td>Price</td><td> $<input type="number" name="price" value="<%=(price !=null ? price:"")%>" required min="0" step="0.01"></td><td><%=(priceErr != null ? priceErr : "")%></td></tr>
            <tr><td>Stock</td><td><input type="number" name="stock" value="<%=(stock != null ? stock : "")%>" required min="0"></td><td><%=(stockErr != null ? stockErr : "")%></td></tr>
            <tr><td>Description</td><td><input type="text" name="desc" value="<%=(desc !=null ? desc:"")%>" required></td><td><%=(descErr != null ? descErr : "")%></td></tr>
            <tr><td><input class ="upload" type="file" name="image" id="image" accept="image/*" value="choose an image"></td><td><input type="submit" id="submit" name="submit" value="Submit"></td></tr>
        </table>
    </form>
</body>  
</html>
