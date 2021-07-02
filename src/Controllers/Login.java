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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User test = new User("test2@gm.com", "tutu");
        System.out.println(test.connection());
    }
    
}
