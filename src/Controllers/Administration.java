/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Car;
import Entities.User;
import java.util.List;


/**
 *
 * @author kanab
 */
public class Administration {

    public static void newCar(String immatriculation, String description, double pricePerDay) {
        Car car = new Car(immatriculation, description, pricePerDay);
        System.out.println(car.toString());
    }
    
    public static void SetCarDiscount(double discount){
        // TODO : faire appelle à la fonction setDiscount de la class car
    }
    
    public static List<User> getUsers(){
        return User.getAllUsers();
    }
    
    public static void main(String[] args){
        List<User> users = getUsers();
        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getLogin() + " : " + users.get(i).getName()); 
        }
    }
    
}
