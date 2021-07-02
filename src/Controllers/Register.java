/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;
import java.util.Date;

/**
 *
 * @author kanab
 */
public class Register {
    
    public static void create(String login, String adress, String name, String password, Integer phonenumber, Date age, String userlevel, Double discountlevel) {
        User user = new User(login, adress, name, password, phonenumber, age, userlevel, discountlevel);
    }
}
