<%@page import="iotbay.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/register.css">
        <title>Edit Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String) session.getAttribute("updated");
            String deleted = (String) session.getAttribute("deleted");
            String[] address = customer.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }
        %>    
        <span id="links"> <a href="main.jsp"> Main</a> | <a href="CancelRegistrationServlet?submitted=<%=customer.getUserID()%>"> Delete</a> | <a href="LogoutServlet"> Logout</a></span>
        <div class="register_form">
            <form action="UpdateServlet" method="post">
                <h1>Edit User <span class="message"><%=(updated != null ? updated : "")%></span></h1>
                <p class ="head">E-mail</p>
                <input type="text" name="email" placeholder="E-mail" value="<%= customer.geteMail()%>"required>
                <table>
                    <tr><th><p class ="head">First Name</p></th> <th><p class ="head">Last Name</p></th></tr>
                    <tr><td><input type="text" name="first_name" placeholder="first name" value="<%= customer.getFirstName()%>"required></td> <td><input type="text" name="last_name" placeholder="last name" value="<%= customer.getLastName()%>"required></td></tr>
                </table>
                <p class ="head">Password</p>
                <input type="password" name="password" placeholder="Password" value="<%= customer.getPassword()%>"required>
                <p class ="head">Gender</p>
                <select class="select" name="gender">
                    <option value="<%= customer.getGender()%>"><%= customer.getGender()%></option>
                    <option value="male">Male</option>
                    <option value="female">Female</option> 
                    <option value="other">Other</option> 
                </select>
                <p class ="head">Address</p>
                <table class="address">
                    <td><input type="number" name="streetNumber" placeholder="street no" value="<%= address[0]%>"required></td> <td><input type="text" name="streetName" placeholder="street name" value="<%= address[1]%>"required></td> <td><input type="text" name="suburb" placeholder="suburb" value="<%= address[2]%>"required></td> <td><input type="text" name="state" placeholder="state" value="<%= address[3]%>"required></td><td><input type="number" name="zipcode" placeholder="zip code" value="<%= address[4]%>"required></td>
                </table>
                <p class ="head">Phone Number</p>
                <input type="tel" name="phone_number" placeholder="phone number" value="<%= customer.getPhoneNumber()%>"required>
                <input type="submit" name="Register" value="Update">
                <input type="hidden" value="<%= customer.getUserID()%>" name="submitted">
            </form>
        </div>
    </body>
</html>
