/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author kanab
 */
public class IndividualMember extends User{
    private String userLevel;
    private double discountLevel;

    public IndividualMember(User customer) {
        super(customer.getName(), customer.getAdress(), customer.getLogin(), 
                customer.getPassword(), customer.getPhoneNumber(), customer.getAge());
        this.userLevel = "INDIVIDUAL MEMBER";
        this.discountLevel = 0.10;
        
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public double getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(double discountLevel) {
        this.discountLevel = discountLevel;
    }

}
