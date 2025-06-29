package hw3.hardsecondpart;

public class GymMembership {

    private String memberName;
    private Membership membershipType;
    private int duration;

    public GymMembership(String memberName, Membership membershipType, int duration) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.duration = duration;
    }

    public String getMemberName() {
        return memberName;
    }

    public int calculateFee() {
        int cost = 0;
        switch (membershipType) {
            case BASIC:
                cost = duration * 600;
                break;
            case PREMIUM:
                cost = duration * 1000;
                break;
            default:
                System.out.println("No such membership");
                break;
        }
        return cost;
    }

    public void checkSpecialOffers() {
        if (membershipType == Membership.BASIC && duration >= 12) {
            System.out.println("Offer: 1 month free for Basic membership! Client: " + memberName);
        } else if (membershipType == Membership.PREMIUM && duration >= 6) {
            System.out.println("Offer: Free spa session for Premium members! Client: " + memberName);
        } else {
            System.out.println("No special offers available.");
        }
    }
}
