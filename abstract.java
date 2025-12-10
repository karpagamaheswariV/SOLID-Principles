//ABSTRACT CLASS EXAMPLE
public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Car("Jaguar");
        vehicle1.applyBrake();

        Vehicle vehicle2 = new Truck("Mahindra");
        vehicle2.applyBrake();
    }
}

abstract class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void applyBrake();
}

class Truck extends Vehicle {
    Truck(String brand) {
        super(brand);
    }

    public void applyBrake() {
        System.out.println("Applying truck brake.");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    public void applyBrake() {
        System.out.println("Applying car brake!");
    }
}
