package Models;

public class Administrator extends User {

    private String userLevel;

    private double discountLevel;

    private User user;
    
    public Administrator(String userLevel, double discountLevel,User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = userLevel;
        this.discountLevel = discountLevel;
        this.user = user;
    }

    public String getUserLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserLevel(String userLevel) {
    }

    public double getDiscountLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDiscountLevel(double discountLevel) {
    }
}
