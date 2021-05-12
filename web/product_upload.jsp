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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product</h1>
        <%
            File initialImage = new File("C:\\Users\\Reyvaldo\\Pictures\\15284187.jpg");
            BufferedImage bImage = ImageIO.read(initialImage);
            String buildPath = request.getServletContext().getRealPath("");
            String iotBayPath = buildPath.substring(0, buildPath.length() - 9);
            String productPicturesPath = iotBayPath + "web\\productPictures\\";
            ImageIO.write(bImage, "jpg", new File(productPicturesPath + "image.jpg"));
        %>
        <form action="main.jsp" method="post"
              enctype="multipart/form-data">
            <table>
                <td><img src="productPictures.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="256" width="256"><br><input type="file" name="image" id="image" accept="image/*"></td>
                <td><table>
                    <tr><td>Item name</td><td><input type="text" name="name" placeholder="" required></td></tr>
                    <tr><td>Category</td><td><input type="text" name="category" placeholder="category1/category2/category3" required></td></tr>
                    <tr><td>Price</td><td> $<input type="number" name="price" placeholder="" required></td></tr>
                    <tr><td><input type="submit" name="submit" value="Submit"></td></tr>
                </table></td>
            </table>
        </form>

    </body>
</html>
