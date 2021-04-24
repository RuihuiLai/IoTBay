/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Reyvaldo
 */
public class User implements Serializable{
    private int userID;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String gender;
    private String address;
    private String phoneNumber;

    public User(int userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int store() throws ClassNotFoundException, SQLException{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/iotdb; user=iotuser; password=admin");
    PreparedStatement ps = con.prepareStatement("INSERT INTO \"USER\" (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER) VALUES(?,?,?,?,?,?,?)");
    ps.setString(1,firstName);
    ps.setString(2,lastName);
    ps.setString(3,eMail);
    ps.setString(4,password);
    ps.setString(5,gender);
    ps.setString(6,address);
    ps.setString(7,phoneNumber);
    return(ps.executeUpdate());
    }
}


