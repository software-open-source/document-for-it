package main.org.software.open.source.core;

/**
 * Đây là ví dụ đa kế thừa phương thức bằng inteface và đơn kế thừa (single inheritance)
 */
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Dog", 10);
        myDog.eat();  // Output: Dog is eating.
        myDog.play(); // Output: Dog is playing.

        System.out.println(myDog.getName());
    }
}