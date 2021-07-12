package Models;

public class IndividualMember extends User {

    private String userLevel;

    private double discountLevel;

    public IndividualMember(User user) {
        super(user.getName(), user.getAdress(), user.getLogin(), user.getPassword(), user.getPhoneNumber(), user.getAge());
        this.userLevel = "INDIVIDUAL MEMBER";
        this.discountLevel = 0.10;
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

}
