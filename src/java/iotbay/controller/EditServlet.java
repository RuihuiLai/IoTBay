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

public class EditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String address = streetNumber + "§" + streetName + "§" + suburb + "§" + state + "§" + zipcode;
        String phone_number = request.getParameter("phone_number");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        
        Customer customer = null;
        try{
            customer = manager.findCustomer(email, password);
            if(customer != null){
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }else{
                session.setAttribute("existErr", "Customer does not exist in the database!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        }catch(SQLException ex){
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}