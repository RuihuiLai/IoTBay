/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

/**
 *
 * @author Reyvaldo
 */
public class Customer extends User{
    private boolean subscription;

    public Customer(int userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) {
        super(userID, firstName, lastName, eMail, password, gender, address, phoneNumber);
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }
            
}
