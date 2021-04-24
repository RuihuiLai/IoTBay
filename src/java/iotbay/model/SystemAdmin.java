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
public class SystemAdmin extends User{
    private Date startDate;
    private int contractLength;

    public SystemAdmin (Date startDate, int contractLength, int userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) {
        super(userID, firstName, lastName, eMail, password, gender, address, phoneNumber);
        this.startDate = startDate;
        this.contractLength = contractLength;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }
    
    
}
