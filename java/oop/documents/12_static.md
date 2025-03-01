# **Biến tĩnh (Static Variable) và Phương thức tĩnh (Static Method)**

[English below](#english)

## **1. Biến tĩnh (Static Variable) là gì?**
- **Biến tĩnh** là một biến được khai báo với từ khóa **`static`** trong một lớp.
- Giá trị của biến tĩnh là **dùng chung cho tất cả các đối tượng** của lớp đó. Nó **không phụ thuộc vào từng đối tượng riêng biệt** và được lưu trong bộ nhớ **static memory** (không nằm trong bộ nhớ heap của từng đối tượng).
- Biến tĩnh thuộc về **lớp** (Class) thay vì thuộc về **đối tượng** (Object).

### **Đặc điểm của Biến tĩnh**:
1. **Chỉ tồn tại duy nhất một bản sao (Instance)** của biến này trong bộ nhớ tĩnh dùng chung cho toàn bộ lớp.
2. Biến tĩnh được khởi tạo ngay khi lớp được tải vào bộ nhớ và phá hủy khi chương trình kết thúc.
3. Nó có thể được truy cập trực tiếp thông qua **tên lớp** (không cần khởi tạo đối tượng).

---

### **Ví dụ 1: Biến Tĩnh**
```java
class Counter {
    static int count = 0; // Biến tĩnh

    Counter() {
        count++; // Tăng giá trị biến tĩnh mỗi khi tạo đối tượng
        System.out.println("Count: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // Count: 1
        Counter c2 = new Counter(); // Count: 2
        Counter c3 = new Counter(); // Count: 3

        // Truy cập biến tĩnh thông qua tên lớp
        System.out.println("Final Count: " + Counter.count); // Output: 3
    }
}
```

**Giải thích**:
- Biến tĩnh `count` dùng chung cho tất cả các đối tượng của lớp `Counter`.
- Mỗi lần một đối tượng `Counter` được tạo, biến `count` tăng thêm 1.

---

## **2. Phương thức tĩnh (Static Method)**

**Phương thức tĩnh** là một phương thức được khai báo với từ khóa **`static`**. Phương thức này thuộc về **lớp** thay vì **đối tượng**. Điều này có nghĩa là bạn có thể gọi phương thức tĩnh mà **không cần tạo đối tượng của lớp**.

### **Đặc điểm của Phương thức tĩnh**:
1. Phương thức tĩnh có thể được gọi bằng **tên lớp**, thay vì thông qua đối tượng.
2. Phương thức tĩnh chỉ có thể truy cập:
   - **Biến tĩnh**.
   - Các **phương thức tĩnh khác**.
3. **Không thể** truy cập hoặc sửa đổi biến **non-static (biến thông thường)** của lớp hoặc gọi phương thức **non-static**.
4. Thường được sử dụng để thực hiện các thao tác chung không dựa vào trình trạng cụ thể của đối tượng.

---

### **Ví dụ 2: Phương thức Tĩnh**
```java
class Calculator {

    // Phương thức tĩnh
    public static int add(int a, int b) {
        return a + b;
    }

    // Phương thức thông thường
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Gọi phương thức tĩnh mà không cần đối tượng
        int sum = Calculator.add(5, 10);
        System.out.println("Sum: " + sum); // Output: 15

        // Gọi phương thức thông thường cần khởi tạo đối tượng
        Calculator calc = new Calculator();
        int product = calc.multiply(5, 10);
        System.out.println("Product: " + product); // Output: 50
    }
}
```

**Giải thích**:
- Phương thức tĩnh `add()` có thể được gọi trực tiếp bằng tên lớp `Calculator`, không cần tạo đối tượng.
- Trong khi đó, phương thức non-static `multiply()` yêu cầu tạo một đối tượng của lớp `Calculator` trước khi gọi.

---

## **3. Phân biệt Phương thức tĩnh và Phương thức thông thường**

| **Đặc điểm**                   | **Phương thức tĩnh (Static Method)**                                       | **Phương thức thông thường (Non-Static Method)**               |
|---------------------------------|---------------------------------------------------------------------------|----------------------------------------------------------------|
| **Thuộc về**                   | Thuộc về **lớp**.                                                        | Thuộc về **đối tượng**.                                          |
| **Cách gọi**                   | Có thể gọi **trực tiếp** bằng tên lớp (không cần tạo đối tượng).           | Chỉ có thể gọi thông qua một **đối tượng** của lớp đó.          |
| **Truy cập biến**              | Chỉ có thể truy cập **biến tĩnh (static)**.                                | Có thể truy cập cả **biến tĩnh** và **biến thông thường**.       |
| **Truy cập phương thức khác**  | Chỉ có thể gọi **phương thức tĩnh (static)** khác.                        | Có thể gọi cả **phương thức tĩnh** và **phương thức thông thường**. |
| **Ví dụ sử dụng**              | Sử dụng cho các tác vụ **chung** như: xử lý toán học, tiện ích, logging.    | Dùng cho các tác vụ liên quan đến **dữ liệu cụ thể** của đối tượng. |
| **Sử dụng từ khóa `this`**     | **Không thể** sử dụng từ khóa `this` hoặc `super`.                         | Có thể sử dụng `this` hoặc `super`.                             |

---

### **4. Ví dụ so sánh**
```java
class Example {

    // Biến tĩnh
    static int staticVariable = 10;

    // Biến thông thường
    int nonStaticVariable = 20;

    // Phương thức tĩnh
    public static void staticMethod() {
        System.out.println("This is a static method.");

        // Có thể truy cập biến tĩnh
        System.out.println("Static Variable: " + staticVariable);

        // Không thể truy cập biến thông thường trực tiếp
        // System.out.println("Non-Static Variable: " + nonStaticVariable); // ERROR

        // Không thể gọi phương thức thường
        // nonStaticMethod(); // ERROR
    }

    // Phương thức thông thường
    public void nonStaticMethod() {
        System.out.println("This is a non-static method.");

        // Có thể truy cập cả biến tĩnh và thông thường
        System.out.println("Static Variable: " + staticVariable);
        System.out.println("Non-Static Variable: " + nonStaticVariable);

        // Có thể gọi phương thức tĩnh
        staticMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        // Gọi phương thức tĩnh qua tên lớp
        Example.staticMethod();

        // Gọi phương thức thông thường yêu cầu tạo đối tượng
        Example example = new Example();
        example.nonStaticMethod();
    }
}
```

**Kết quả:**
```
This is a static method.
Static Variable: 10
This is a non-static method.
Static Variable: 10
Non-Static Variable: 20
This is a static method.
Static Variable: 10
```

**Giải thích**:
1. **Phương thức tĩnh (`staticMethod`)**:
   - Được gọi trực tiếp bằng tên lớp `Example.staticMethod()`.
   - Có thể truy cập biến tĩnh nhưng không thể truy cập biến thông thường hoặc các phương thức thông thường.

2. **Phương thức thông thường (`nonStaticMethod`)**:
   - Cần tạo đối tượng `Example` để gọi.
   - Có thể truy cập cả biến tĩnh, biến thông thường, và gọi các phương thức (tĩnh hoặc thông thường).

---

### **5. Ứng dụng của Biến và Phương thức Tĩnh**

#### **Biến tĩnh - Ứng dụng:**
- Lưu các giá trị **toàn cục** hoặc **chung** cho tất cả các đối tượng, như bộ đếm (`counter`), danh sách cấu hình, thông tin thống kê...

#### **Phương thức tĩnh - Ứng dụng:**
- Dùng cho các thao tác **chung** như các hàm tiện ích (ví dụ `Math.sqrt()`), hoặc hàm không liên quan tới trạng thái cụ thể của đối tượng.
- Dùng để xử lý **cấu hình chung** hoặc các phương thức tương tác ở cấp lớp (Class-Level).

---
# English:

# **Static Variables and Static Methods**

## **1. What is a Static Variable?**
- A **static variable** is a variable declared with the keyword **`static`** in a class.
- The value of a static variable is **shared among all objects** of that class. It is independent of individual objects and is stored in the **static memory** (not in the heap memory of each object).
- A static variable belongs to the **class** (Class-Level) rather than to objects (Object-Level).

### **Characteristics of Static Variables**:
1. There is only a **single copy** of the static variable in the program's memory, which is shared across all instances of a class.
2. Static variables are initialized when the class is loaded into memory and are destroyed when the program ends.
3. They can be accessed directly using the **class name** (no need to create an object).

---

### **Example 1: Static Variables**
```java
class Counter {
    static int count = 0; // Static variable

    Counter() {
        count++; // Increment the static variable each time an object is created
        System.out.println("Count: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // Count: 1
        Counter c2 = new Counter(); // Count: 2
        Counter c3 = new Counter(); // Count: 3

        // Access static variable via the class name
        System.out.println("Final Count: " + Counter.count); // Output: 3
    }
}
```

**Explanation**:
- The static variable `count` is shared among all objects of the `Counter` class.
- Every time a `Counter` object is created, the value of `count` increases by 1.

---

## **2. What is a Static Method?**

A **static method** is a method declared with the keyword **`static`**. This method belongs to the **class** instead of individual objects. This means the method can be called **without creating an instance** of the class.

### **Characteristics of Static Methods**:
1. Static methods can be called directly using the **class name**, without creating an object.
2. Static methods can only access:
   - **Static variables**.
   - Other **static methods**.
3. **Cannot** access or modify non-static variables or methods of a class.
4. They are typically used to perform common operations that do not require object state.

---

### **Example 2: Static Methods**
```java
class Calculator {

    // Static Method
    public static int add(int a, int b) {
        return a + b;
    }

    // Regular (Non-Static) Method
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Call static method without creating an object
        int sum = Calculator.add(5, 10);
        System.out.println("Sum: " + sum); // Output: 15

        // Call a non-static method, requires object instantiation
        Calculator calc = new Calculator();
        int product = calc.multiply(5, 10);
        System.out.println("Product: " + product); // Output: 50
    }
}
```

**Explanation**:
- The static method `add()` can be called directly using the class name `Calculator`, without creating an object.
- On the other hand, the non-static method `multiply()` requires the creation of an instance of the `Calculator` class to be called.

---

## **3. Comparison Between Static Methods and Regular Methods**

| **Aspect**                  | **Static Method**                                                         | **Regular (Non-Static) Method**                                 |
|-----------------------------|---------------------------------------------------------------------------|----------------------------------------------------------------|
| **Belongs To**              | Belongs to the **class**.                                                 | Belongs to the **object**.                                      |
| **How to Call**             | Can be called **directly** using the class name (no need to create an object). | Must be called using an **object** of the class.              |
| **Accessing Variables**     | Can only access **static variables**.                                      | Can access both **static variables** and **non-static variables**. |
| **Accessing Other Methods** | Can only call **static methods**.                                          | Can call both **static methods** and **non-static methods**.    |
| **Use of `this` or `super`**| **Cannot** use `this` or `super`.                                          | Can use `this` or `super`.                                      |
| **Use Case**                | Commonly used for **shared operations**, like mathematical calculations or utility methods. | Used for operations that depend on the specific object state. |

---

### **4. Example Highlighting Static and Non-Static Methods**
```java
class Example {

    // Static Variable
    static int staticVariable = 10;

    // Non-Static Variable
    int nonStaticVariable = 20;

    // Static Method
    public static void staticMethod() {
        System.out.println("This is a static method.");

        // Can access static variables
        System.out.println("Static Variable: " + staticVariable);

        // Cannot access non-static variables directly
        // System.out.println("Non-Static Variable: " + nonStaticVariable); // ERROR

        // Cannot call non-static methods
        // nonStaticMethod(); // ERROR
    }

    // Non-Static Method
    public void nonStaticMethod() {
        System.out.println("This is a non-static method.");

        // Can access both static and non-static variables
        System.out.println("Static Variable: " + staticVariable);
        System.out.println("Non-Static Variable: " + nonStaticVariable);

        // Can call a static method
        staticMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        // Static method is called using the class name
        Example.staticMethod();

        // Non-static method requires an object to call
        Example example = new Example();
        example.nonStaticMethod();
    }
}
```

**Output**:
```
This is a static method.
Static Variable: 10
This is a non-static method.
Static Variable: 10
Non-Static Variable: 20
This is a static method.
Static Variable: 10
```

**Explanation**:
1. **Static Method (`staticMethod`)**:
   - Called using the class name `Example.staticMethod()`.
   - Can only access static variables and static methods.
2. **Non-Static Method (`nonStaticMethod`)**:
   - Requires an object (`example`) to be called.
   - Can access both static and non-static variables, and can call both static and non-static methods.

---

### **5. Applications of Static Variables and Methods**

#### **Static Variables - Applications**:
- Used to store **global information or data** shared by all objects. Examples:
  - Counter in a class (`counter`).
  - Configuration settings.
  - Shared statistics or reference data.

#### **Static Methods - Applications**:
- Used for **common utility functions** or operations that are not dependent on specific object states:
  - Mathematical operations (e.g., `Math.sqrt()`).
  - Logging.
  - General-purpose methods like validation, formatting, or conversions.

--- 

In conclusion, **static variables** and **static methods** are essential when working with shared data or common operations, while **non-static methods** are used for tasks specific to individual objects. Understanding these concepts helps developers create efficient and maintainable code.
