# Đa hình là gì?

[English below](#english)

**Đa hình** (Polymorphism) là một trong bốn trụ cột chính của lập trình hướng đối tượng (OOP), bên cạnh **đóng gói (Encapsulation)**, **kế thừa (Inheritance)** và **trừu tượng (Abstraction)**.

**Đa hình** cho phép một đối tượng có thể biểu diễn dưới nhiều hình thái khác nhau. Điều này thường được thực hiện thông qua `kế thừa` hoặc `giao diện` (Interface), nơi các phương thức trong lớp con có thể **ghi đè (override)** hoặc **thực thi (implement)** hành vi của phương thức trong lớp cha dựa trên nhu cầu cụ thể.

---

### **Các dạng đa hình**

1. **Đa hình lúc biên dịch** (*Compile-Time Polymorphism*):
   - Thường đạt được thông qua **nạp chồng phương thức** (*Method Overloading*).
   - Nhiều phương thức có cùng tên nhưng khác nhau về:
     - Số lượng tham số.
     - Kiểu dữ liệu của tham số.

2. **Đa hình lúc chạy** (*Run-Time Polymorphism*):
   - Thường đạt được thông qua **ghi đè phương thức** (*Method Overriding*).
   - Hành vi của đối tượng được quyết định **tại thời điểm chương trình chạy**.

---

### **Ví dụ 1: Đa hình lúc biên dịch (Compile-Time Polymorphism)**

```java
class MathOperations {
    // Nạp chồng phương thức tính tổng
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println("Sum of 2 numbers: " + math.add(1, 2)); // Output: 3
        System.out.println("Sum of 2 decimal numbers: " + math.add(1.5, 2.5)); // Output: 4.0
        System.out.println("Sum of 3 numbers: " + math.add(1, 2, 3)); // Output: 6
    }
}
```

- **Giải thích**: Cùng tên phương thức `add()`, nhưng hành vi phụ thuộc vào kiểu dữ liệu và số lượng tham số.

---

### **Ví dụ 2: Đa hình lúc chạy (Run-Time Polymorphism)**

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.makeSound(); // Output: Woof Woof!

        myAnimal = new Cat();
        myAnimal.makeSound(); // Output: Meow Meow!
    }
}
```

- **Giải thích**: Dựa vào đối tượng cụ thể (`Dog` hoặc `Cat`), phương thức `makeSound()` thực thi hành vi phù hợp.

---

## **Ứng dụng đa hình trong thực tế**

1. **Hệ thống gọi API thanh toán**
   - Các tổ chức tài chính thường có API để xử lý giao dịch (như VISA, MasterCard, PayPal).
   - Một phương thức `processPayment()` được triển khai khác nhau cho từng loại.
   ```java
   interface PaymentProcessor {
       void processPayment(double amount);
   }

   class VisaPayment implements PaymentProcessor {
       @Override
       public void processPayment(double amount) {
           System.out.println("Processing VISA payment of $" + amount);
       }
   }

   class PayPalPayment implements PaymentProcessor {
       @Override
       public void processPayment(double amount) {
           System.out.println("Processing PayPal payment of $" + amount);
       }
   }

   public class Payment {
       public static void main(String[] args) {
           PaymentProcessor payment;

           payment = new VisaPayment();
           payment.processPayment(100.0); // Output: Processing VISA payment of $100.0

           payment = new PayPalPayment();
           payment.processPayment(200.0); // Output: Processing PayPal payment of $200.0
       }
   }
   ```

---

2. **Hệ thống quản lý nhân viên**
   - Đối với công ty có nhiều loại nhân viên: Full-time, Part-time, Freelancer...
   - Phương thức `calculateSalary()` áp dụng tính toán riêng biệt cho từng loại nhân viên.

```java
class Employee {
    public void calculateSalary() {
        System.out.println("Calculating generic salary...");
    }
}

class FullTimeEmployee extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Full-time salary based on fixed monthly rate.");
    }
}

class PartTimeEmployee extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Part-time salary based on hours worked.");
    }
}

class Freelancer extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Freelancer salary based on project completion.");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp;

        emp = new FullTimeEmployee();
        emp.calculateSalary(); // Output: Calculating Full-time salary based on fixed monthly rate.

        emp = new PartTimeEmployee();
        emp.calculateSalary(); // Output: Calculating Part-time salary based on hours worked.

        emp = new Freelancer();
        emp.calculateSalary(); // Output: Calculating Freelancer salary based on project completion.
    }
}
```

---

3. **Hệ thống giao thông vận tải**
   - Các phương tiện như Xe máy, Xe hơi, Xe tải đều có phương thức `move()` nhưng di chuyển theo cách khác nhau.
   ```java
   interface Vehicle {
       void move();
   }

   class Bike implements Vehicle {
       @Override
       public void move() {
           System.out.println("Bike is moving with two wheels.");
       }
   }

   class Car implements Vehicle {
       @Override
       public void move() {
           System.out.println("Car is moving with four wheels.");
       }
   }

   class Truck implements Vehicle {
       @Override
       public void move() {
           System.out.println("Truck is moving with heavy-load capacity.");
       }
   }

   public class Transport {
       public static void main(String[] args) {
           Vehicle vehicle;

           vehicle = new Bike();
           vehicle.move(); // Output: Bike is moving with two wheels.

           vehicle = new Car();
           vehicle.move(); // Output: Car is moving with four wheels.

           vehicle = new Truck();
           vehicle.move(); // Output: Truck is moving with heavy-load capacity.
       }
   }
   ```

---

### **Kết luận**

- **Đa hình** mang lại sự linh hoạt trong lập trình bằng cách cho phép các đối tượng giống nhau có hành vi khác nhau.
- Nó đặc biệt hữu ích trong thực tế để các hệ thống có thể mở rộng mà không làm ảnh hưởng cấu trúc hiện có.
- Hai hình thái chính của đa hình:
  - **Compile-time** (dùng Nạp chồng phương thức - Method Overloading).
  - **Run-time** (dùng Ghi đè phương thức - Method Overriding).

---
# English:

# What is Polymorphism?

Polymorphism is one of the four fundamental principles of Object-Oriented Programming (OOP), alongside **Encapsulation**, **Inheritance**, and **Abstraction**.

**Polymorphism** allows an object to take on many forms. This is typically achieved through `inheritance` or `interfaces`, where methods in a subclass can **override** or **implement** the behavior of methods in the parent class based on specific needs.

---

### **Types of Polymorphism**

1. **Compile-Time Polymorphism**:
   - Achieved through **method overloading**.
   - Multiple methods share the same name but differ in:
     - The number of parameters.
     - The data type of the parameters.

2. **Run-Time Polymorphism**:
   - Achieved through **method overriding**.
   - The behavior of a method is determined **at runtime** depending on the object's actual type.

---

### **Example 1: Compile-Time Polymorphism**

```java
class MathOperations {
    // Method overloading for addition
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println("Sum of 2 numbers: " + math.add(1, 2)); // Output: 3
        System.out.println("Sum of 2 decimal numbers: " + math.add(1.5, 2.5)); // Output: 4.0
        System.out.println("Sum of 3 numbers: " + math.add(1, 2, 3)); // Output: 6
    }
}
```

- **Explanation**: The `add()` method has the same name but behaves differently depending on the number and type of parameters.

---

### **Example 2: Run-Time Polymorphism**

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.makeSound(); // Output: Woof Woof!

        myAnimal = new Cat();
        myAnimal.makeSound(); // Output: Meow Meow!
    }
}
```

- **Explanation**: Depending on the actual object type (`Dog` or `Cat`), the `makeSound()` method executes the appropriate behavior.

---

## **Real-World Applications of Polymorphism**

1. **Payment API Processing**
   - Financial organizations often use APIs to handle transactions (e.g., VISA, MasterCard, PayPal).
   - A single `processPayment()` method can handle different payment types.
   ```java
   interface PaymentProcessor {
       void processPayment(double amount);
   }

   class VisaPayment implements PaymentProcessor {
       @Override
       public void processPayment(double amount) {
           System.out.println("Processing VISA payment of $" + amount);
       }
   }

   class PayPalPayment implements PaymentProcessor {
       @Override
       public void processPayment(double amount) {
           System.out.println("Processing PayPal payment of $" + amount);
       }
   }

   public class Payment {
       public static void main(String[] args) {
           PaymentProcessor payment;

           payment = new VisaPayment();
           payment.processPayment(100.0); // Output: Processing VISA payment of $100.0

           payment = new PayPalPayment();
           payment.processPayment(200.0); // Output: Processing PayPal payment of $200.0
       }
   }
   ```

---

2. **Employee Management System**
   - In a company with multiple types of employees (e.g., full-time, part-time, freelancer), the `calculateSalary()` method can be customized for each employee type.

```java
class Employee {
    public void calculateSalary() {
        System.out.println("Calculating generic salary...");
    }
}

class FullTimeEmployee extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Full-time salary based on fixed monthly rate.");
    }
}

class PartTimeEmployee extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Part-time salary based on hours worked.");
    }
}

class Freelancer extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("Calculating Freelancer salary based on project completion.");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp;

        emp = new FullTimeEmployee();
        emp.calculateSalary(); // Output: Calculating Full-time salary based on fixed monthly rate.

        emp = new PartTimeEmployee();
        emp.calculateSalary(); // Output: Calculating Part-time salary based on hours worked.

        emp = new Freelancer();
        emp.calculateSalary(); // Output: Calculating Freelancer salary based on project completion.
    }
}
```

---

3. **Transportation System**
   - Different types of vehicles (e.g., motorcycles, cars, trucks) have a method `move()`, but the functionality varies according to the specific vehicle type.
   ```java
   interface Vehicle {
       void move();
   }

   class Bike implements Vehicle {
       @Override
       public void move() {
           System.out.println("Bike is moving with two wheels.");
       }
   }

   class Car implements Vehicle {
       @Override
       public void move() {
           System.out.println("Car is moving with four wheels.");
       }
   }

   class Truck implements Vehicle {
       @Override
       public void move() {
           System.out.println("Truck is moving with heavy-load capacity.");
       }
   }

   public class Transport {
       public static void main(String[] args) {
           Vehicle vehicle;

           vehicle = new Bike();
           vehicle.move(); // Output: Bike is moving with two wheels.

           vehicle = new Car();
           vehicle.move(); // Output: Car is moving with four wheels.

           vehicle = new Truck();
           vehicle.move(); // Output: Truck is moving with heavy-load capacity.
       }
   }
   ```

---

### **Conclusion**

- **Polymorphism** provides flexibility in programming by allowing similar objects to behave differently.
- It is particularly useful in real-world scenarios where systems need to scale without disrupting existing structures.
- Two main types of polymorphism:
  - **Compile-time polymorphism** (achieved through method overloading).
  - **Run-time polymorphism** (achieved through method overriding).

