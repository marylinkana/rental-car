/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    private Short idduration;
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "end")
    @Temporal(TemporalType.DATE)
    private Date end;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duration")
    private Collection<Rent> rentCollection;

    public Duration() {
    }

    public Duration(Short idduration) {
        this.idduration = idduration;
    }

    public Short getIdduration() {
        return idduration;
    }

    public void setIdduration(Short idduration) {
        this.idduration = idduration;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
        int hash = 0;
        hash += (idduration != null ? idduration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duration)) {
            return false;
        }
        Duration other = (Duration) object;
        if ((this.idduration == null && other.idduration != null) || (this.idduration != null && !this.idduration.equals(other.idduration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controllers.Duration[ idduration=" + idduration + " ]";
    }
    
}
