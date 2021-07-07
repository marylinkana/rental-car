package Models;

import java.time.LocalDate;

public class User {

    private String name;

    private String adress;

    private String login;

    private String password;

    private int phoneNumber;

    private LocalDate age;

    public User(String name, String adress, String login, String password, int phoneNumber, LocalDate age) {
        this.name = name;
        this.adress = adress;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

}
