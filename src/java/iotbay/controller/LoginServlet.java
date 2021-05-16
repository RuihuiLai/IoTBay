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
import iotbay.model.dao.DBSystemAdminManager;
import iotbay.model.*;


public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        DBStaffManager manager1 = (DBStaffManager) session.getAttribute("manager1");
        DBSystemAdminManager manager2 = (DBSystemAdminManager) session.getAttribute("manager2");
        Customer customer = null;
        Staff staff = null;
        SystemAdmin systemAdmin = null;
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            if(role.equals("customer")){
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
            }else if(role.equals("staff")){
                try{
                    staff = manager1.findStaff(email, password);
                    if(staff != null){
                        session.setAttribute("staff", staff);
                        request.getRequestDispatcher("welcome.jsp").include(request, response);
                    }else{
                        session.setAttribute("existErr", "Staff does not exist in the database!");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                }catch(SQLException | NullPointerException ex){
                    System.out.println(ex.getMessage() == null ? "Staff does not exist" : "welcome");
                }
            }else{
                try{
                    systemAdmin = manager2.findSystemAdmin(email, password);
                    if(systemAdmin != null){
                        session.setAttribute("systemAdmin", systemAdmin);
                        request.getRequestDispatcher("welcome.jsp").include(request, response);
                    }else{
                        session.setAttribute("existErr", "System Admin does not exist in the database!");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                }catch(SQLException | NullPointerException ex){
                    System.out.println(ex.getMessage() == null ? "Staff does not exist" : "welcome");
                }
            }
        }
    }
}