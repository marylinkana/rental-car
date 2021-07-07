/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Car;
import Entities.Rent;
import Entities.Duration;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author kanab
 */
public class Rental {

    public static void newRent(String immatriculation, String login, LocalDate start, LocalDate end) {
        Duration duration = new Duration(start, end);
        Rent newRent = new Rent(immatriculation, login, duration.getIdduration());
    }
    
    public static List<Car> getAllCars() {
        return Car.getAllCars();
    }
    
    public static void main(String[] args){
        
    }
    
}
