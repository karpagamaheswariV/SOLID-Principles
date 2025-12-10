// VIOLATION OF SRP (DON'T DELETE – AS PER YOUR REQUEST)
// In this version, one class does EVERYTHING:
// 1. Calculates discount
// 2. Prints bill
// 3. Takes input
//
// class BillService {
//     public void process(double amount) {
//         double discount = amount * 0.10; // calculate discount
//         System.out.println("Amount: Rs " + amount);  // printing
//         System.out.println("Discount: Rs " + discount);
//         System.out.println("Payable: Rs " + (amount - discount));
//     }
// }

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        DiscountCalculator calculator = new DiscountCalculator();
        double discount = calculator.calculateDiscount(amount);

        BillPrinter printer = new BillPrinter();
        printer.printBill(amount, discount);
    }
}

// CORRECT IMPLEMENTATION FOLLOWING SRP

// Class responsible ONLY for calculating discount
class DiscountCalculator {
    public double calculateDiscount(double amount) {
        return amount * 0.10; 
    }
}

// Class responsible ONLY for printing the bill
class BillPrinter {
    public void printBill(double amount, double discount) {
        System.out.println("Amount: Rs " + amount);
        System.out.println("Discount: Rs " + discount);
        System.out.println("Payable: Rs " + (amount - discount));
    }
}
