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
    private Duration duration;

    public Rental(Customer customer, Car car, Duration duration) {
        this.customer = customer;
        this.car = car;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice() {
        // TODO: prendre en compte la réduction de la voiture et multiplier par la durée de réservation.
    }
         
}
