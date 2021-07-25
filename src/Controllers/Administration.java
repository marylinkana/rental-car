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
import Models.IndividualMember;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author kanab
 */
public class Administration {
    //créate new car
    public static void newCar(String immatriculation, String description, double pricePerDay) {
        Car car = new Car(immatriculation, description, pricePerDay);
        System.out.println(car.toString());
    }
    
    // change the level of user to Administrato's level
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
    
    // change the level of user to Business's level
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
    
    // change the level of user to Individual's level
    public static void setUserToIndiv(String login){
        User user = User.getByLogin(login);
        Models.User modelUser = new Models.User(
                user.getName(),
                user.getAdress(), 
                user.getLogin(), 
                user.getPassword(), 
                user.getPhonenumber(),
                user.getAge()
        );
        IndividualMember newIM = new IndividualMember(modelUser);
        user.setUserlevel(newIM.getUserLevel());
        user.setDiscountlevel(newIM.getDiscountLevel());
    }
        
    // change level of discpunt's car or add a discount to a car
    public static void SetCarDiscount(double discount, String immat){
        Entities.Car.setCarDiscount(discount, immat);
    }
    
    // get the list of all the users in data base
    public static List<User> getUsers(){
        return User.getAllUsers();
    }    
    
    // get all the cars in data base
    public static List<Car> getCars(){
        return Car.getAllCars();
    }
    
    // get one spécific user with his login
    public static User getUser(String login){
        return User.getByLogin(login);
    }
    
    // main to test the class
    public static void main(String[] args){
        Collection<Car> cars = getCars();
        for (Car car : cars) {
            System.out.println(car.getDescription());
        }
    }
    
}
