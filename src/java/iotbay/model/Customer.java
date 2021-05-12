/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

import java.util.Date;

/**
 *
 * @author Reyvaldo
 */
public class Customer extends User{
    private boolean subscription;

    public Customer(int userID, String firstName, String lastName, String eMail, String password, String gender, String address, Date dateOfBirth, String phoneNumber, boolean subscription) {
        super(userID, firstName, lastName, eMail, password, gender, address, dateOfBirth, phoneNumber);
        this.subscription = subscription;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }
            
}
