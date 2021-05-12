package iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.dao.DBCustomerManager;
import iotbay.model.dao.DBStaffManager;
import iotbay.model.*;


public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        Customer customer = null;
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            try{
                customer = manager.findCustomer(email, password);
                if(customer != null){
                    session.setAttribute("customer", customer);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                }else{
                    session.setAttribute("existErr", "Customer does not exist in the database!");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }catch(SQLException | NullPointerException ex){
                System.out.println(ex.getMessage() == null ? "Customer does not exist" : "welcome");
            }
        }
    }
}