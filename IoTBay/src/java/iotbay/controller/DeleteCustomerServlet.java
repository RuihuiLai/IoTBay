package iotbay.controller;

import iotbay.model.dao.DBCustomerManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteCustomerServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        String CustomerID = request.getParameter("ID");
        
        try {
            manager.deleteCustomer(USERID);
            response.sendRedirect("CustomerViewServlet");
        } catch (SQLException ex) {
            Logger.getLogger(CreateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
