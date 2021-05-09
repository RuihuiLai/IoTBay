/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Product;
import iotbay.model.dao.DBProductManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Reyvaldo
 */
public class ProductViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager manager = (DBProductManager) session.getAttribute("manager");
        int prodID = Integer.parseInt(request.getParameter("ID"));

        try {
            Product products = manager.findProduct(prodID);
            request.setAttribute("product", products);
            request.getRequestDispatcher("product.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
