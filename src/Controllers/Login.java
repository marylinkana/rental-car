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

    public static String verify(String login, String password){
        System.out.println(User.isConnect(login, password)); 
        if (!User.isConnect(login, password)){
            return "your password or email is incorrect, try again";
        }
        return "welcome";
        // TODO : Call the appropriate view
    }
    
    public static void main(String[] args){
        verify("test2@gm.com", "toto" );
    }
    
}
