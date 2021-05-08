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
    <span id="links"> <a href="ProductListServlet"> staff item view</a></span>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="ProductCreateServlet" method="POST" enctype="multipart/form-data">
        <table>
            <tr><td>Item name</td><td><input type="text" name="name" placeholder="" required></td></tr>
            <tr><td>Category</td><td><input type="text" name="category" placeholder="category1/category2/category3" required></td></tr>
            <tr><td>Price</td><td> $<input type="number" name="price" placeholder="" required></td></tr>
            <tr><td>Stock</td><td><input type="number" name="stock"  required></td></tr>
            <tr><td>Description</td><td><input type="text" name="desc"  required></td></tr>
            <tr><td><input class ="upload" type="file" name="image" id="image" accept="image/*" value="choose an image"></td><td><input type="submit" id="submit" name="submit" value="Submit"></td></tr>
        </table>
    </form>
</body>  
</html>
