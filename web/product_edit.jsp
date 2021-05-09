<%-- 
    Document   : product_edit
    Created on : May 2, 2021, 5:10:03 PM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
    <span id="links"> <a href="ProductListServlet"> staff item view</a></span>
    <title>edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
 <%
     Product prod = (Product) request.getAttribute("product");
     String priceErr = (String) request.getAttribute("priceErr");
     String stockErr = (String) request.getAttribute("stockErr");
     String nameErr = (String) request.getAttribute("nameErr");
     String descErr = (String) request.getAttribute("descErr");
     String catErr = (String) request.getAttribute("catErr");
 %>
    <form action="ProductUpdateServlet" method="post" enctype="multipart/form-data" autocomplete="off">
        <table>
            <td><img id="myimage" src="productPictures/<%=prod.getProductID()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="256" width="256"><br>
                <input class ="upload" type="file" name="image" id="image" accept="image/*" onchange="updatePicture()"></td>
            <td><table>
                    <tr><td>Item name</td><td><input type="text" name="name" value="<%=prod.getName()%>" required></td><td><%=(nameErr !=null ? nameErr:"")%></td></tr>
                    <tr><td>Category</td><td><input type="text" name="category" value="<%=prod.getCategory()%>" placeholder="category1/category2/category3" required></td><td><%=(catErr !=null ? catErr:"")%></td></tr>
                    <tr><td>Price</td><td> $<input type="number" name="price" value="<%=prod.getPrice()%>"  required min="0" step="0.01"></td> <td><%=(priceErr !=null ? priceErr:"")%></td></tr>
                    <tr><td>Stock</td><td><input type="number" name="stock" value="<%=prod.getStock()%>" required min="0"></td> <td><%=(stockErr !=null ? stockErr:"")%></td></tr>
                    <tr><td>Description</td><td><input type="text" name="desc" value="<%=prod.getDescription()%>" required></td><td><%=(descErr !=null ? descErr:"")%></td></tr>
                    <tr><td><input type="submit" id="submit" name="submit" value="Submit"></td></tr>
                    <input type="hidden" id="ID" name="ID" value="<%=prod.getProductID()%>">
                </table></td>
        </table>
    </form>
</body>
</html>