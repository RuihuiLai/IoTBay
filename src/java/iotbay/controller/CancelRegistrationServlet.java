package iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.dao.DBCustomerManager;
import iotbay.model.*;

public class CancelRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = request.getParameter("submitted");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        
        try{
            manager.deleteCustomer(userID);
            session.setAttribute("deleted", "Cancellation was successfully!");
            response.sendRedirect("delete_account.jsp");
        }catch(SQLException ex){
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
