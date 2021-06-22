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
public class Car {
    private String description;
    private String immatriculation;
    private String picture;
    private double pricePerDay;
    private double discount; 

    public Car(String description, String immatriculation, String item, double prices) {
        this.description = description;
        this.immatriculation = immatriculation;
        this.picture = item;
        this.pricePerDay = prices;
    }
    
    public Car(String description, String immatriculation, String item, double prices, double discount) {
        this.description = description;
        this.immatriculation = immatriculation;
        this.picture = item;
        this.discount = discount;
        this.pricePerDay = prices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;

    }
       
}
