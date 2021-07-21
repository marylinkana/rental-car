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

    public static void newRent(String immatriculation, String login, LocalDate start, LocalDate end) {
        Duration duration = new Duration(start, end);
        Rent rent = new Rent(immatriculation, login, Duration.getLastDurationId());
    }
    
    public static List<Car> getAllCars() {
        return Car.getAllCars();
    }
    
    public static double totalCost(User user, Car car, int duration){
        Double initCoust = car.getPriceperday() * duration;
        Double discountCar = initCoust * car.getDiscount();
        Double coustAfterDiscountCar = initCoust - discountCar;
        Double discountUser = coustAfterDiscountCar * user.getDiscountlevel();
        Double finalCost = coustAfterDiscountCar - discountUser;
        return finalCost;
    }
    
    public static void main(String[] args){
        newRent("1234567", "test", LocalDate.now(), LocalDate.of(2021, 07, 10));
    }
    
}
