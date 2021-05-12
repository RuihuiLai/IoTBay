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
import javafx.scene.control.ListView;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = request.getParameter("submitted");
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
        Customer customer = new Customer(0, first_name, last_name, email, password, gender, address, phone_number);
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        
        try{
            if(customer != null){
                session.setAttribute("customer", customer);
                manager.updateCustomer(userID, first_name, last_name, email, password, gender, address, phone_number);
                session.setAttribute("updated", "Update was successfully!");
                request.getRequestDispatcher("profile.jsp").include(request, response);
            }else{
                session.setAttribute("updated", "Update was not successfully!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        }catch(SQLException ex){
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("profile.jsp");
    }
}