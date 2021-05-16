/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Customer;
import java.io.IOException;
import iotbay.model.dao.*;
import javax.servlet.http.HttpSession;
import iotbay.model.Order;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joshcelik-alvis
 */
public class ViewParticularOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBOrderManager oManager = (DBOrderManager) session.getAttribute("oManager");
        String orderID = request.getParameter("ID");

        try {
            Order orders = oManager.findOrder(orderID);
            request.setAttribute("order", orders);
            request.getRequestDispatcher("view_particular_order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewParticularOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
