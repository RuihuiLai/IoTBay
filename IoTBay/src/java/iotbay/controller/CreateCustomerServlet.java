package iotbay.controller;

import customer.Customer;
import iotbay.model.dao.DBSystemAdminManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author 13725
 */
public class CreateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String DOB = request.getParameter("DOB");
        String phonenumber = request.getParameter("phonenumber");
        DBSystemAdminManager manager = (DBSystemAdminManager) session.getAttribute("manager");
        Validator validator = new Validator();
        Customer customer = (Customer) session.getAttribute("customer");
        
    }
