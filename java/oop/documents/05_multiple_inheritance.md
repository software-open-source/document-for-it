# Đa kế thừa

[English below](#english)

**Đa kế thừa (Multiple Inheritance)** là một tính năng trong lập trình hướng đối tượng (OOP) cho phép một lớp con (child class) kế thừa từ **hai hoặc nhiều lớp cha (parent classes)** cùng một lúc. Điều này nghĩa là lớp con có thể thừa hưởng các thuộc tính (attributes) và phương thức (methods) từ nhiều lớp cha.

---

### **Lợi ích của đa kế thừa**

- **Tăng khả năng tái sử dụng mã (Code Reusability):** Lớp con có thể kết hợp và sử dụng trực tiếp các thuộc tính và hành vi của nhiều lớp cha.
- **Tính linh hoạt:** Giúp mô hình hóa thế giới thực một cách chi tiết hơn bằng cách tận dụng đặc điểm của nhiều lớp cha.

---

### **Vấn đề khi sử dụng đa kế thừa**

Mặc dù đa kế thừa mang lại nhiều lợi ích, nó cũng tiềm ẩn **nhược điểm lớn**, trong đó phổ biến nhất là **Diamond Problem.**

#### **Diamond Problem:**

Khi lớp con kế thừa từ hai lớp cha có cùng một phương thức (method), trình biên dịch sẽ không biết sử dụng phương thức nào vì có sự **xung đột**. Điều này gây khó khăn trong việc quản lý sự nhất quán của mã nguồn.

Ví dụ:

```java
class A {
    void display() {
        System.out.println("Class A");
    }
}

class B {
    void display() {
        System.out.println("Class B");
    }
}

// Nếu một class C kế thừa A và B, sẽ xảy ra mâu thuẫn vì display() được định nghĩa trong cả A và B.
class C extends A, B { 
    // Đây là cách đa kế thừa không được hỗ trợ trực tiếp trong Java
}
```

Trong tình huống trên, trình biên dịch sẽ không thể quyết định **phương thức `display()`** nào sẽ được gọi từ lớp C.

---

### **Ngôn ngữ Java hỗ trợ đa kế thừa như thế nào?**

Java **không hỗ trợ đa kế thừa thông qua lớp (class)** để tránh **Diamond Problem.** Tuy nhiên, Java hỗ trợ đa kế thừa thông qua **interfaces**, một giải pháp giúp đạt được sự mở rộng nhưng không gây ra xung đột trong hệ thống.

---

### **Đa kế thừa thông qua `interface` trong Java**

Một **interface** chỉ định tập hợp các phương thức trừu tượng (abstract methods) mà lớp con cần triển khai. Khi sử dụng interface, lớp con có thể kế thừa nhiều interface mà không gặp vấn đề về xung đột.

#### **Ví dụ 1: [Đa kế thừa qua interfaces](../practice/05-multiple-inheritance/)**

```java
// Interface 1
interface Animal {
    void eat(); // abstract method
}

// Interface 2
interface Pet {
    void play(); // abstract method
}

// Lớp con kế thừa từ cả hai interface
class Dog implements Animal, Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}

// Class chứa hàm main
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();  // Output: Dog is eating.
        myDog.play(); // Output: Dog is playing.
    }
}
```

---

#### **Ví dụ 2: Giải quyết phương thức có cùng tên**

Nếu các interface có các phương thức trùng tên, lớp con phải **cung cấp một phiên bản cụ thể** cho phương thức đó.

```java
// Interface A
interface A {
    void display();
}

// Interface B
interface B {
    void display();
}

// Lớp con triển khai cả hai interface
class C implements A, B {
    @Override
    public void display() {
        System.out.println("This is implementation of display method.");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.display(); // Output: This is implementation of display method.
    }
}
```

Trong trường hợp này, Java cho phép lớp con tự định nghĩa lại phương thức `display()` để tránh xung đột.

---

### **Sự khác biệt giữa kế thừa qua class và interface trong Java**

1. **Kế thừa qua class:**

   - Java hỗ trợ **kế thừa đơn (single inheritance)**, nghĩa là một lớp chỉ có thể kế thừa từ một lớp cha.
   - Sử dụng từ khóa `extends`.

   ```java
   class A {
       void greet() {
           System.out.println("Hello from A");
       }
   }

   class B extends A {
       void greetAgain() {
           System.out.println("Hello again!");
       }
   }
   ```
2. **Kế thừa qua interface:**

   - Một lớp có thể **triển khai nhiều interface**.
   - Sử dụng từ khóa `implements`.

   ```java
   interface A {
       void sayHello();
   }

   interface B {
       void sayGoodbye();
   }

   class C implements A, B {
       public void sayHello() {
           System.out.println("Hello!");
       }

       public void sayGoodbye() {
           System.out.println("Goodbye!");
       }
   }
   ```

---

### **Lợi ích của việc sử dụng interface trong đa kế thừa**

- **Giải quyết Diamond Problem:** Interface chỉ chứa phương thức trừu tượng, nên không gây xung đột khi triển khai.
- **Tính linh hoạt hơn:** Một lớp có thể triển khai nhiều interface mà không bị ràng buộc về mặt kế thừa.
- **Dễ dàng mở rộng:** Interface giúp chia nhỏ các chức năng và làm tăng tính mô-đun cho mã nguồn.

---

### **Tóm lại:**

- **Đa kế thừa qua lớp không được hỗ trợ trong Java** do vấn đề Diamond Problem.
- **Đa kế thừa thông qua interface** được hỗ trợ như một giải pháp thay thế, giúp tận dụng các lợi ích của đa kế thừa mà không gây ra xung đột.
- Java sử dụng mô hình này để mang lại sự cân bằng giữa tính linh hoạt của đa kế thừa và sự an toàn, nhất quán trong mã nguồn.

---
# English:

# Multiple Inheritance

**Multiple inheritance** is a feature in Object-Oriented Programming (OOP) that allows a **child class (subclass)** to inherit from **two or more parent classes** simultaneously. This means the child class can inherit the attributes (properties) and behaviors (methods) from multiple parent classes.

---

### **Benefits of Multiple Inheritance**
- **Improved Code Reusability:** A child class can combine and directly reuse the attributes and behaviors of multiple parent classes.
- **Flexibility:** It allows developers to model real-world scenarios in more detail by combining characteristics from multiple parent classes.

---

### **Problems with Multiple Inheritance**

While multiple inheritance has its benefits, it also introduces certain challenges, with the **"Diamond Problem"** being one of the most common issues.

#### **The Diamond Problem:**
When a child class inherits from two parent classes that have the same method, the compiler becomes **confused** about which method to use, leading to a conflict. This makes it difficult to manage code consistency.

For example:

```java
class A {
    void display() {
        System.out.println("Class A");
    }
}

class B {
    void display() {
        System.out.println("Class B");
    }
}

// If a class C inherits both A and B, there’s a conflict
// as both A and B have a display() method
class C extends A, B { 
    // Java doesn't allow this type of multiple inheritance
}
```

In the scenario above, the compiler cannot determine which `display()` method (from A or B) to call for class C, thus causing ambiguity.

---

### **How Does Java Support Multiple Inheritance?**

Java **does not support multiple inheritance through classes** in order to avoid **the Diamond Problem.** However, Java **supports multiple inheritance through interfaces** which provides a way to achieve the functionality of multiple inheritance without conflicts.

---

### **Multiple Inheritance Using Interfaces in Java**

An **interface** specifies a collection of abstract methods that a class must implement. By using interfaces, a class can inherit from multiple interfaces without causing conflicts.

#### **Example 1: Multiple Inheritance through Interfaces**
```java
// Interface 1
interface Animal {
    void eat(); // abstract method
}

// Interface 2
interface Pet {
    void play(); // abstract method
}

// Child class inherits from both interfaces
class Dog implements Animal, Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();  // Output: Dog is eating.
        myDog.play(); // Output: Dog is playing.
    }
}
```

---

#### **Example 2: Resolving Methods with the Same Name**
If multiple interfaces have methods with the same name, the child class must **provide a single implementation** of the method to resolve the conflict.

```java
// Interface A
interface A {
    void display();
}

// Interface B
interface B {
    void display();
}

// Child class implements both interfaces
class C implements A, B {
    @Override
    public void display() {
        System.out.println("This is the implementation of the display method.");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.display(); // Output: This is the implementation of the display method.
    }
}
```

In this case, Java allows the child class to define a single `display()` method implementation, resolving the name conflict.

---

### **Difference Between Class Inheritance and Interface Inheritance in Java**

1. **Class Inheritance:**
   - Java supports **single inheritance**, meaning a class can only inherit from one parent class.
   - Uses the keyword `extends`.

   ```java
   class A {
       void greet() {
           System.out.println("Hello from A");
       }
   }

   class B extends A {
       void greetAgain() {
           System.out.println("Hello again!");
       }
   }
   ```

2. **Interface Inheritance:**
   - A class can **implement multiple interfaces** in Java.
   - Uses the keyword `implements`.

   ```java
   interface A {
       void sayHello();
   }

   interface B {
       void sayGoodbye();
   }

   class C implements A, B {
       public void sayHello() {
           System.out.println("Hello!");
       }

       public void sayGoodbye() {
           System.out.println("Goodbye!");
       }
   }
   ```

---

### **Advantages of Using Interface in Multiple Inheritance**

- **Solves the Diamond Problem:** Since interfaces only contain abstract methods, no actual code is inherited, eliminating issues caused by method conflicts.
- **More Flexible:** A class can implement multiple interfaces without being restricted to a single superclass.
- **Easier to Extend:** Interfaces allow the division of functionalities into separate modules, making code more modular and manageable.

---

### **Summary:**
- **Multiple inheritance through classes is not supported in Java** due to the issues like the Diamond Problem.
- Instead, **Java supports multiple inheritance through interfaces**, providing a workaround to achieve the benefits of multiple inheritance without the drawbacks.
- This design in Java ensures a balance between the flexibility of inheritance and the safety and consistency of the code.
