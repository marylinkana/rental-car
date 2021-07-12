package Models;

public class Administrator extends User {

    private String userLevel;

    private double discountLevel;

    private User user;
    
    public Administrator(User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = "ADMINISTRATOR";
        this.discountLevel = 0.20;
        this.user = user;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public double getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(double discountLevel) {
        this.discountLevel = discountLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
