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
public class NewCustomer extends User{
    private String userLevel;
    private double discountLevel;

    public NewCustomer(User customer) {
        super(customer.getName(), customer.getAdress(), customer.getLogin(), 
                customer.getPassword(), customer.getPhoneNumber(), customer.getAge());
        this.userLevel = "NEW CUSTOMER";
        this.discountLevel = 0.0;
        
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
