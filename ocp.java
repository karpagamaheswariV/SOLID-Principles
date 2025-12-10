//SOLID Principle
//Open Closed Principle

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double amount = sc.nextDouble();
        String type = sc.next();
        
        DiscountCalculator calculator = new DiscountCalculator();
        discountPolicy policy = null;

        if (type.equals("Flat50")) {
            policy = new Flat50Discount();
        } else if (type.equals("Flat30")) {
            policy = new Flat30Discount();
        } else if (type.equals("Flat10")) {
            policy = new Flat10Discount();
        } else {
            System.out.println("Invalid discount type");
            return;
        }

        double totalDiscount = calculator.calculatediscount(amount, policy);
        System.out.println("Total discount is : " + totalDiscount);
    }
}


/*  
// OLD VERSION (violates SOLID) — kept as you requested
class DiscountCalculator {
    public double calculatediscount(double amount, String discountType){
        if(discountType.equals("Flat50")){
            return 0.5 * amount;
        }
        else if(discountType.equals("Flat30")){
            return 0.3 * amount;
        }
        else if(discountType.equals("Flat10")){
            return 0.15 * amount;
        }
        return 0;
    }
}
*/


// SOLID Version (Open/Closed Principle)
class DiscountCalculator {
    public double calculatediscount(double amount, discountPolicy policy) {
        return policy.discount(amount);
    }
}

interface discountPolicy {
    double discount(double amount);
}

class Flat50Discount implements discountPolicy {
    public double discount(double amount) {
        return 0.5 * amount;
    }
}

class Flat30Discount implements discountPolicy {
    public double discount(double amount) {
        return 0.3 * amount;
    }
}

class Flat10Discount implements discountPolicy {
    public double discount(double amount) {
        return 0.15 * amount;
    }
}
