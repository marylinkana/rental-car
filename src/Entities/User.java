/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Controllers.BDSession;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kanab
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
    , @NamedQuery(name = "User.findByAdress", query = "SELECT u FROM User u WHERE u.adress = :adress")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByPhonenumber", query = "SELECT u FROM User u WHERE u.phonenumber = :phonenumber")
    , @NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age")
    , @NamedQuery(name = "User.findByUserlevel", query = "SELECT u FROM User u WHERE u.userlevel = :userlevel")
    , @NamedQuery(name = "User.findByDiscountlevel", query = "SELECT u FROM User u WHERE u.discountlevel = :discountlevel")
    //, @NamedQuery(name = "User.InsertNewUser", query = "INSERT INTO User (name, adress, login, password, phonenumber, age) VALUES (:name, :adress, :login, :password, :phonenumber, :age)")
})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Column(name = "adress")
    private String adress;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "phonenumber")
    private Integer phonenumber;
    @Column(name = "age")
    @Temporal(TemporalType.DATE)
    private Date age;
    @Column(name = "userlevel")
    private String userlevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discountlevel")
    private Double discountlevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Rent> rentCollection;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public void rent(String immatriculation, Short idduration){
        Rent rent = new Rent(this.login, immatriculation, idduration);
    }

    public static void create(Models.User user) {
        BDSession.getEM().getTransaction().begin();
        Query query = BDSession.getEM().createNativeQuery("User.InsertNewUser", User.class);
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getAdress());
        query.setParameter(3, user.getLogin());
        query.setParameter(4, sha1Encode(user.getPassword()));
        query.setParameter(5, user.getPhoneNumber());
        query.setParameter(6, user.getAge());
        query.executeUpdate();
    }
    
    public static boolean isConnect(String login, String password){
        User personne = BDSession.getEM().find(User.class, login);
        if (personne != null && sha1Encode(password).equals(personne.getPassword().toUpperCase())) {
          System.out.println("Wecomme : " + String.valueOf(personne.name));
          return true;
        }
        return false;
    }
    
    private static String sha1Encode(String password){
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("sha-1");
            msdDigest.update(password.getBytes("utf-8"), 0, password.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println("Entities.User.sha1Encode()");
        }
        return sha1;
    }
    
    public static List<User> getAllUsers(){
        return BDSession.getEM().createNamedQuery("User.findAll").getResultList();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public Double getDiscountlevel() {
        return discountlevel;
    }

    public void setDiscountlevel(Double discountlevel) {
        this.discountlevel = discountlevel;
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
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controllers.User[ login=" + login + " ]";
    }
    
}
