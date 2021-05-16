/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model.dao;

import iotbay.model.Order;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class DBOrderManager {

    private Statement st;

    public DBOrderManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//Find user by email and password in the database   
    public Order findOrder(String orderID) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM IOTUSER.\"ORDER\" WHERE ORDERID=" + orderID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int id = rs.getInt(1);
            if (orderID.equals(Integer.toString(id))) {
                String status = rs.getString(2);
                Date orderTime = rs.getDate(3);
                String shipmentID = rs.getString(4);
                String paymentID = rs.getString(5);
                String userID = rs.getString(6);
                Double totalPrice = rs.getDouble(7);
                String orderList = rs.getString(8);
                return new Order(id, status, orderTime, shipmentID, paymentID, userID, totalPrice, orderList);
            }
        }
        return null;
    }

//Add a order-data into the database   
    public void addOrder(String status, String orderTime, String shipmentID, String paymentID, String userID, String totalPrice, String orderList) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.\"ORDER\" (STATUS, ORDERTIME, SHIPMENTID, PAYMENTID, USERID, TOTALPRICE, ORDERLIST) " + "VALUES('" + status + "','" + orderTime + "','" + shipmentID + "','" + paymentID + "','" + userID + "'," + totalPrice + ",'" + orderList + "')");
    }

    public int getOrderID(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT MAX(ORDERID) AS LargestOrderID FROM IOTUSER.\"ORDER\" WHERE USERID='" + userID + "'");
        while (rs.next()) {
            int orderID = rs.getInt(1);
            return orderID;
        }
        return 0;
    }

//update a order details in the database   
    public void updateOrder(int orderID, String status, String orderTime, String shipmentID, String paymentID, String userID, String totalPrice, String orderList) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.\"ORDER\" SET STATUS='" + status + "',ORDERTIME='" + orderTime + "',SHIPMENTID='" + shipmentID + "',PAYMENTID='" + paymentID + "',USERID='" + userID + "',TOTALPRICE=" + totalPrice + ",ORDERLIST='" + orderList + "' WHERE ORDERID = " + orderID + "");
    }
    
        public void cancelOrder(String orderID) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.\"ORDER\" SET STATUS='CANCELLED' WHERE ORDERID = " + orderID + "");
    }

//delete a user from the database   
    public void deleteOrder(String orderID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM IOTUSER.\"ORDER\" WHERE ORDERID=" + orderID);
    }

    public ArrayList<Order> fetchOrders() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"ORDER\"");
        ArrayList<Order> orders = new ArrayList();

        while (rs.next()) {
            int orderID = rs.getInt(1);
            String status = rs.getString(2);
            Date orderTime = rs.getDate(3);
            String shipmentID = rs.getString(4);
            String paymentID = rs.getString(5);
            String userID = rs.getString(6);
            Double totalPrice = rs.getDouble(7);
            String orderList = rs.getString(8);
            orders.add(new Order(orderID, status, orderTime, shipmentID, paymentID, userID, totalPrice, orderList));
        }
        return orders;
    }

    public ArrayList<Order> fetchOrders(String uid) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"ORDER\" WHERE USERID=" + uid);
        ArrayList<Order> orders = new ArrayList();

        while (rs.next()) {
            int orderID = rs.getInt(1);
            String status = rs.getString(2);
            Date orderTime = rs.getDate(3);
            String shipmentID = rs.getString(4);
            String paymentID = rs.getString(5);
            String userID = rs.getString(6);
            Double totalPrice = rs.getDouble(7);
            String orderList = rs.getString(8);
            orders.add(new Order(orderID, status, orderTime, shipmentID, paymentID, userID, totalPrice, orderList));
        }
        return orders;
    }

    public boolean checkOrders(String orderID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"ORDER\" WHERE ORDERID=" + orderID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public ArrayList<Order> searchOrder(String id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"ORDER\" WHERE ORDERID=" + id + "");
        ArrayList<Order> orders = new ArrayList();

        while (rs.next()) {
            int orderID = rs.getInt(1);
            String status = rs.getString(2);
            Date orderTime = rs.getDate(3);
            String shipmentID = rs.getString(4);
            String paymentID = rs.getString(5);
            String userID = rs.getString(6);
            Double totalPrice = rs.getDouble(7);
            String orderList = rs.getString(8);
            orders.add(new Order(orderID, status, orderTime, shipmentID, paymentID, userID, totalPrice, orderList));
        }
        return orders;
    }

    public ArrayList<Order> searchOrder(String id, String uid) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"ORDER\" WHERE ORDERID=" + id + "AND USERID="+uid);
        ArrayList<Order> orders = new ArrayList();

        while (rs.next()) {
            int orderID = rs.getInt(1);
            String status = rs.getString(2);
            Date orderTime = rs.getDate(3);
            String shipmentID = rs.getString(4);
            String paymentID = rs.getString(5);
            String userID = rs.getString(6);
            Double totalPrice = rs.getDouble(7);
            String orderList = rs.getString(8);
            orders.add(new Order(orderID, status, orderTime, shipmentID, paymentID, userID, totalPrice, orderList));
        }
        return orders;
    }

}
