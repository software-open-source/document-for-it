# Kế thừa (Inheritance)

[English below](#english)

Kế thừa (**Inheritance**) là một trong những đặc tính quan trọng của lập trình hướng đối tượng (OOP), cho phép **lớp con (child class)** kế thừa các thuộc tính (attributes) và phương thức (methods) của **lớp cha (parent class).** Điều này giúp:

- **Tái sử dụng mã nguồn**: Giảm sự trùng lặp mã trong chương trình bằng cách sử dụng lại những gì đã được định nghĩa trong lớp cha.
- **Mở rộng chức năng**: Lớp con có thể **mở rộng** hoặc **tuỳ chỉnh** các thuộc tính và hành vi của lớp cha.
- **Dễ bảo trì**: Trong trường hợp sửa đổi hoặc thêm mới, chỉ cần thay đổi trong lớp cha mà không cần sửa đổi tất cả các lớp con.

---

### **Từ khóa "extends" trong Java**
Trong Java, kế thừa được triển khai thông qua từ khóa **`extends`**, cho phép một lớp kế thừa từ lớp khác.

---

### **Ví dụ minh họa về kế thừa**

Dưới đây là một ví dụ trong ngôn ngữ Java, minh họa lớp con kế thừa lớp cha:

```java
// Lớp cha (Parent class)
class Animal {
    String name; // Thuộc tính chung cho tất cả các động vật

    // Phương thức
    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
```

```java
// Lớp con (Child class)
class Dog extends Animal { // "Dog" kế thừa từ lớp "Animal"

    // Phương thức riêng của lớp Dog
    void bark() {
        System.out.println(name + " is barking.");
    }
}
```

```java
// Class chính chứa hàm main
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Dog từ lớp Dog
        Dog myDog = new Dog();

        // Sử dụng thuộc tính của lớp cha
        myDog.name = "Buddy";

        // Gọi phương thức từ lớp cha
        myDog.eat();    // Output: Buddy is eating.
        myDog.sleep();  // Output: Buddy is sleeping.

        // Gọi phương thức riêng của lớp con
        myDog.bark();   // Output: Buddy is barking.
    }
}
```

---

### **Kết quả chương trình:**
```
Buddy is eating.
Buddy is sleeping.
Buddy is barking.
```

---

### **Giải thích:**
1. **Lớp cha (Animal):**
   - Đây là lớp tổng quát với các thuộc tính và hành vi chung cho các loài động vật, chẳng hạn như ăn (`eat()`) và ngủ (`sleep()`).

2. **Lớp con (Dog):**
   - Kế thừa các thuộc tính và hành vi từ lớp `Animal`.
   - Đồng thời, lớp `Dog` bổ sung hành vi riêng, ví dụ: `bark()`.

3. **Lợi ích của kế thừa:**
   - Giúp **tái sử dụng mã** từ lớp cha (không cần viết lại `eat()` và `sleep()`).
   - Có thể thêm các tính năng đặc trưng cho lớp cụ thể mà không cần thay đổi lớp cha.

---

### **Các loại kế thừa trong OOP**
1. **Single Inheritance (Kế thừa đơn):**
   - Một lớp con kế thừa từ một lớp cha duy nhất.
   ```java
   class A { }
   class B extends A { }
   ```

2. **Multilevel Inheritance (Kế thừa nhiều cấp):**
   - Một lớp kế thừa từ một lớp đã kế thừa từ lớp khác.
   ```java
   class A { }
   class B extends A { }
   class C extends B { }
   ```

3. **Hierarchical Inheritance (Kế thừa phân cấp):**
   - Nhiều lớp kế thừa từ một lớp cha chung.
   ```java
   class A { }
   class B extends A { }
   class C extends A { }
   ```

4. **Multiple Inheritance (Đa kế thừa):**
   - Java không hỗ trợ kế thừa đa lớp thông qua **lớp cụ thể** (class) nhưng có thể thực hiện thông qua **interface**.

---

### **Lợi ích của kế thừa**
- **Tái sử dụng mã nguồn:** Tránh sự trùng lặp mã cho các thành phần chung.
- **Mở rộng dễ dàng:** Có thể thêm các tính năng mới mà không làm ảnh hưởng tới mã nguồn đã có.
- **Dễ đọc và quản lý mã:** Các hành vi chung được tập trung ở lớp cha và lớp con tập trung vào các chức năng chuyên biệt.
- **Tăng tính linh hoạt:** Dễ dàng mở rộng và triển khai các thay đổi.

---

### **Tóm lại:**
Kế thừa là một khái niệm quan trọng trong OOP, giúp tái sử dụng và tổ chức mã một cách hợp lý, đồng thời cho phép thiết kế hệ thống phần mềm phức tạp dễ dàng hơn.

---
# English:

# Inheritance

**Inheritance** is one of the key features of Object-Oriented Programming (OOP), allowing a **child class (subclass)** to inherit the attributes (properties) and methods (behaviors) of a **parent class (superclass).** This provides several advantages:

- **Code reuse:** Reduces code duplication in the program by reusing what is defined in the parent class.
- **Extend functionality:** The child class can **extend** or **customize** the attributes and behaviors of the parent class.
- **Easy maintenance:** Modifications or new features can be applied in the parent class without needing to modify all child classes.

---

### **The "extends" Keyword in Java**
In Java, inheritance is implemented using the **`extends`** keyword, which enables one class to inherit from another.

---

### **Example of Inheritance**

Here is an example in Java illustrating how a child class can inherit from a parent class:

```java
// Parent Class
class Animal {
    String name; // Common attribute for all animals

    // Methods
    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
```

```java
// Child Class
class Dog extends Animal { // "Dog" inherits from the "Animal" class

    // Method specific to the Dog class
    void bark() {
        System.out.println(name + " is barking.");
    }
}
```

```java
// Main Class containing the main() method
public class Main {
    public static void main(String[] args) {
        // Create an object of Dog (child class)
        Dog myDog = new Dog();

        // Access attributes of the parent class
        myDog.name = "Buddy";

        // Call methods from the parent class
        myDog.eat();    // Output: Buddy is eating.
        myDog.sleep();  // Output: Buddy is sleeping.

        // Call the method specific to the child class
        myDog.bark();   // Output: Buddy is barking.
    }
}
```

---

### **Output of the Program:**
```
Buddy is eating.
Buddy is sleeping.
Buddy is barking.
```

---

### **Explanation:**
1. **Parent Class (Animal):**
   - It is a generalized class with attributes and behaviors common to all animals, such as eating (`eat()`) and sleeping (`sleep()`).

2. **Child Class (Dog):**
   - Inherits the attributes and behaviors from the `Animal` class.
   - Adds its own unique behavior, such as `bark()`.

3. **Advantages of Inheritance:**
   - Enables **code reuse** from the parent class (no need to rewrite `eat()` and `sleep()` methods).
   - Allows adding **unique features** that are specific to subclasses without altering the parent class.

---

### **Types of Inheritance in OOP**
1. **Single Inheritance:**
   - A child class inherits from only one parent class.
   ```java
   class A { }
   class B extends A { }
   ```

2. **Multilevel Inheritance:**
   - A class inherits from another class, which itself inherits from another class.
   ```java
   class A { }
   class B extends A { }
   class C extends B { }
   ```

3. **Hierarchical Inheritance:**
   - Multiple classes inherit from a single parent class.
   ```java
   class A { }
   class B extends A { }
   class C extends A { }
   ```

4. **Multiple Inheritance:**
   - Java does not support multiple inheritance through **classes** but allows it through **interfaces**.

---

### **Benefits of Inheritance**
- **Code reuse:** Reduces code redundancy for common functionality.
- **Ease of extension:** New functionalities can be added without affecting existing code.
- **Improved code readability and management:** Common behaviors are centralized in the parent class, while child classes focus on specific functionalities.
- **Flexibility:** Makes it easy to extend existing systems and apply changes.

---

### **Summary:**
Inheritance is a core concept in OOP that allows for code reuse and organization, making it easier to design and manage large or complex software systems. It acts as a foundation for building relationships between classes, enabling developers to focus on specific, customized implementations while reusing common logic.
