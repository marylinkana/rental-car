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
public class BusinessMember extends Customer{
    private String memberType;
    private double discountLevel;

    public BusinessMember(Customer customer) {
        super(customer.getName(), customer.getAdress(), customer.getLogin(), 
                customer.getPassword(), customer.getPhoneNumber(), customer.getAge());
        this.memberType = "BUSINESS MEMBER";
        this.discountLevel = 0.10;
        
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public double getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(double discountLevel) {
        this.discountLevel = discountLevel;
    }

}
