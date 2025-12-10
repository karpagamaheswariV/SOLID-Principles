public class Main {
    public static void main(String[] args) {

        // Correct LSP-compliant usage
        FlyableBird sparrow = new Sparrow();
        sparrow.fly();
        sparrow.eat();

        NonFlyableBird penguin = new Penguin();
        penguin.eat();

        // LSP VIOLATION (commented out)
        // Bird bird1 = new Penguin();
        // bird1.fly(); // This would throw UnsupportedOperationException
    }
}

// Base class for all birds
abstract class Bird {
    public abstract void eat();
}

// Flying interface
interface Flyable {
    void fly();
}

// Flying birds
abstract class FlyableBird extends Bird implements Flyable {
    // fly() implemented in subclasses
}

// Non-flying birds
abstract class NonFlyableBird extends Bird {
    // no fly() method
}

// Flying bird example
class Sparrow extends FlyableBird {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
    public void eat() {
        System.out.println("Sparrow is eating");
    }
}

// Non-flying bird example
class Penguin extends NonFlyableBird {
    public void eat() {
        System.out.println("Penguin is eating");
    }
}

/*  
// VIOLATION OF LSP (for reference)
// class Bird {
//     public abstract void fly();
//     public abstract void eat();
// }
//
// class Penguin extends Bird {
//     public void fly() {
//         throw new UnsupportedOperationException("Penguin can't fly");
//     }
//     public void eat() {
//         System.out.println("Penguin is eating");
//     }
// }
//
// In this version, replacing Bird with Penguin causes runtime exception
*/
