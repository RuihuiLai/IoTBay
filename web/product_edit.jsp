<%-- 
    Document   : product_edit
    Created on : May 2, 2021, 5:10:03 PM
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
    <title>edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <%
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
        response.setDateHeader("Expires", 0); //prevents caching at the proxy server  
        int productID = Integer.parseInt(request.getParameter("ID"));
        DBConnector connector = new DBConnector();
        Connection conn = connector.openConnection();
        DBProductManager db = new DBProductManager(conn);
        String name = "";
        String category = "";
        String price = "";
        String stock = "";
        String desc = "";

        if (request.getParameter("submit") != null && request.getParameter("submit").equals("Submit")) {
            String img = request.getParameter("image");
            if (!img.equals("")) {
                String buildPath = request.getServletContext().getRealPath("");
                String iotBayPath = buildPath.substring(0, buildPath.length() - 9);
                String productPicturesPath = iotBayPath + "web/productPictures/";
                img = request.getParameter("image");
                String canBeUsed = iotBayPath + "web/canBeUsed/" + img;
                File initialImage = new File(canBeUsed);
                BufferedImage bImage = ImageIO.read(initialImage);
                ImageIO.write(bImage, "jpg", new File(productPicturesPath + productID + ".jpg"));
            }
            String nameN = request.getParameter("name");
            String catN = request.getParameter("category");
            String priceN = request.getParameter("price");
            String descN = request.getParameter("desc");
            String stockN = request.getParameter("stock");
            db.updateProduct(Integer.toString(productID), nameN, catN, priceN, descN, stockN);

    %>
    <meta http-equiv="Refresh" content="0;url=staff_prod_list.jsp">
    <%        } else {
            Product pd = db.findProduct(productID);
            name = pd.getName();
            price = Double.toString(pd.getPrice());
            category = pd.getCategory();
            desc = pd.getDescription();
            stock = Integer.toString(pd.getStock());
        }
    %>


    <form action="product_edit.jsp" method="get">
        <table>
            <td><img id="myimage" src="productPictures/<%=productID%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="256" width="256"><br>
                <input class ="upload" type="file" name="image" id="image" accept="image/*" onchange="updatePicture()"></td>
            <td><table>
                    <tr><td>Item name</td><td><input type="text" name="name" value="<%=name%>" required></td></tr>
                    <tr><td>Category</td><td><input type="text" name="category" value="<%=category%>" placeholder="category1/category2/category3" required></td></tr>
                    <tr><td>Price</td><td> $<input type="number" name="price" value="<%=price%>" required></td></tr>
                    <tr><td>Stock</td><td><input type="number" name="stock" value="<%=stock%>" required></td></tr>
                    <tr><td>Description</td><td><input type="text" name="desc" value="<%=desc%>" required></td></tr>
                    <tr><td><input type="submit" id="submit" name="submit" value="Submit"></td></tr>
                    <input type="hidden" id="ID" name="ID" value="<%=productID%>">
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