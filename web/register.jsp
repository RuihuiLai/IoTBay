<%-- 
    Document   : register
    Created on : Mar 19, 2021, 11:26:36 AM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/register.css">
        <title>Register Page</title>
    </head>
    <body>
        <div>
            <span id="links"> <a href="index.jsp">Home</a></span>
        </div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstnameErr = (String) session.getAttribute("firstnameErr");
            String lastnameErr = (String) session.getAttribute("lastnameErr");
        %>
        <div class="register_form">
            <form action="RegisterServlet" method="post">
                <h1> Register </h1>
                <input type="radio" id="customer" name="role" value="customer">
                <label for="customer">Customer</label><br>
                <input type="radio" id="staff" name="role" value="staff">
                <label for="staff">Staff</label><br>
                <p class ="head">E-mail</p>
                <input type="text" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required>
                <table>
                    <tr><th><p class ="head">First Name</p></th> <th><p class ="head">Last Name</p></th></tr>
                    <tr><td><input type="text" name="first_name" placeholder="<%=(firstnameErr != null ? firstnameErr : "Enter first name")%>" required></td> <td><input type="text" name="last_name" placeholder="<%=(lastnameErr != null ? lastnameErr : "Enter last name")%>" required></td></tr>
                </table>
                <p class ="head">Password</p>
                <input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required>
                <p class ="head">Gender</p>
                <select class="select" name="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option> 
                    <option value="other">Other</option> 
                </select>
                <p class ="head">Address</p>
                <table class="address">
                    <td><input type="number" name="streetNumber" placeholder="street no" required></td> <td><input type="text" name="streetName" placeholder="street name" required></td> <td><input type="text" name="suburb" placeholder="suburb" required></td> <td><input type="text" name="state" placeholder="state" required></td><td><input type="number" name="zipcode" placeholder="zip code" required></td>
                </table>
                <p class ="head">Phone Number</p>
                <input type="tel" name="phone_number" placeholder="phone number" required>
                <p><input type="checkbox" id="TOS" name="TOS" value="TOS" required/> I have read and accepted the <a href="tos.jsp">Terms of Service</a></p>
                <input type="submit" name="Register" value="Register">                       
                <p>Already have an account?<a class="Login" href="login.jsp">Login</a></p>                      
            </form>
        </div>
    </body>
</html>