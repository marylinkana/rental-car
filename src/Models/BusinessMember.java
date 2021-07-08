package Models;

public class BusinessMember extends User {

    private String userLevel;
    private double discountLevel;
    private User user;
    
    public BusinessMember(User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = "BUSINESS MEMBER";
        this.discountLevel = 0.30;
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
