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
import iotbay.model.Order.*;
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
public class CreateOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBOrderManager manager = (DBOrderManager) session.getAttribute("manager");
        String prodID = request.getParameter("ID");
        String totalPrice = request.getParameter("PRICE");
        Customer customer = (Customer) session.getAttribute("customer");

        try {
            manager.addOrder("ARRIVING", "01/01/2021", 1111,1111, customer.getUserID(), totalPrice, prodID);
            int orderID = manager.getOrderID(customer.getUserID());
            manager.updateOrder(orderID, "ARRIVING", "01/01/2021", orderID, orderID, customer.getUserID(), totalPrice, prodID);
            request.setAttribute("value", orderID);
            request.getRequestDispatcher("view_particular_order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
