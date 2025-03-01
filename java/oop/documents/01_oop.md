# OOP
[English below](#english)

**Lập trình hướng đối tượng (Object-Oriented Programming - OOP)** là một **phương pháp lập trình dựa trên khái niệm "đối tượng" (object)**, là các thực thể trong thế giới thực, và được thiết kế bằng cách kết hợp các dữ liệu (attributes) và hành vi (methods).

OOP được xây dựng xung quanh **bốn đặc tính chính**, bao gồm:

---

### **1. Đặc tính cơ bản của OOP**

- **Tính đóng gói (Encapsulation):**
  - Đóng gói là việc gói gọn dữ liệu (các biến) và các phương thức (hành vi) hoạt động trên dữ liệu đó trong một đơn vị logic gọi là **lớp (class)**.
  - Nó cho phép bảo vệ dữ liệu bên trong đối tượng và kiểm soát cách nó được truy cập hoặc sửa đổi.
  - Access modifiers (`public`, `private`, `protected`) được sử dụng để đảm bảo phạm vi truy cập.
  - Ví dụ:
    ```java
    public class Person {
        private String name; // Dữ liệu được đóng gói
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter
        public String getName() {
            return name;
        }

        // Setter
        public void setName(String name) {
            this.name = name;
        }
    }
    ```

---

- **Tính kế thừa (Inheritance):**
  - Kế thừa cho phép một **lớp con (child class)** thừa hưởng các đặc điểm và hành vi của **lớp cha (parent class)** nhằm tái sử dụng mã nguồn và mở rộng chức năng.
  - Điều này giúp giảm thiểu dư thừa mã và tăng tính **tái sử dụng**.
  - Trong Java, kế thừa được thực hiện bằng từ khóa `extends`.
  - Ví dụ:
    ```java
    class Animal {
        void eat() {
            System.out.println("This animal eats food");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("This dog barks");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.eat();  // Gọi phương thức kế thừa từ Animal
            dog.bark();
        }
    }
    ```

---

- **Tính đa hình (Polymorphism):**
  - Tính đa hình cho phép cùng một phương thức có thể hoạt động khác nhau tùy vào ngữ cảnh. Điều này tăng tính **linh hoạt** và mở rộng mã.
  - Hai dạng đa hình trong Java:
    1. **Đa hình tại thời gian biên dịch (Compile-time Polymorphism)** - Sử dụng **method overloading**.
    2. **Đa hình tại thời gian chạy (Runtime Polymorphism)** - Sử dụng **method overriding**.
  - Ví dụ:
    ```java
    // Runtime Polymorphism
    class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal myDog = new Dog();  // Lớp cha trỏ đến lớp con
            myDog.makeSound();        // Gọi phương thức của Dog
        }
    }
    ```

---

- **Tính trừu tượng (Abstraction):**
  - Trừu tượng liên quan đến việc ẩn đi chi tiết thực thi và chỉ hiển thị phần **quan trọng** hoặc **cần thiết** của đối tượng.
  - Nó được triển khai bằng cách sử dụng:
    1. **Abstract class**
    2. **Interface**
  - Mục đích: Chỉ hiển thị những hành vi cần thiết (phương thức) với các lớp kế thừa và ẩn đi logic thực thi bên trong.
  - Ví dụ:
    ```java
    // Abstract Class
    abstract class Animal {
        abstract void makeSound(); // Phương thức trừu tượng

        void sleep() { // Phương thức bình thường
            System.out.println("This animal sleeps");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal dog = new Dog();
            dog.makeSound(); // Bark
            dog.sleep();     // This animal sleeps
        }
    }
    ```

---

### **2. Các khái niệm chính trong OOP**

- **Class**:

  - Lớp là một "khuôn mẫu" để tạo ra các đối tượng. Nó định nghĩa các thuộc tính (attributes) và phương thức (methods) mà đối tượng sẽ có.
  - Ví dụ:
    ```java
    public class Car {
        String brand;
        int speed;

        void drive() {
            System.out.println("Driving at " + speed + " km/h");
        }
    }
    ```
- **Object**:

  - Đối tượng là một thể hiện (instance) của một class. Nó chứa dữ liệu và các phương thức để thao tác dữ liệu đó.
  - Ví dụ:
    ```java
    public class Main {
        public static void main(String[] args) {
            Car car = new Car(); // Tạo đối tượng Car
            car.brand = "Toyota";
            car.speed = 120;
            car.drive();
        }
    }
    ```
- **Constructor**:

  - Constructor là một loại phương thức đặc biệt dùng để khởi tạo đối tượng.
  - Ví dụ:
    ```java
    public class Person {
        String name;

        // Constructor
        public Person(String name) {
            this.name = name;
        }
    }
    ```

---

### **3. Lợi ích của OOP**

- **Tái sử dụng mã nguồn** nhờ kế thừa.
- **Tính mô đun hóa**, dễ bảo trì và nâng cấp.
- Dễ mở rộng khi thêm các tính năng mới.
- **Bảo vệ dữ liệu** và giảm nguy cơ lỗi bằng đóng gói.
- Dễ dàng mô phỏng các thực thể trong thế giới thực, nâng cao tính **trực quan** của chương trình.

---

### **4. Ví dụ thực tế**

- OOP được sử dụng để phát triển các ứng dụng như:
  - **Ứng dụng Android** (dựa trên Java/Kotlin)
  - Các **hệ thống quản lý** như quản lý tài chính hoặc quản lý sinh viên.
  - **Game 3D** mô phỏng các đối tượng như nhân vật, phương tiện, hoặc môi trường.

OOP là một phương pháp tiếp cận quan trọng được sử dụng rộng rãi trong lập trình hiện đại, đặc biệt với các ngôn ngữ phổ biến như Java, C++, và Python.

---
# English:

# OOP

**Object-Oriented Programming (OOP)** is a **programming paradigm based on the concept of "objects"**, which are real-world entities designed by combining data (attributes) and behavior (methods).

OOP is built around **four key principles**, which include:

---

### **1. Core Principles of OOP**
- **Encapsulation:**
  - Encapsulation is the process of bundling data (variables) and the methods (behavior) that operate on the data into a single logical unit called a **class**.
  - It helps protect the data within the object and controls how it is accessed or modified. 
  - Access modifiers (`public`, `private`, `protected`) are used to control access.
  - Example:
    ```java
    public class Person {
        private String name; // Encapsulated data
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter
        public String getName() {
            return name;
        }

        // Setter
        public void setName(String name) {
            this.name = name;
        }
    }
    ```

---

- **Inheritance:**
  - Inheritance allows a **child class** to acquire the properties and behaviors of a **parent class**, enabling code reuse and structure extensibility.
  - It reduces code duplication and increases **reusability**.
  - In Java, inheritance is implemented using the `extends` keyword.
  - Example:
    ```java
    class Animal {
        void eat() {
            System.out.println("This animal eats food");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("This dog barks");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.eat();  // Call inherited method from Animal
            dog.bark();
        }
    }
    ```

---

- **Polymorphism:**
  - Polymorphism allows the same method to perform differently depending on the context. This increases **flexibility** and extensibility.
  - Two types of polymorphism in Java:
    1. **Compile-time Polymorphism** - Achieved using **method overloading**.
    2. **Runtime Polymorphism** - Achieved using **method overriding**.
  - Example:
    ```java
    // Runtime Polymorphism
    class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal myDog = new Dog();  // Parent class reference pointing to child class
            myDog.makeSound();        // Call Dog's overridden method
        }
    }
    ```

---

- **Abstraction:**
  - Abstraction is about hiding the implementation details and only exposing the **essential** or **necessary** features of an object.
  - It is implemented using:
    1. **Abstract classes**
    2. **Interfaces**
  - Purpose: Expose only necessary behavior (methods) to derived classes while hiding the internal implementation logic.
  - Example:
    ```java
    // Abstract Class
    abstract class Animal {
        abstract void makeSound(); // Abstract method

        void sleep() { // Regular method
            System.out.println("This animal sleeps");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal dog = new Dog();
            dog.makeSound(); // Bark
            dog.sleep();     // This animal sleeps
        }
    }
    ```

---

### **2. Key Concepts of OOP**
- **Class:**
  - A class is a "blueprint" for creating objects. It defines the attributes (properties) and methods (behavior) that an object will have.
  - Example:
    ```java
    public class Car {
        String brand;
        int speed;

        void drive() {
            System.out.println("Driving at " + speed + " km/h");
        }
    }
    ```

- **Object:**
  - An object is an instance of a class. It contains data and methods to manipulate that data.
  - Example:
    ```java
    public class Main {
        public static void main(String[] args) {
            Car car = new Car(); // Create a Car object
            car.brand = "Toyota";
            car.speed = 120;
            car.drive();
        }
    }
    ```

- **Constructor:**
  - A constructor is a special method used to initialize an object.
  - Example:
    ```java
    public class Person {
        String name;

        // Constructor
        public Person(String name) {
            this.name = name;
        }
    }
    ```

---

### **3. Benefits of OOP**
- **Code Reusability** through inheritance.
- **Modularity**, making it easier to maintain and upgrade.
- Easy extensibility when adding new features.
- **Data Protection** and reduced risk of errors through encapsulation.
- Easy to simulate real-world entities, improving **program clarity**.

---

### **4. Real-world Examples**
- OOP is commonly used to develop applications such as:
  - **Android applications** (using Java/Kotlin)
  - **Management systems**, e.g., finance or student management.
  - **3D games**, simulating objects like characters, vehicles, or environments.

OOP is an important approach that is widely used in modern programming, particularly in popular languages like Java, C++, and Python.
