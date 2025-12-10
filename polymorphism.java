//POLYMORPHISM EXAMPLE (Method Overriding)
public class Main {
    public static void main(String[] args) {

        Animal animal1 = new Dog();
        animal1.eat();
        animal1.makeSound();

        Animal animal2 = new Cat();
        animal2.eat();
        animal2.makeSound();
    }
}

class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
    public void makeSound() {
        System.out.println("Animal is making sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("Cat is eating");
    }
    public void makeSound() {
        System.out.println("Meow");
    }
}
