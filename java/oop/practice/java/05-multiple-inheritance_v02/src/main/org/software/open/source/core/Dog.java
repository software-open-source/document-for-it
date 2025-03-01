package main.org.software.open.source.core;

// Lớp con kế thừa từ cả hai interface và Common
class Dog extends Common implements Animal, Pet {

    public Dog(String name, int age) {
        super(name, age);
        // super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
    
}