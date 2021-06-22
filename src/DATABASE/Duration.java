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
import java.time.LocalDateTime;

/**
 *
 * @author kanab
 */
@Entity
@Table(name = "duration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duration.findAll", query = "SELECT d FROM Duration d")
    , @NamedQuery(name = "Duration.findByIdduration", query = "SELECT d FROM Duration d WHERE d.idduration = :idduration")
    , @NamedQuery(name = "Duration.findByStart", query = "SELECT d FROM Duration d WHERE d.start = :start")
    , @NamedQuery(name = "Duration.findByEnd", query = "SELECT d FROM Duration d WHERE d.end = :end")})
public class Duration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idduration")
    private int idduration;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duration")
    private Collection<Rent> rentCollection;

    public Duration() {
    }

    public Duration(int idduration) {
        this.idduration = idduration;
    }

    public int getIdduration() {
        return idduration;
    }

    public void setIdduration(int idduration) {
        this.idduration = idduration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
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
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "DATABASE.Duration[ idduration=" + idduration + " ]";
    }
    
}
