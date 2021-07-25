/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Controllers.BDSession;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
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
    , @NamedQuery(name = "Rent.findByIdduration", query = "SELECT r FROM Rent r WHERE r.rentPK.idduration = :idduration")
})
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RentPK rentPK;
    @JoinColumn(name = "idduration", referencedColumnName = "idduration", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Duration duration;
    @JoinColumn(name = "login", referencedColumnName = "login", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "immatriculation", referencedColumnName = "immatriculation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;

    public Rent() {
    }

    public Rent(RentPK rentPK) {
        this.rentPK = rentPK;
    }
        
    // create new car and insert it in data base
    public Rent(String immatriculation, String login, int idduration){
        EntityManager em = BDSession.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String sql = "INSERT INTO Rent (immatriculation, login, idduration) VALUES (?, ?, ?)";
    
        Query query = em.createNativeQuery(sql); 
        query.setParameter(1, immatriculation);
        query.setParameter(2, login);
        query.setParameter(3, idduration);
        query.executeUpdate();
        
        tx.commit();
        em.close();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Controllers.Rent[ rentPK=" + rentPK + " ]";
    }
    
}
