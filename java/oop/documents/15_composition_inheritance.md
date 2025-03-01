# **Sự khác biệt giữa Composition và Inheritance và khi nào sử dụng mỗi cái**

[English below](#english)

Trong lập trình hướng đối tượng (OOP), **Composition** và **Inheritance** đều là hai khái niệm quan trọng dùng để xây dựng mối quan hệ giữa các đối tượng/lớp. Chúng có mục tiêu tối ưu hóa mã nguồn bằng cách **tái sử dụng** và **mở rộng chức năng** của các lớp. Tuy nhiên, chúng khác nhau về cách thức sử dụng và khả năng ứng dụng.

---

## **1. Composition là gì?**
**Composition (thành phần)** trong lập trình OOP là khi một đối tượng được **tạo từ các đối tượng khác** như là thành phần của nó. Composition thể hiện mối quan hệ **"has-a" (có một)** giữa các lớp. Một lớp sẽ bao gồm một hoặc nhiều đối tượng của các lớp khác như các thành phần của nó.

### **Đặc điểm của Composition:**
- Một lớp **sở hữu** các đối tượng của lớp khác.
- Dễ dàng thay đổi hành vi của đối tượng thông qua các thành phần mà nó chứa.
- Thúc đẩy khái niệm **tái sử dụng mã** và **kết hợp các hành vi**.
- **Giảm sự phụ thuộc** giữa các lớp, giúp code dễ bảo trì hơn.
- **Dynamic behavior**: Bạn có thể thay đổi các thành phần tại runtime (thời gian chạy), mang lại sự linh hoạt.

---

### **Ví dụ về Composition:**
```java
class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    // Composition: Car "has-a" Engine
    private Engine engine;

    // Constructor
    public Car() {
        this.engine = new Engine();
    }

    public void startCar() {
        engine.start(); // Delegating the start action to the engine
        System.out.println("Car is moving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
```

**Output:**
```
Engine started.
Car is moving.
```

**Giải thích:**
- Lớp `Car` "có một" (`has-a`) đối tượng `Engine`.
- Thông qua composition, `Car` không kế thừa các thuộc tính hoặc hành vi của `Engine`, mà sử dụng `Engine` như một thành phần bên trong.

---

## **2. Inheritance là gì?**
**Inheritance (kế thừa)** là khi một lớp con/thứ cấp (subclass) **kế thừa** các thuộc tính và phương thức của một lớp cha/cơ sở (superclass). Inheritance thể hiện mối quan hệ **"is-a" (là một)** giữa các lớp.

### **Đặc điểm của Inheritance:**
- Lớp con kế thừa toàn bộ thuộc tính và phương thức từ lớp cha, nhưng cũng có thể **mở rộng hoặc ghi đè (override)** chúng.
- Thúc đẩy **tái sử dụng mã** ở mức độ cao.
- **Dễ mở rộng** bằng cách xây dựng một hệ thống phân cấp các lớp.
- **Thiếu linh hoạt hơn** so với Composition khi hành vi của lớp cơ sở bị ràng buộc chặt chẽ trong lớp con (strong coupling).
  
> **Lưu ý: Inheritance chỉ nên dùng khi lớp con thực sự là một "phiên bản đặc biệt hơn" của lớp cha.**

---

### **Ví dụ về Inheritance:**
```java
// Superclass
class Vehicle {
    void start() {
        System.out.println("Vehicle started.");
    }
}

// Subclass
class Car extends Vehicle {
    // Car "is-a" Vehicle
    @Override
    void start() {
        super.start(); // Optional: call superclass method
        System.out.println("Car is moving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
```

**Output:**
```
Vehicle started.
Car is moving.
```

**Giải thích:**
- Lớp `Car` kế thừa từ lớp cha `Vehicle`.
- Phương thức `start()` của `Car` ghi đè (override) hành vi của `Vehicle`, nhưng vẫn có thể sử dụng hành vi gốc qua `super.start()`.

---

## **3. So sánh giữa Composition và Inheritance**

| **Tiêu chí**               | **Composition (Has-a)**                                                    | **Inheritance (Is-a)**                                             |
|----------------------------|-----------------------------------------------------------------------------|--------------------------------------------------------------------|
| **Thiết lập quan hệ**      | Thể hiện quan hệ **"has-a"** (một đối tượng chứa đối tượng khác).            | Thể hiện quan hệ **"is-a"** (lớp con là một phiên bản của lớp cha).|
| **Độ linh hoạt**           | Linh hoạt hơn: Có thể thay đổi hành vi thông qua các thành phần bên trong.   | Ít linh hoạt hơn: Lớp con bị ràng buộc với lớp cha.                |
| **Mức độ phụ thuộc (Coupling)**| Ít phụ thuộc hơn giữa các lớp.                                              | Phụ thuộc chặt chẽ hơn giữa lớp con và lớp cha.                    |
| **Thay đổi runtime**       | Có thể thay đổi hoặc thay thế các thành phần tại runtime.                    | Không thể thay đổi hành vi kế thừa tại runtime.                    |
| **Tái sử dụng mã**          | Dễ dàng tái sử dụng chức năng từ các thành phần khác mà không cần kế thừa.   | Phù hợp khi cần sử dụng lại logic viết trong lớp cha.              |
| **Mâu thuẫn tiềm năng**    | Ít xảy ra mâu thuẫn về hành vi giữa các lớp.                                | Dễ bị lỗi khi lớp con ghi đè hành vi của lớp cha không mong muốn.  |
| **Độ sâu phân cấp**         | **Không có phân cấp kế thừa.**                                              | Phân cấp kế thừa có thể rất sâu, gây khó khăn khi bảo trì.         |

---

## **4. Khi nào sử dụng Composition và Inheritance?**

### **Sử dụng Composition khi:**
1. Bạn muốn **tăng tính linh hoạt** trong thiết kế:
   - Bằng cách thay thế hoặc thay đổi các thành phần tại runtime.
2. Lớp cần **kết hợp nhiều hành vi hoặc chức năng** từ các lớp khác.
3. Bạn muốn **giảm sự phụ thuộc** giữa các lớp để dễ bảo trì.
4. Quan hệ giữa các lớp có tính chất **"has-a"**, ví dụ:
   - `Car has-a Engine`.
   - `House has-a Room`.

#### **Ví dụ:**
Nếu bạn cần thay đổi động hành vi của lớp mà không cần thay đổi phân cấp:
```java
class FlyBehavior {
    void fly() {
        System.out.println("Flying...");
    }
}

class Bird {
    private FlyBehavior flyBehavior;

    Bird(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void fly() {
        flyBehavior.fly();
    }
}
```

---

### **Sử dụng Inheritance khi:**
1. **Lớp con là một dạng cụ thể hơn của lớp cha:**
   - Ví dụ: `Car is-a Vehicle`, `Dog is-a Animal`.
2. Bạn muốn **kế thừa logic chung** và viết thêm hành vi chuyên biệt hơn trong các lớp con.
3. Bạn cần tận dụng **đa hình** (Polymorphism) để gọi phương thức của lớp cha thông qua lớp con.
4. Mối quan hệ "is-a" là rõ ràng và không thay đổi trong suốt runtime.

---

## **5. Composition Over Inheritance**
Một nguyên tắc quan trọng trong thiết kế phần mềm là:  
> **"Favor composition over inheritance"**  
(Tạm dịch: Nên sử dụng composition thay vì inheritance khi có thể.)

### **Lý do:**
1. **Giảm độ phức tạp:** Composition tránh việc tạo nên các hệ phân cấp kế thừa phức tạp, dẫn đến khó bảo trì.
2. **Tăng linh hoạt:** Bạn có thể thay đổi hành vi của đối tượng nhờ thay thế các thành phần cụ thể mà không cần chỉnh sửa lớp.
3. **Phù hợp với nguyên tắc OOP:** Composition tuân theo nguyên tắc **"Single Responsibility Principle"** và **"Open-Closed Principle".**

---

## **Tóm tắt**

| **Aspect**                      | **Composition**                                   | **Inheritance**                                |
|----------------------------------|--------------------------------------------------|------------------------------------------------|
| **WHEN TO USE**                  | Use when you want dynamic, flexible behavior.    | Use when there is a clear "is-a" relationship. |
| **EXAMPLES**                     | Car "has-a" Engine, House "has-a" Room.          | Car "is-a" Vehicle, Dog "is-a" Animal.         |
| **DESIGN RULE**                  | Prefer composition for modular and maintainable code. | Use inheritance for hierarchical relationships. |

By understanding **Composition** and **Inheritance**, you can design better object-oriented systems that are easy to **maintain**, **extend**, and **reuse**!

---
# English:

# **Differences Between Composition and Inheritance and When to Use Each**

In object-oriented programming (OOP), **Composition** and **Inheritance** are two essential concepts used to establish relationships between objects/classes. They aim to **optimize code reuse** and improve extensibility. However, they differ in usage and their application in software design.

---

## **1. What is Composition?**
**Composition** in OOP is when an object is **made up of other objects** as its components. Composition represents a **"has-a" relationship** between classes. A class includes one or more objects of other classes as its components.

### **Key Features of Composition:**
- A class **owns** objects of other classes.
- It allows you to easily change the behavior of an object by modifying the components it contains.
- Promotes **code reuse** and **composition of behaviors**.
- **Reduces dependency** between classes, making the code more maintainable.
- **Dynamic behavior**: You can modify the components at runtime, providing greater flexibility.

---

### **Example of Composition:**
```java
class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    // Composition: Car "has-a" Engine
    private Engine engine;

    // Constructor
    public Car() {
        this.engine = new Engine();
    }

    public void startCar() {
        engine.start(); // Delegating the start action to the engine
        System.out.println("Car is moving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
```

**Output:**
```
Engine started.
Car is moving.
```

**Explanation:**
- The `Car` class "has-a" (`has-a`) `Engine` object.
- Using Composition, `Car` does not inherit or extend the properties of `Engine`. Instead, it uses the `Engine` as part of its own implementation.

---

## **2. What is Inheritance?**
**Inheritance** is when a subclass (child class) **inherits** the properties and methods of a superclass (parent class). Inheritance represents a **"is-a" relationship** between classes.

### **Key Features of Inheritance:**
- The child class inherits all the attributes and methods of the parent class but can also **extend or override** them.
- Promotes **code reuse** at a higher level.
- **Easier to extend** by building a hierarchy of classes.
- **Less flexible compared to Composition** because the subclass is tightly coupled with the superclass.

> **Note: Inheritance should only be used when the subclass is truly a "specialized version" of the parent class.**

---

### **Example of Inheritance:**
```java
// Superclass
class Vehicle {
    void start() {
        System.out.println("Vehicle started.");
    }
}

// Subclass
class Car extends Vehicle {
    // Car "is-a" Vehicle
    @Override
    void start() {
        super.start(); // Optional: call superclass method
        System.out.println("Car is moving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
```

**Output:**
```
Vehicle started.
Car is moving.
```

**Explanation:**
- The `Car` class inherits from the parent class `Vehicle`.
- The `Car` class overrides the `start()` method to customize its behavior while still optionally using the original implementation from `Vehicle` via `super.start()`.

---

## **3. Comparison Between Composition and Inheritance**

| **Criteria**               | **Composition (Has-a)**                                                    | **Inheritance (Is-a)**                                             |
|----------------------------|-----------------------------------------------------------------------------|--------------------------------------------------------------------|
| **Relationship**           | Represents a **"has-a" relationship** (one object contains another).        | Represents a **"is-a" relationship** (a subclass is a type of superclass). |
| **Flexibility**            | More flexible: Can change behavior dynamically via the components.          | Less flexible: Subclasses are tightly bound to their parent class. |
| **Coupling**               | Loosely coupled: Reduces dependencies between classes.                      | Tightly coupled: Subclass depends heavily on superclass behavior. |
| **Runtime Behavior**       | Components can be replaced or modified dynamically.                        | Inheritance behavior cannot be changed at runtime.               |
| **Code Reusability**       | Encourages reusing functionality by combining various components.           | Useful when reusing the logic written in the parent class.        |
| **Conflicts**              | Fewer conflicts in behavior among classes.                                  | More prone to errors when subclasses incorrectly override superclass behavior. |
| **Hierarchy Depth**        | No hierarchy or inheritance depth.                                          | Can result in deep hierarchy, which is harder to maintain.        |

---

## **4. When to Use Composition and Inheritance?**

### **Use Composition When:**
1. You want **greater flexibility** in your design:
   - Allow modifying or replacing components at runtime.
2. A class needs to **combine multiple behaviors or functionalities** from other classes.
3. You want to **reduce dependencies** between classes for easier maintenance and scalability.
4. The relationship between classes is a **"has-a" relationship**, for example:
   - `Car has-a Engine`
   - `House has-a Room`.

#### **Example:**
If you need dynamically changeable behavior without altering inheritance:
```java
class FlyBehavior {
    void fly() {
        System.out.println("Flying...");
    }
}

class Bird {
    private FlyBehavior flyBehavior;

    Bird(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void fly() {
        flyBehavior.fly();
    }
}
```

---

### **Use Inheritance When:**
1. **The subclass is a specialized version of the parent class:**
   - Example: `Car is-a Vehicle`, `Dog is-a Animal`.
2. You want to **inherit general behavior** defined in the parent class and specialize it in the subclasses.
3. You need to take advantage of **polymorphism** and execute subclass methods using the parent class reference.
4. The relationship between the classes is a **"is-a" relationship** that does not change over time.

---

## **5. "Composition Over Inheritance" Principle**
An important software design principle is:  
> **"Favor composition over inheritance."**  
This means you should **prefer composition to inheritance** whenever possible.

### **Why Choose Composition Over Inheritance?**
1. **Reduced Complexity:** Composition avoids creating complex and deep inheritance hierarchies, which are hard to maintain.
2. **Better Flexibility:** You can dynamically change object behavior by replacing components, which is not possible with inheritance.
3. **Adherence to OOP Principles:**
   - Composition aligns with the **Single Responsibility Principle** and **Open-Closed Principle**, ensuring better modularity and extensibility.

---

## **Summary**

| **Aspect**                   | **Composition**                                   | **Inheritance**                                |
|-------------------------------|--------------------------------------------------|------------------------------------------------|
| **WHEN TO USE**               | When dynamic, flexible behavior is required.    | When there is a clear "is-a" relationship.    |
| **EXAMPLES**                  | `Car has-a Engine`, `House has-a Room`.          | `Car is-a Vehicle`, `Dog is-a Animal`.        |
| **DESIGN RULE**               | Focus on modular and maintainable design.        | Best for hierarchical relationships.          |

By understanding **Composition** and **Inheritance**, you can make better design decisions in object-oriented programming, ensuring your systems are **maintainable**, **scalable**, and **efficient**!
