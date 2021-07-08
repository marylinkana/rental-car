package Models;

public class NewCustomer extends User {

    private String userLevel;
    private double discountLevel;
    private User user;
    
    public NewCustomer(User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = "NEW CUSTOMER";
        this.discountLevel = 0.0;
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
