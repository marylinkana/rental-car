/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NewCustomer;
import Models.User;
import java.util.Date;


/**
 *
 * @author kanab
 */
public class Register {
    
    public static void newCustomer(String login, String adress, String name, String password, int phonenumber, Date age) {
        User user = new User(name, adress, login, password, phonenumber, age);
        NewCustomer newCustomer = new NewCustomer(user);
        Entities.User.create(newCustomer);
    }
        
    public static void main(String[] args){
        Date age = new Date(2000, 01, 01);
        newCustomer("test3", "test3", "test3", "test3", 0755525, age);
        
    }
}
