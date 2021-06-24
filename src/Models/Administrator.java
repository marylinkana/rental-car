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
public class Administrator extends User{
    private String userLevel;
    private double discountLevel;

    public Administrator(User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), 
                user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = "Administrator";
        this.discountLevel = 0.15;
        
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
