package iotbay.model.dao;

import iotbay.model.Staff;
import java.sql.*;
import java.util.ArrayList;

public class DBStaffManager {
    private Statement st;

    public DBStaffManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
//Find user by email and password in the database   
    public Staff findStaff(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM IOTUSER.STAFF WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmail = rs.getString(4);
            String staffPassword = rs.getString(5);
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                int staffID = rs.getInt(1);
                String staffFirstName = rs.getString(2);
                String staffLastName = rs.getString(3);
                String staffGender = rs.getString(6);
                String staffAddress = rs.getString(7);
                String staffPhone = rs.getString(8);
                String staffStartDate = rs.getString(9);
                String staffEndDate = rs.getString(10);
                String staffPosition = rs.getString(11);
                return new Staff(staffID, staffFirstName, staffLastName, staffEmail, staffPassword, staffGender, staffAddress, staffPhone, staffStartDate, staffEndDate, staffPosition);
            }
        }
        return null;
    }
//Add a user-data into the database   
    public void addStaff(String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber, String startDate, String endDate, String position) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.STAFF (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER, STARTDATE, ENDDATE, POSITION) " + "VALUES('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + gender + "','" + address + "','" + phoneNumber + "','" + startDate + "','" + endDate + "','" + position + "')");
    }

//update a user details in the database   
    public void updateStaff(String userID, String firstName, String lastName, String eMail, String password, String gender, String address,  String phoneNumber, String startDate, String endDate, String position) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.STAFF SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "',EMAIL='" + eMail + "',PASSWORD='" + password + "',GENDER='" + gender + "',ADDRESS='" + address + "', PHONENUMBER='" + phoneNumber + "',STARTDATE='" + startDate + "', ENDDATE='"+ endDate +
                "' WHERE USERID=" + userID + "");
    }

//delete a user from the database   
    public void deleteStaff(String userID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM IOTUSER.STAFF WHERE USERID=" + userID + "");
    }
    
    public ArrayList<Staff> fetchStaffs() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.STAFF");
        ArrayList<Staff> staffs = new ArrayList();

        while (rs.next()) {
            int staffID = rs.getInt(1);
            String staffFirstName = rs.getString(2);
            String staffLastName = rs.getString(3);
            String staffEmail = rs.getString(4);
            String staffPassword = rs.getString(5);
            String staffGender = rs.getString(6);
            String staffAddress = rs.getString(7);
            String staffPhone = rs.getString(8);
            String staffStartDate = rs.getString(9);
            String staffEndDate = rs.getString(10);
            String staffPosition = rs.getString(11);
            staffs.add(new Staff(staffID, staffFirstName, staffLastName, staffEmail, staffPassword, staffGender, staffAddress, staffPhone, staffStartDate, staffEndDate, staffPosition));
        }
        return staffs;
    }
    
    public boolean checkStaff(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.STAFF WHERE USERID=" + userID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
