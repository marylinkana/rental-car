/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.time.LocalDate;
import javax.persistence.Query;

/**
 *
 * @author kanab
 */
public class Register {
    
    public static void create(String login, String adress, String name, String password, int phonenumber, LocalDate age) {
        Models.User newUser = new Models.User(name, adress, login, password, phonenumber, age);
        Entities.User.create(newUser);
    }
    
    public static void main(String[] args){
       Query query = BDSession.getEM().createQuery("INSERT INTO user (name, adress, login, password, phonenumber, age) VALUES (test, test, test, test, test, 01/01/2022)");
       query.executeUpdate();
    }
}
