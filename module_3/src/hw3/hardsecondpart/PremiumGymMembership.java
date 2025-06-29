package hw3.hardsecondpart;

public class PremiumGymMembership extends GymMembership {

    private boolean hasPersonalTrainer;
    private boolean hasSpaAccess;

    public PremiumGymMembership(String memberName, int duration, boolean hasPersonalTrainer, boolean hasSpaAccess) {
        super(memberName, Membership.PREMIUM, duration);
        this.hasPersonalTrainer = hasPersonalTrainer;
        this.hasSpaAccess = hasSpaAccess;
    }

    @Override
    public int calculateFee() {
        int cost = super.calculateFee();
        if(hasPersonalTrainer && hasSpaAccess) {
            cost += 1200;
        } else if (hasPersonalTrainer) {
            cost += 700;
        } else {
            cost += 500;
        }
        return cost;
    }

    @Override
    public void checkSpecialOffers() {
        super.checkSpecialOffers();
        if (hasPersonalTrainer) {
            System.out.println("Offer: 2 free training sessions!");
        }
        if (hasSpaAccess) {
            System.out.println("Offer: 1 month spa access extended!");
        }
    }
}
