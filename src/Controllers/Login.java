/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;

/**
 *
 * @author kanab
 */
public class Login {

    public static void verify(String login, String password) {
        User test = new User(login, password);
        System.out.println(test.isConnect()); 
        // TODO : Call the appropriate view
    }
    
}
