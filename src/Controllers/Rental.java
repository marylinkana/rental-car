/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Car;
import Entities.Rent;
import Entities.Duration;
import Entities.User;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author kanab
 */
public class Rental {

    /**
     * create new rental
     * @param immatriculation
     * @param login
     * @param start
     * @param end
     * @param coust
     */
    public static void newRent(String immatriculation, String login, LocalDate start, LocalDate end, Double coust) {
        Duration duration = new Duration(start, end);
        Rent rent = new Rent(immatriculation, login, Duration.getLastDurationId(), coust);
    }
    
    /**
     * get the list of all the car s in data base
     * @return 
     */
    public static List<Car> getAllCars() {
        return Car.getAllCars();
    }
    
    /** 
     * calcul and return the total prise of the rental
     * @param user
     * @param car
     * @param duration
     * @return 
     */
    public static double totalCost(User user, Car car, int duration){
        Double initCoust = car.getPriceperday() * duration;
        Double discountCar = initCoust * car.getDiscount();
        Double coustAfterDiscountCar = initCoust - discountCar;
        Double discountUser = coustAfterDiscountCar * user.getDiscountlevel();
        Double finalCost = coustAfterDiscountCar - discountUser;
        return finalCost;
    }
    
    public static void main(String[] args){
        newRent("1234567", "test", LocalDate.now(), LocalDate.of(2021, 07, 10), 7845.8);
    }
    
}
