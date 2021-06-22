/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kanab
 */
@Embeddable
public class RentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "immatriculation")
    private String immatriculation;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "idduration")
    private String idduration;

    public RentPK() {
    }

    public RentPK(String immatriculation, String login, String idduration) {
        this.immatriculation = immatriculation;
        this.login = login;
        this.idduration = idduration;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdduration() {
        return idduration;
    }

    public void setIdduration(String idduration) {
        this.idduration = idduration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (immatriculation != null ? immatriculation.hashCode() : 0);
        hash += (login != null ? login.hashCode() : 0);
        hash += (idduration != null ? idduration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentPK)) {
            return false;
        }
        RentPK other = (RentPK) object;
        if ((this.immatriculation == null && other.immatriculation != null) || (this.immatriculation != null && !this.immatriculation.equals(other.immatriculation))) {
            return false;
        }
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        if ((this.idduration == null && other.idduration != null) || (this.idduration != null && !this.idduration.equals(other.idduration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DATABASE.RentPK[ immatriculation=" + immatriculation + ", login=" + login + ", idduration=" + idduration + " ]";
    }
    
}
