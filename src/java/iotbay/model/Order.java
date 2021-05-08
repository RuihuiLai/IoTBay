/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Reyvaldo
 */
public class Order implements Serializable{
    private int orderID;
    private String status;
    private Date orderTime;
    private int shipmentID;
    private int paymentID;
    private int userID;
    private Double totalPrice;

    public Order(int orderID, String status, Date orderTime, int shipmentID, int paymentID, int userID, Double totalPrice) {
        this.orderID = orderID;
        this.status = status;   
        this.orderTime = orderTime;
        this.shipmentID = shipmentID;
        this.paymentID = paymentID;
        this.userID = userID;
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}