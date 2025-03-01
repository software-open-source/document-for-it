# Overloading và Overriding là gì?

[English below](#english)

Cả **Overloading** (nạp chồng) và **Overriding** (ghi đè) đều là khái niệm cơ bản trong Lập trình hướng đối tượng (OOP), giúp thực hiện **đa hình**. Tuy nhiên, chúng khác biệt đáng kể về cách hoạt động và thời điểm thực thi.

---

### **1. Nạp chồng phương thức (Method Overloading)**

**Nạp chồng phương thức** cho phép một lớp định nghĩa **nhiều phương thức cùng tên**, nhưng khác nhau **danh sách tham số** (dựa vào kiểu, số lượng, hoặc thứ tự của tham số). Đây còn được gọi là **đa hình lúc biên dịch** (*Compile-Time Polymorphism*), vì quyết định gọi phương thức nào sẽ được thực hiện trong **thời gian biên dịch**.

### **Đặc điểm của Nạp chồng:**
- Các phương thức được nạp chồng phải:
  - Có cùng **tên**.
  - Khác nhau về **số lượng, kiểu dữ liệu, hoặc thứ tự của tham số**.
- Nạp chồng có thể thực hiện bên trong **cùng một lớp**.
- Xác định tại thời điểm **biên dịch** (*compile-time*).

---

#### **Ví dụ về Nạp chồng phương thức**
```java
class MathOperations {
    // Nạp chồng phương thức: 2 tham số kiểu int
    public int add(int a, int b) {
        return a + b;
    }

    // Nạp chồng phương thức: 2 tham số kiểu double
    public double add(double a, double b) {
        return a + b;
    }

    // Nạp chồng phương thức: 3 tham số kiểu int
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println("Tổng của 2 số nguyên: " + math.add(5, 10)); // Sử dụng add(int, int)
        System.out.println("Tổng của 2 số thực: " + math.add(5.5, 6.5)); // Sử dụng add(double, double)
        System.out.println("Tổng của 3 số nguyên: " + math.add(1, 2, 3)); // Sử dụng add(int, int, int)
    }
}
```

---

### **2. Ghi đè phương thức (Method Overriding)**

**Ghi đè phương thức** xảy ra khi một **lớp con** định nghĩa lại một phương thức mà **lớp cha** đã cung cấp. Điều này cho phép lớp con triển khai phiên bản riêng của phương thức. Đây còn được gọi là **đa hình lúc chạy** (*Run-Time Polymorphism*), vì quyết định sử dụng phiên bản phương thức nào được thực hiện trong **thời gian chạy**.

### **Đặc điểm của Ghi đè:**
- Phương thức trong lớp con phải:
  - Có cùng **tên**, **danh sách tham số**, và **kiểu trả về** như phương thức trong lớp cha.
  - Có thể có thêm chú thích `@Override` (khuyến nghị để tăng rõ ràng).
- Xác định tại **thời gian chạy** (*runtime*).
- Phương thức bị ghi đè trong lớp con phải **kế thừa** phương thức từ lớp cha.
- Mức độ truy cập của phương thức ghi đè không được **thu hẹp hơn** so với phương thức gốc trong lớp cha.

---

#### **Ví dụ về Ghi đè phương thức**
```java
class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.sound(); // Output: Woof Woof!

        myAnimal = new Cat();
        myAnimal.sound(); // Output: Meow Meow!
    }
}
```

---

### **3. So sánh Nạp chồng và Ghi đè**

| **Khía cạnh**            | **Nạp chồng (Overloading)**                                                                         | **Ghi đè (Overriding)**                                                                         |
|-------------------------|----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| **Định nghĩa**          | Tạo nhiều phương thức có **cùng tên** nhưng khác về danh sách tham số trong cùng một lớp.           | Định nghĩa một phương thức mới trong lớp con để **ghi đè** phương thức từ lớp cha.             |
| **Loại đa hình**         | **Đa hình lúc biên dịch** (*Compile-Time Polymorphism*).                                            | **Đa hình lúc chạy** (*Run-Time Polymorphism*).                                                |
| **Số lượng lớp**         | Có thể xảy ra trong **một lớp** hoặc giữa lớp cha và lớp con.                                       | Cần **ít nhất một lớp cha và một lớp con** để ghi đè.                                           |
| **Thay đổi tham số**     | Tham số **phải khác nhau**: số lượng, kiểu dữ liệu, hoặc thứ tự.                                    | Tham số **phải giống hệt** phương thức trong lớp cha.                                           |
| **Kiểu trả về**          | Có thể khác nhau (nếu danh sách tham số khác nhau).                                                | Phải **giống nhau** hoặc là dạng kế thừa (*covariant return type*).                           |
| **@Override Annotation** | Không cần áp dụng `@Override`.                                                                      | Nên sử dụng `@Override` để tăng rõ ràng và tránh lỗi không mong muốn.                          |
| **Truy cập Modifier**    | Không có ràng buộc về quyền truy cập.                                                              | Không thể **giảm bớt quyền truy cập** (ví dụ, `public` không thể trở thành `protected`).       |

---

### **4. Ví dụ minh họa Nạp chồng và Ghi đè**

#### **Ví dụ Nạp chồng**
```java
class Shape {
    // Nạp chồng phương thức tính diện tích
    public double area(double radius) { // Hình tròn
        return 3.14 * radius * radius;
    }

    public int area(int length, int breadth) { // Hình chữ nhật
        return length * breadth;
    }

    public double area(double base, double height) { // Hình tam giác
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Diện tích hình tròn: " + shape.area(7)); // Hình tròn
        System.out.println("Diện tích hình chữ nhật: " + shape.area(5, 10)); // Hình chữ nhật
        System.out.println("Diện tích hình tam giác: " + shape.area(6.0, 8.0)); // Hình tam giác
    }
}
```

#### **Ví dụ Ghi đè**
```java
class Bank {
    public double getInterestRate() {
        return 2.0; // Lãi suất mặc định
    }
}

class HSBC extends Bank {
    @Override
    public double getInterestRate() {
        return 3.5; // HSBC cung cấp lãi suất 3.5%
    }
}

class Citibank extends Bank {
    @Override
    public double getInterestRate() {
        return 4.0; // Citibank cung cấp lãi suất 4.0%
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank;

        bank = new HSBC();
        System.out.println("Lãi suất HSBC: " + bank.getInterestRate()); // Output sẽ là 3.5

        bank = new Citibank();
        System.out.println("Lãi suất Citibank: " + bank.getInterestRate()); // Output sẽ là 4.0
    }
}
```

---

### **Tóm lược**

- **Nạp chồng phương thức** xảy ra khi nhiều phương thức có **cùng tên**, nhưng khác danh sách tham số. Đây là một kỹ thuật **đa hình lúc biên dịch**.
- **Ghi đè phương thức** xảy ra khi một lớp con **định nghĩa lại** một phương thức từ lớp cha. Đây là một kỹ thuật **đa hình lúc chạy**.
- Cả hai khái niệm đều quan trọng trong lập trình hướng đối tượng, giúp tăng tính linh hoạt, khả năng mở rộng, và dễ bảo trì của hệ thống.

---
# English:

# What are Overloading and Overriding?

Both **Overloading** and **Overriding** are fundamental concepts in Object-Oriented Programming (OOP) that enable **polymorphism**. However, they differ significantly in how and when they function.

---

### **1. Method Overloading**

Method Overloading allows a class to have **multiple methods** with the **same name** but with **different parameter lists** (either by type, number, or order of parameters). This is also known as **Compile-Time Polymorphism**, as the decision of which method to call is made during **compilation**.

### **Characteristics of Overloading**:
- Overloaded methods must:
  - Have the **same name**.
  - Differ in the **number, type, or order** of parameters.
- Overloading can occur within the **same class** (or its parent class).
- It is determined at **compile-time**.

---

#### **Example of Method Overloading**
```java
class MathOperations {
    // Overloaded method: 2 integer parameters
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method: 2 double parameters
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method: 3 integer parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println("Sum of 2 integers: " + math.add(5, 10)); // Uses add(int, int)
        System.out.println("Sum of 2 doubles: " + math.add(5.5, 6.5)); // Uses add(double, double)
        System.out.println("Sum of 3 integers: " + math.add(1, 2, 3)); // Uses add(int, int, int)
    }
}
```

---

### **2. Method Overriding**

Method Overriding occurs when a **subclass** provides a **specific implementation** for a method that is already defined in its **parent class**. This allows the subclass to define its own version of the method and is also known as **Run-Time Polymorphism**, as the decision of which method to call is made at **runtime**.

### **Characteristics of Overriding**:
- The method in the subclass must:
  - Have the **same name**, **parameters**, and **return type** as the parent class method.
  - Be defined with the `@Override` annotation (optional but highly recommended).
- Overriding is determined at **runtime**.
- The overridden method in the subclass must **inherit** the method from the parent class.
- Visibility in the overriding method cannot be more restrictive compared to the parent class.

---

#### **Example of Method Overriding**
```java
class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.sound(); // Output: Woof Woof!

        myAnimal = new Cat();
        myAnimal.sound(); // Output: Meow Meow!
    }
}
```

---

### **3. Differences Between Overloading and Overriding**

| **Aspect**            | **Overloading**                                                                                      | **Overriding**                                                                                      |
|------------------------|-----------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Definition**         | Creating multiple methods with the **same name**, but different parameters.                         | Defining a new implementation for a method from the **parent class** in a subclass.                |
| **Polymorphism Type**  | **Compile-Time Polymorphism**. Decisions are made at compile-time.                                   | **Run-Time Polymorphism**. Decisions are made at runtime based on the object type.                 |
| **Number of Classes**  | Can occur within the **same class** or between a parent and child class.                             | Requires **at least one superclass and one subclass**.                                             |
| **Parameter Changes**  | Parameters **must differ**: number, type, or order.                                                 | Parameters **must remain exactly the same** as the method in the parent class.                     |
| **Return Type**        | Can have **different return types**, as long as parameter lists differ.                             | Must have the **same return type** (or a covariant return type).                                    |
| **Annotation (@Override)** | Not applicable or required.                                                                        | Should annotate the overridden method with `@Override` (recommended for clarity).                  |
| **Access Modifier**    | No such restriction; independent of parent-child relationship.                                       | The overridden method cannot **reduce visibility** (e.g., `public` cannot become `protected`).      |

---

### **4. Examples Highlighting Overloading vs Overriding**

#### **Overloading Example**
```java
class Shape {
    // Overloading Area calculation
    public double area(double radius) { // Circle
        return 3.14 * radius * radius;
    }

    public int area(int length, int breadth) { // Rectangle
        return length * breadth;
    }

    public double area(double base, double height) { // Triangle
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Area of Circle: " + shape.area(7)); // Circle
        System.out.println("Area of Rectangle: " + shape.area(5, 10)); // Rectangle
        System.out.println("Area of Triangle: " + shape.area(6.0, 8.0)); // Triangle
    }
}
```

#### **Overriding Example**
```java
class Bank {
    public double getInterestRate() {
        return 2.0; // Default interest rate
    }
}

class HSBC extends Bank {
    @Override
    public double getInterestRate() {
        return 3.5; // HSBC provides 3.5% interest
    }
}

class Citibank extends Bank {
    @Override
    public double getInterestRate() {
        return 4.0; // Citibank provides 4.0% interest
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank;

        bank = new HSBC();
        System.out.println("HSBC Interest Rate: " + bank.getInterestRate()); // Output will be 3.5

        bank = new Citibank();
        System.out.println("Citibank Interest Rate: " + bank.getInterestRate()); // Output will be 4.0
    }
}
```

---

### **Summary**

- **Overloading** is about having the **same method name** with **different parameter lists** in the same or related classes. It's determined at **compile-time**.
- **Overriding** occurs when a subclass provides a **specific implementation** for a method already defined in a superclass. It's determined at **runtime**.
- These two concepts are crucial parts of polymorphism and enable flexibility, scalability, and clarity in OOP designs.
