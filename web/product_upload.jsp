<%-- 
    Document   : product_upload
    Created on : May 1, 2021, 11:08:16 AM
    Author     : Reyvaldo
--%>

<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.image.RenderedImage"%>
<%@page import="java.awt.Image"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File;"%>
<%@page import="iotbay.model.Product"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <span id="links"> <a href="staff_prod_list.jsp"> staff item view</a></span>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <%
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
        response.setDateHeader("Expires", 0); //prevents caching at the proxy server  
        if (request.getParameter("submit") != null && request.getParameter("submit").equals("Submit")) {
            String name = request.getParameter("name");
            String cat = request.getParameter("category");
            String price = request.getParameter("price");
            String desc = request.getParameter("desc");
            String stock = request.getParameter("stock");

            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBProductManager db = new DBProductManager(conn);
            db.addProduct(name, cat, price, desc, stock);
            int prodID = db.findProduct(name).getProductID();

            String img = request.getParameter("image");
            String buildPath = request.getServletContext().getRealPath("");
            String iotBayPath = buildPath.substring(0, buildPath.length() - 9);
            String productPicturesPath = iotBayPath + "web/productPictures/";
            String canBeUsed = iotBayPath + "web/canBeUsed/" + img;

            System.out.print(productPicturesPath);
            System.out.print(canBeUsed);

            File initialImage = new File(canBeUsed);

            BufferedImage bImage = ImageIO.read(initialImage);

            ImageIO.write(bImage, "jpg", new File(productPicturesPath + prodID + ".jpg"));
    %>
    <meta http-equiv="Refresh" content="0;url=main.jsp">
    <%
        }
    %>
    <form action="product_upload.jsp" method="post">
        <table>
            <td><img id="myimage" src="productPictures/noImage.jpg" height="256" width="256"><br>
                <input class ="upload" type="file" name="image" id="image" accept="image/*" onchange="updatePicture()"></td>
            <td><table>
                    <tr><td>Item name</td><td><input type="text" name="name" placeholder="" required></td></tr>
                    <tr><td>Category</td><td><input type="text" name="category" placeholder="category1/category2/category3" required></td></tr>
                    <tr><td>Price</td><td> $<input type="number" name="price" placeholder="" required></td></tr>
                    <tr><td>Stock</td><td><input type="number" name="stock"  required></td></tr>
                    <tr><td>Description</td><td><input type="text" name="desc"  required></td></tr>
                    <tr><td><input type="submit" id="submit" name="submit" value="Submit"></td></tr>
                </table></td>
        </table>
    </form>
</body>
<script>
    function updatePicture() {
        let newPicture = document.getElementById("image").value;
        newPicture = newPicture.substring(12);
        document.getElementById("myimage").src = "canBeUsed/" + newPicture;
        console.log(newPicture);
    }
</script>   
</html>
