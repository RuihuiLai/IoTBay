/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Product;
import iotbay.model.Staff;
import iotbay.model.dao.DBProductManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager pManager = (DBProductManager) session.getAttribute("pManager");
        String filter = request.getParameter("filter");
        String cat = request.getParameter("category");
        if (cat.equals("ALL")) {
            cat = "";
        }

        try {
            ArrayList<Product> products = pManager.filterCategoryAndName(filter, cat);
            ArrayList<String> categories = pManager.getCategories();
            request.setAttribute("list", products);
            request.setAttribute("filter", filter);
            request.setAttribute("cat", cat);
            if (cat.equals("")) {
                request.setAttribute("cat", "ALL");
            }
            request.setAttribute("cate", categories);
            request.getRequestDispatcher("staff_prod_list.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager pManager = (DBProductManager) session.getAttribute("pManager");
        Staff staff = (Staff) session.getAttribute("staff");

        if (staff == null) {
            request.getRequestDispatcher("MainPageServlet?staffOnly=only staff can access this").include(request, response);
        } else {
            try {
                ArrayList<Product> products = pManager.fetchProducts();
                ArrayList<String> categories = pManager.getCategories();
                request.setAttribute("list", products);
                request.setAttribute("cate", categories);
                request.getRequestDispatcher("staff_prod_list.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProductListServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
