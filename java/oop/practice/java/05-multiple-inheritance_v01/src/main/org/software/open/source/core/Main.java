package main.org.software.open.source.core;
/**
 * Đây là ví dụ đa kế thừa phương thức bằng interface
 * 
 */
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();  // Output: Dog is eating.
        myDog.play(); // Output: Dog is playing.

        System.out.println(myDog.getName());

        Dog myDog2 = new Dog("Dog 2", 10);

        System.out.println(myDog2.getName());
    }
}