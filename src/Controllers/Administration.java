/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Car;
import Entities.User;
import Models.Administrator;
import Models.BusinessMember;
import java.util.Collection;
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
    
    public static void setUserToAdmin(String login){
        User user = User.getByLogin(login);
        Models.User modelUser = new Models.User(
                user.getName(),
                user.getAdress(), 
                user.getLogin(), 
                user.getPassword(), 
                user.getPhonenumber(),
                user.getAge()
        );
        Administrator newAdmin = new Administrator(modelUser);
        user.setUserlevel(newAdmin.getUserLevel());
        user.setDiscountlevel(newAdmin.getDiscountLevel());
    }
    
    public static void setUserToBusiness(String login){
        User user = User.getByLogin(login);
        Models.User modelUser = new Models.User(
                user.getName(),
                user.getAdress(), 
                user.getLogin(), 
                user.getPassword(), 
                user.getPhonenumber(),
                user.getAge()
        );
        BusinessMember newBM = new BusinessMember(modelUser);
        user.setUserlevel(newBM.getUserLevel());
        user.setDiscountlevel(newBM.getDiscountLevel());
    }
        
    public static void SetCarDiscount(double discount){
        // TODO : faire appelle à la fonction setDiscount de la class car
    }
    
    public static List<User> getUsers(){
        return User.getAllUsers();
    }    
    
    public static List<Car> getCars(){
        return Car.getAllCars();
    }
    
    public static User getUser(String login){
        return User.getByLogin(login);
    }
    
    
    public static void main(String[] args){
        Collection<Car> cars = getCars();
        for (Car car : cars) {
            System.out.println(car.getDescription());
        }
    }
    
}
