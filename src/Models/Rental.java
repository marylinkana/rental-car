/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author kanab
 */
public class Rental {
    private Customer customer;
    private Car car;
    private double rentalPrice;

    public Rental(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice() {
        if(customer instanceof BusinessCustomer){
            this.rentalPrice = this.car.getPrices() + this.car.getPrices() * 0.25;
        }
        else if (customer instanceof IndividualCustomer) {
            this.rentalPrice = this.car.getPrices() + this.car.getPrices() * 0.10;            
        }
        else {
            this.rentalPrice = this.car.getPrices();           
        }
    }
         
}
