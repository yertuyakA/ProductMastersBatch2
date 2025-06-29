package hw3.hardsecondpart;

public class Main {
    public static void main(String[] args) {
        GymMembership gymMembership = new GymMembership("Said", Membership.BASIC, 12);
        PremiumGymMembership premiumGymMembership = new PremiumGymMembership("Osman", 24, true, false);

        System.out.println("Client: " + gymMembership.getMemberName() + " | Total Fee: " + gymMembership.calculateFee());
        gymMembership.checkSpecialOffers();

        System.out.println();

        System.out.println("Client: " + premiumGymMembership.getMemberName() + " | Total Fee: " + premiumGymMembership.calculateFee());
        premiumGymMembership.checkSpecialOffers();
    }
}
