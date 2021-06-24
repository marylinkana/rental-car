/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kanab
 */
@Entity
@Table(name = "rent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r")
    , @NamedQuery(name = "Rent.findByImmatriculation", query = "SELECT r FROM Rent r WHERE r.rentPK.immatriculation = :immatriculation")
    , @NamedQuery(name = "Rent.findByLogin", query = "SELECT r FROM Rent r WHERE r.rentPK.login = :login")
    , @NamedQuery(name = "Rent.findByIdduration", query = "SELECT r FROM Rent r WHERE r.rentPK.idduration = :idduration")})
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RentPK rentPK;
    @JoinColumn(name = "idduration", referencedColumnName = "idduration", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Duration duration;
    @JoinColumn(name = "login", referencedColumnName = "login", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "immatriculation", referencedColumnName = "immatriculation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;

    public Rent() {
    }

    public Rent(RentPK rentPK) {
        this.rentPK = rentPK;
    }

    public Rent(String immatriculation, String login, short idduration) {
        this.rentPK = new RentPK(immatriculation, login, idduration);
    }

    public RentPK getRentPK() {
        return rentPK;
    }

    public void setRentPK(RentPK rentPK) {
        this.rentPK = rentPK;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentPK != null ? rentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.rentPK == null && other.rentPK != null) || (this.rentPK != null && !this.rentPK.equals(other.rentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DATA.Rent[ rentPK=" + rentPK + " ]";
    }
    
}
