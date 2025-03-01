# **`static class`**

[English below](#english)

Trong Java, **class tĩnh (static class)** **không tồn tại trực tiếp như trong một số ngôn ngữ lập trình khác như C#.** Tuy nhiên, Java cho phép sử dụng **lớp lồng (nested class)** và chỉ định nó là **static**.

---

## **Static Nested Class là gì?**

- Trong Java, một lớp có thể được định nghĩa bên trong một lớp khác. Đây được gọi là **nested class** (lớp lồng).
- Nếu nested class được khai báo với từ khóa **`static`**, nó trở thành một **lớp lồng tĩnh (static nested class)**.
- Ngược lại, một **nested class không có từ khóa `static`** được gọi là **inner class** (lớp bên trong), phụ thuộc vào đối tượng của lớp bên ngoài.

Một **static nested class** không phụ thuộc vào bất kỳ đối tượng nào của lớp bên ngoài (enclosing class), nghĩa là:
- Nó có thể được **khởi tạo** và **sử dụng** mà không cần tạo một đối tượng của lớp bên ngoài.
- `Static nested class` hoạt động tương tự như một lớp độc lập, nhưng nó được bao bọc bởi lớp bên ngoài về mặt không gian tên.

---

## **Đặc điểm của Static Nested Class**
1. Static nested class là **static**, vì vậy nó:
   - Có thể truy cập trực tiếp các **biến tĩnh** và **phương thức tĩnh** của lớp bên ngoài mà không cần tạo đối tượng.
   - Không thể truy cập **biến hoặc phương thức non-static (không tĩnh)** của lớp bên ngoài trực tiếp.
2. Các phương thức và thành viên của static nested class đều có thể độc lập, không cần tham chiếu đến đối tượng của lớp bên ngoài.
3. Thường được sử dụng để nhóm các **logic code liên quan** hoặc **hỗ trợ** lớp bên ngoài.
4. Phạm vi của static nested class được giới hạn bởi lớp bên ngoài.

---

## **Cách Khai Báo và Sử Dụng Static Class (Static Nested Class)**

### **Ví dụ 1: Static Nested Class**
```java
class OuterClass {

    static String staticOuterField = "Static Outer Field";
    String instanceOuterField = "Non-Static Outer Field";

    // Khai báo lớp lồng tĩnh (Static Nested Class)
    static class NestedStaticClass {
        void display() {
            // Có thể truy cập thành viên static của lớp bên ngoài
            System.out.println("Accessing: " + staticOuterField);

            // Không thể truy cập thành viên non-static của lớp bên ngoài (ERROR)
            // System.out.println("Accessing: " + instanceOuterField); // Error
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Không cần tạo đối tượng của OuterClass
        OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
        nested.display();
    }
}
```

**Output**:
```
Accessing: Static Outer Field
```

**Giải thích**:
- Lớp `NestedStaticClass` là một **static nested class** được khai báo bên trong lớp `OuterClass`.
- Vì `NestedStaticClass` là **static**, chúng ta có thể khởi tạo nó trực tiếp thông qua lớp bên ngoài `OuterClass`, sử dụng cú pháp `OuterClass.NestedStaticClass`.
- Static nested class có thể truy cập được các thành viên **static** của lớp bên ngoài (`staticOuterField`) mà không cần tạo đối tượng `OuterClass`.

---

### **Ví dụ 2: Thêm thành viên tĩnh và phương thức trong Static Nested Class**
```java
class Calculator {

    // Static Nested Class
    static class Operations {
        // Phương thức static trong Static Nested Class
        static int add(int a, int b) {
            return a + b;
        }

        static int subtract(int a, int b) {
            return a - b;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Gọi phương thức static trong static nested class
        int sum = Calculator.Operations.add(10, 5);
        int difference = Calculator.Operations.subtract(10, 5);

        System.out.println("Sum: " + sum);           // Output: 15
        System.out.println("Difference: " + difference); // Output: 5
    }
}
```

**Giải thích**:
- `Operations` là một **static nested class** trong lớp `Calculator`.
- Phương thức tĩnh bên trong static nested class (`add` và `subtract`) có thể được gọi trực tiếp thông qua lớp `Operations`, sử dụng cú pháp: `Calculator.Operations.add()`.

---

## **Static Class So với Non-Static Class (Inner Class)**

| **Aspect**                   | **Static Nested Class**                              | **Inner Class (Non-Static Nested Class)**               |
|------------------------------|-----------------------------------------------------|--------------------------------------------------------|
| **Từ khóa `static`**         | Được khai báo với từ khóa **`static`**.             | Không có từ khóa `static`.                             |
| **Cách khởi tạo**            | Có thể khởi tạo **trực tiếp bằng tên lớp bên ngoài**. | Cần tạo đối tượng của lớp bên ngoài trước khi khởi tạo. |
| **Phụ thuộc**                | Phụ thuộc vào lớp bên ngoài nhưng không phụ thuộc vào đối tượng cụ thể. | Phụ thuộc vào đối tượng cụ thể của lớp bên ngoài.       |
| **Truy cập vào thành viên lớp ngoài** | Chỉ có thể truy cập **thành viên tĩnh** của lớp bên ngoài. | Có thể truy cập cả **thành viên tĩnh và không tĩnh**.   |
| **Ứng dụng**                 | Dùng để nhóm các **logic liên quan** hoặc các chức năng độc lập. | Dùng khi cần phối hợp chặt chẽ với đối tượng của lớp ngoài. |

---

### **Ví dụ So sánh Static Nested Class và Inner Class**
```java
class OuterClass {

    String instanceOuterField = "Non-Static Outer Field";

    // Static Nested Class
    static class StaticNested {
        void display() {
            System.out.println("This is a Static Nested Class.");
        }
    }

    // Inner Class
    class InnerClass {
        void display() {
            System.out.println("This is an Inner Class.");
            System.out.println("Accessing: " + instanceOuterField); // Can access non-static members
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Static Nested Class: Directly instantiate without OuterClass object
        OuterClass.StaticNested staticNested = new OuterClass.StaticNested();
        staticNested.display();

        // Inner Class: Requires OuterClass object to instantiate
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
```

**Output:**
```
This is a Static Nested Class.
This is an Inner Class.
Accessing: Non-Static Outer Field
```

**Giải thích**:
1. **Static Nested Class**:
   - Can be instantiated using `OuterClass.StaticNested` because it is independent of any `OuterClass` instance.
2. **Inner Class**:
   - Depends on an `OuterClass` instance, so it is instantiated using `outer.new InnerClass()`.

---

## **Khi nào sử dụng Static Class trong Java?**
### **Ứng dụng Static Nested Class:**
1. **Nhóm logic liên quan:** Static nested class rất hữu ích khi bạn muốn nhóm các logic hoặc chức năng liên quan trực tiếp tới lớp bên ngoài nhưng có thể được sử dụng độc lập.
2. **Tiện ích (Utilities):** Static nested class có thể bao gồm các phương thức static (công cụ như tính toán, xử lý, hoặc hỗ trợ).
3. **Tăng tính tổ chức:** Nếu một lớp chỉ được sử dụng trong phạm vi của lớp ngoài và không cần liên kết với các đối tượng, static nested class là lựa chọn tối ưu.

---

Mặc dù **Java không hỗ trợ class static độc lập**, việc sử dụng **static nested class** cung cấp các tính năng tương tự để xử lý các yêu cầu đặc biệt.

---
# English:

# **`static class`**

In Java, a **static class** does **not exist directly** as in some other programming languages like C#. However, Java allows the use of **nested classes**, and you can declare them as **static**.

---

## **What is a Static Nested Class?**

- In Java, a class can be defined inside another class. This is known as a **nested class**.
- If the nested class is declared with the **`static`** keyword, it becomes a **static nested class**.
- Conversely, a **nested class without the `static` keyword** is referred to as an **inner class**, which depends on an instance of the enclosing class.

A **static nested class** does not depend on the object of the outer class (enclosing class). This means:
- It can be **instantiated** and **used** without requiring an object of the outer class.
- A **static nested class** behaves similarly to a stand-alone class but is logically grouped within the outer class.

---

## **Characteristics of Static Nested Class**
1. A static nested class is declared as **`static`**, so it:
   - Can directly access the **static variables** and **static methods** of the enclosing class without creating an object.
   - **Cannot directly access** the **non-static variables or methods** of the enclosing class.
2. Members (methods and fields) of a static nested class can function independently and do not need a reference to the object of the outer class.
3. It is used to group related **functional code** or to provide **helper functionality** for the outer class.
4. Its scope is limited to the enclosing class.

---

## **How to Declare and Use a Static Class (Static Nested Class)**

### **Example 1: Static Nested Class**
```java
class OuterClass {

    static String staticOuterField = "Static Outer Field";
    String instanceOuterField = "Non-Static Outer Field";

    // Declare a static nested class
    static class NestedStaticClass {
        void display() {
            // Can access static members of the outer class
            System.out.println("Accessing: " + staticOuterField);

            // Cannot access non-static members of the outer class (ERROR)
            // System.out.println("Accessing: " + instanceOuterField); // Error
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // No need to create an object of OuterClass
        OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
        nested.display();
    }
}
```

**Output**:
```
Accessing: Static Outer Field
```

**Explanation**:
- The class `NestedStaticClass` is a **static nested class**, declared inside the `OuterClass`.
- Since `NestedStaticClass` is **static**, we can create an object of it directly via the outer class `OuterClass` using the syntax `OuterClass.NestedStaticClass`.
- The static nested class can access **static fields** of the outer class (`staticOuterField`) without requiring an object of the outer class.

---

### **Example 2: Static Methods and Members inside a Static Nested Class**
```java
class Calculator {

    // Static Nested Class
    static class Operations {
        // Static methods inside a static nested class
        static int add(int a, int b) {
            return a + b;
        }

        static int subtract(int a, int b) {
            return a - b;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Call static methods of the static nested class
        int sum = Calculator.Operations.add(10, 5);
        int difference = Calculator.Operations.subtract(10, 5);

        System.out.println("Sum: " + sum);           // Output: 15
        System.out.println("Difference: " + difference); // Output: 5
    }
}
```

**Explanation**:
- `Operations` is a **static nested class** within the `Calculator` class.
- The static methods (`add` and `subtract`) inside the static nested class can be invoked directly using the outer class and nested class name, like `Calculator.Operations.add()`.

---

## **Static Nested Class vs Inner (Non-Static) Class**

| **Aspect**                 | **Static Nested Class**                                  | **Inner Class (Non-Static Nested Class)**             |
|----------------------------|---------------------------------------------------------|-------------------------------------------------------|
| **`static` Keyword**       | Declared with the keyword **`static`**.                 | No `static` keyword.                                  |
| **How to Instantiate**     | Can be instantiated **directly through the outer class**. | Requires an instance of the outer class for instantiation. |
| **Dependency**             | Depends on the outer class but not on its specific objects. | Fully dependent on an object of the outer class.      |
| **Access to Outer Class Members** | Can only access **static members** of the enclosing class. | Can access both **static and non-static members**.    |
| **Use Case**               | Used for grouping **related logic** or independent functionality. | Used when close coordination with the outer class instance is required.|

---

### **Example Comparison of Static Nested Class and Inner Class**
```java
class OuterClass {

    String instanceOuterField = "Non-Static Outer Field";

    // Static Nested Class
    static class StaticNested {
        void display() {
            System.out.println("This is a Static Nested Class.");
        }
    }

    // Inner Class
    class InnerClass {
        void display() {
            System.out.println("This is an Inner Class.");
            System.out.println("Accessing: " + instanceOuterField); // Can access non-static members
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Static Nested Class: Instantiated without an OuterClass instance
        OuterClass.StaticNested staticNested = new OuterClass.StaticNested();
        staticNested.display();

        // Inner Class: Requires an OuterClass object to instantiate
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
```

**Output:**
```
This is a Static Nested Class.
This is an Inner Class.
Accessing: Non-Static Outer Field
```

**Explanation**:
1. **Static Nested Class**:
   - Instantiated directly using `OuterClass.StaticNested`, as it does not depend on `OuterClass` objects.
2. **Inner Class**:
   - Requires an instance of the outer class (`OuterClass`) because it is tightly coupled to the outer class instance.

---

## **When to Use Static Class in Java?**
### **Applications of Static Nested Class**:
1. **Group Related Logic**: Static nested classes are useful when you want to group code or functionality directly related to the outer class but can also work independently.
2. **Utility Purpose**: Static nested classes often contain static methods (e.g., for calculations or processing tasks).
3. **Organizational Clarity**: If a class is only relevant within the scope of its enclosing class and does not need a tight coupling to outer class instances, use a static nested class.

---

**Conclusion**:
While Java does not support standalone **static classes**, the **static nested class** provides similar functionality. It allows the design of independent and logically grouped components within an outer class, offering flexibility and structure in code organization.
