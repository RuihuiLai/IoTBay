<%-- 
    Document   : login
    Created on : Mar 20, 2021, 1:36:40 PM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Page</title>
    </head>
    <body>
        <div>
        <span id="links"> <a href="index.jsp">Home</a></span>
        </div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        <div class="login_form">
            <form action="LoginServlet" method="post">
                <h1>Login <span class="message"><%=(existErr != null ? existErr : "") %></span></h1>
                <input type="radio" id="customer" name="role" value="customer">
                <label for="customer">Customer</label><br>
                <input type="radio" id="staff" name="role" value="staff">
                <label for="staff">Staff</label><br>
                <input type="radio" id="system_admin" name="role" value="system_admin">
                <label for="staff">System Admin</label><br>
                <p class ="head ">E-mail</p>
                <input type="text" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required>
                <p class ="head">Password</p>
                <input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required>
                <p><a class="forgot_password" href="retrieve_password.jsp">Forgot your password?</a></p>
                <input type="submit" name="login" value="Login">                       
                <p>Don't have an account？<a class="Resigter" href="register.jsp">Register</a></p>                     
            </form>
        </div>
    </body>
</html>
