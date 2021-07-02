package Models;

public class IndividualMember extends User {

    private String userLevel;

    private double discountLevel;

    public IndividualMember(String userLevel, double discountLevel,User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = userLevel;
        this.discountLevel = discountLevel;
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
