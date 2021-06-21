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
public class IndividualCustomer extends Customer{
    private CustomerType customerType;

    public IndividualCustomer(String name, String adress, String login, String password, int phoneNumber, int age) {
        super(name, adress, login, password, phoneNumber, age);
        this.customerType = new CustomerType("INDIVIDUAL", 0.10);
    }
    

}
