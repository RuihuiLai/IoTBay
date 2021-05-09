/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Product;
import iotbay.model.dao.DBProductManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Reyvaldo
 */
@WebServlet(name = "ProductUpdateServlet", urlPatterns = {"/ProductUpdateServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProductUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager manager = (DBProductManager) session.getAttribute("manager");
        Validator validator = new Validator();
        int prodID = Integer.parseInt(request.getParameter("ID"));
        String nameN = request.getParameter("name");
        String catN = request.getParameter("category");
        String priceN = request.getParameter("price");
        String descN = request.getParameter("desc");
        String stockN = request.getParameter("stock");
        String buildPath = getServletContext().getRealPath("");
        String iotBayPath = buildPath.substring(0, buildPath.length() - 9);
        String uploadPath = iotBayPath + "web/productPictures";
        if (stockN.equals("")) {
            stockN = "-1";
        }
        if (priceN.equals("")) {
            priceN = "-1";
        }

        Part part = request.getPart("image");
        InputStream fileContent = part.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);

        Product product = new Product(prodID, nameN, catN, Double.parseDouble(priceN), descN, Integer.parseInt(stockN));
        request.setAttribute("product", product);

        if (!validator.validatePositive(Double.parseDouble(priceN))) {
            request.setAttribute("priceErr", "price needs to be a positive number");
            product = new Product(prodID, nameN, catN, 0.00, descN, Integer.parseInt(stockN));
            request.setAttribute("product", product);
            request.getRequestDispatcher("product_edit.jsp").include(request, response);
        } else if (!validator.validatePositive(Integer.parseInt(stockN))) {
            product = new Product(prodID, nameN, catN, Double.parseDouble(priceN), descN, 0);
            request.setAttribute("product", product);
            request.setAttribute("stockErr", "stock needs to be a positive number");
            request.getRequestDispatcher("product_edit.jsp").include(request, response);
        } else if (!validator.validateStringFilled(nameN)) {
            request.setAttribute("nameErr", "name needs to be filled");
            request.getRequestDispatcher("product_edit.jsp").include(request, response);
        } else if (!validator.validateStringFilled(catN)) {
            request.setAttribute("categoryErr", "category needs to be filled");
            request.getRequestDispatcher("product_edit.jsp").include(request, response);
        } else if (!validator.validateStringFilled(descN)) {
            request.setAttribute("descErr", "description needs to be filled");
            request.getRequestDispatcher("product_edit.jsp").include(request, response);
        } else {
            try {
                manager.updateProduct(Integer.toString(prodID), nameN, catN, priceN, descN, stockN);
                if (!part.getSubmittedFileName().equals("")) {
                    File targetFile = new File(uploadPath + File.separator + prodID + ".jpg");
                    OutputStream outStream = new FileOutputStream(targetFile);
                    outStream.write(buffer);
                }
                product = manager.findProduct(prodID);
                request.setAttribute("product", product);
                request.getRequestDispatcher("product_edit.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProductCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
