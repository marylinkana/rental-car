/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kanab
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
    , @NamedQuery(name = "Car.findByImmatriculation", query = "SELECT c FROM Car c WHERE c.immatriculation = :immatriculation")
    , @NamedQuery(name = "Car.findByDescription", query = "SELECT c FROM Car c WHERE c.description = :description")
    , @NamedQuery(name = "Car.findByPicture", query = "SELECT c FROM Car c WHERE c.picture = :picture")
    , @NamedQuery(name = "Car.findByPriceperday", query = "SELECT c FROM Car c WHERE c.priceperday = :priceperday")
    , @NamedQuery(name = "Car.findByDiscount", query = "SELECT c FROM Car c WHERE c.discount = :discount")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "immatriculation")
    private String immatriculation;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;
    @Column(name = "priceperday")
    private double priceperday;
    @Column(name = "discount")
    private double discount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Collection<Rent> rentCollection;

    public Car() {
    }

    public Car(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public Car(String description, String immatriculation, String item, double prices, double discount) {
        this.description = description;
        this.immatriculation = immatriculation;
        this.picture = item;
        this.discount = discount;
        this.priceperday = prices;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPriceperday() {
        return priceperday;
    }

    public void setPriceperday(double priceperday) {
        this.priceperday = priceperday;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @XmlTransient
    public Collection<Rent> getRentCollection() {
        return rentCollection;
    }

    public void setRentCollection(Collection<Rent> rentCollection) {
        this.rentCollection = rentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (immatriculation != null ? immatriculation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.immatriculation == null && other.immatriculation != null) || (this.immatriculation != null && !this.immatriculation.equals(other.immatriculation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DATABASE.Car[ immatriculation=" + immatriculation + " ]";
    }
    
}
