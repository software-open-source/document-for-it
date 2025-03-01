# **Static trong Java - Các Loại và Đặc Điểm**

[English below](#english)

Trong Java, từ khóa `static` được sử dụng để khai báo **các thành phần thuộc về lớp (class)** thay vì thuộc về các đối tượng (instance) cụ thể. Static được sử dụng để tiết kiệm bộ nhớ và dùng chung dữ liệu hoặc phương thức trên toàn bộ lớp.

---

## **1. Các Loại `static` trong Java**

Java hỗ trợ bốn loại thành phần static:

| **Loại Static**       | **Mục đích**                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| **Biến static**       | Lưu trữ thông tin dùng chung giữa tất cả các đối tượng của lớp.             |
| **Phương thức static** | Dùng để thao tác dữ liệu chung hoặc gọi mà không cần tạo đối tượng.         |
| **Khối static**        | Khối mã được thực thi một lần khi lớp được tải vào bộ nhớ JVM.              |
| **Lớp lồng nhau static** | Một lớp bên trong có thể được khai báo là static; lớp này không phụ thuộc vào lớp cha. |

---

## **2. Đặc Điểm Từng Loại `static`**

### **2.1. Biến static (Static Variables)**

#### **Đặc điểm:**
- Biến `static` là biến **cấp lớp** (class-level), được chia sẻ giữa tất cả các đối tượng của lớp.
- Lưu trữ thông tin dùng chung cho mọi đối tượng (thay vì mỗi đối tượng có bản sao riêng của biến).
- Biến static chỉ được khởi tạo một lần khi lớp được tải vào bộ nhớ.

#### **Cách sử dụng:**
- Có thể truy cập bằng:
  - Tên lớp (`ClassName.variableName`).
  - Hoặc thông qua một đối tượng của lớp (không được khuyến khích).

#### **Ví dụ:**
```java
public class StaticVariableExample {
    static int count = 0; // Biến static dùng chung cho tất cả đối tượng

    StaticVariableExample() {
        count++; // Tăng giá trị mỗi khi đối tượng được tạo
    }

    public static void main(String[] args) {
        StaticVariableExample obj1 = new StaticVariableExample();
        StaticVariableExample obj2 = new StaticVariableExample();

        System.out.println("Số đối tượng được tạo: " + StaticVariableExample.count);
    }
}
```

**Kết quả:**
```
Số đối tượng được tạo: 2
```

---

### **2.2. Phương thức static (Static Methods)**

#### **Đặc điểm:**
- Phương thức static có thể được gọi trực tiếp bằng tên lớp mà **không cần tạo đối tượng**.
- Không thể truy cập **non-static variables** hoặc **non-static methods** trực tiếp trong phương thức static vì chúng yêu cầu instance.
- Chủ yếu được dùng để thực hiện các thao tác mà không phụ thuộc vào instance (ví dụ: các hàm tiện ích, toán học).

#### **Cách sử dụng:**
- Sử dụng trực tiếp qua tên lớp (`ClassName.methodName()`).

#### **Ví dụ:**
```java
public class StaticMethodExample {
    static int square(int x) { // Phương thức static để tính bình phương
        return x * x;
    }

    public static void main(String[] args) {
        // Gọi phương thức static qua tên lớp
        System.out.println("Bình phương của 4: " + StaticMethodExample.square(4));
    }
}
```

**Kết quả:**
```
Bình phương của 4: 16
```

---

### **2.3. Khối mã static (Static Block)**

#### **Đặc điểm:**
- Khối static là một đoạn mã được khai báo với từ khóa `static`.
- Nó được thực thi **một lần duy nhất** khi lớp được tải vào bộ nhớ bởi JVM.
- Chủ yếu được dùng để khởi tạo dữ liệu hoặc thực hiện các thao tác trước khi lớp được sử dụng.

#### **Cách sử dụng:**
- Dùng để **khởi tạo biến static** hoặc thực hiện các thao tác khởi động chung.

#### **Ví dụ:**
```java
public class StaticBlockExample {
    static String databaseUrl;

    // Khối static để khởi tạo
    static {
        databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Khối static được thực thi.");
    }

    public static void main(String[] args) {
        System.out.println("URL cơ sở dữ liệu: " + databaseUrl);
    }
}
```

**Kết quả:**
```
Khối static được thực thi.
URL cơ sở dữ liệu: jdbc:mysql://localhost:3306/mydb
```

---

### **2.4. Lớp lồng nhau static (Static Nested Class)**

#### **Đặc điểm:**
- Lớp lồng nhau **static** là một lớp có thể được khai báo bên trong một lớp khác và không phụ thuộc vào instance của lớp cha.
- Lớp này có thể truy cập trực tiếp các thành phần static của lớp cha (nhưng không phải non-static).

#### **Cách sử dụng:**
- Lớp lồng này được tham chiếu thông qua tên lớp cha (`OuterClass.StaticNestedClass`).

#### **Ví dụ:**
```java
public class OuterClass {
    static String outerStaticField = "Hello from OuterClass!";

    // Lớp lồng nhau static
    static class NestedStaticClass {
        void displayMessage() {
            System.out.println(outerStaticField); // Truy cập biến static từ lớp cha
        }
    }

    public static void main(String[] args) {
        // Tạo đối tượng của lớp lồng nhau static
        OuterClass.NestedStaticClass nestedObj = new OuterClass.NestedStaticClass();
        nestedObj.displayMessage();
    }
}
```

**Kết quả:**
```
Hello from OuterClass!
```

---

## **3. Tóm Tắt `static` trong Java**

| **Loại static**          | **Miêu tả**                                                                                       | **Truy cập**                                                                                      |
|---------------------------|---------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| **Biến static**           | Thông tin dùng chung lưu trữ tại cấp lớp, được chia sẻ giữa tất cả các đối tượng.                | `ClassName.variableName` (khuyến khích) hoặc `objectName.variableName` (không khuyến khích).      |
| **Phương thức static**    | Phương thức cấp lớp, hoạt động mà không cần instance (thường dùng cho hàm tiện ích).              | `ClassName.methodName()`.                                                                        |
| **Khối static**           | Khối mã tự động thực thi khi lớp được tải. Dùng để khởi tạo biến static hoặc thực hiện cấu hình. | Tự động thực thi khi lớp được nạp vào JVM.                                                      |
| **Lớp lồng nhau static**  | Lớp bên trong không phụ thuộc vào instance của lớp cha.                                          | `OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();`.                  |

---

## **4. Lưu Ý Khi Sử Dụng `static`**
- **Sử dụng hợp lý:** `static` tiết kiệm bộ nhớ nhưng có thể dẫn đến tính thiếu linh hoạt (flexibility) nếu sử dụng quá nhiều.
- **Không thể ghi đè (override) phương thức static:** Phương thức static không thể bị ghi đè vì chúng thuộc về lớp, không thuộc về đối tượng.
- **Không thể tham chiếu đến thành phần non-static:** Trong một phương thức static, bạn không thể gọi hoặc tham chiếu trực tiếp các thành phần không static.

### **Ví dụ Sai Sót:**
```java
public class StaticLimitations {
    int nonStaticField = 10;

    static void staticMethod() {
        // Lỗi: Không thể tham chiếu đến biến non-static
        // System.out.println(nonStaticField); 
    }
}
```

---

**Kết Luận:**
Static là một công cụ mạnh mẽ trong Java giúp quản lý dữ liệu dùng chung, giảm thiểu chi phí bộ nhớ và hỗ trợ thực hiện các hàm tiện ích. Tuy nhiên, cần sử dụng cẩn thận để tránh làm mất tính linh hoạt và gây khó khăn trong bảo trì mã nguồn.

---
# English:

# **Static in Java - Types and Characteristics**

In Java, the `static` keyword is used to declare **class-level members** that belong to the class itself rather than to any specific instance of the class. Static is used to save memory and allow shared use of data or methods across all objects of the class.

---

## **1. Types of `static` in Java**

Java supports four types of `static` components:

| **Type of Static**       | **Purpose**                                                                |
|--------------------------|----------------------------------------------------------------------------|
| **Static Variable**       | Stores shared information among all objects of the class.                 |
| **Static Method**         | Used to perform common operations or for calling without creating objects. |
| **Static Block**          | A block of code executed only once when the class is loaded into JVM.      |
| **Static Nested Class**   | A nested class that does not depend on the instance of the outer (parent) class. |

---

## **2. Characteristics of Each Type of `static`**

### **2.1. Static Variables**

#### **Characteristics:**
- A `static` variable is a **class-level variable** that is shared across all objects of the class.
- It stores common information shared among every instance of the class, instead of creating separate copies for each object.
- A static variable is initialized only once when the class is loaded into memory.

#### **Usage:**
- It can be accessed using:
  - The class name (`ClassName.variableName`).
  - Or through an instance of the class (not recommended).

#### **Example:**
```java
public class StaticVariableExample {
    static int count = 0; // Static variable shared by all objects

    StaticVariableExample() {
        count++; // Increment count each time an object is created
    }

    public static void main(String[] args) {
        StaticVariableExample obj1 = new StaticVariableExample();
        StaticVariableExample obj2 = new StaticVariableExample();

        System.out.println("Number of objects created: " + StaticVariableExample.count);
    }
}
```

**Output:**
```
Number of objects created: 2
```

---

### **2.2. Static Methods**

#### **Characteristics:**
- A static method can be called directly using the class name **without creating an object**.
- It cannot access **non-static variables** or call **non-static methods** directly because they require an instance.
- Primarily used for operations that do not depend on instance data (e.g., utility or mathematical functions).

#### **Usage:**
- Called directly via the class name (`ClassName.methodName()`).

#### **Example:**
```java
public class StaticMethodExample {
    static int square(int x) { // Static method to calculate square
        return x * x;
    }

    public static void main(String[] args) {
        // Call the static method using the class name
        System.out.println("Square of 4: " + StaticMethodExample.square(4));
    }
}
```

**Output:**
```
Square of 4: 16
```

---

### **2.3. Static Block**

#### **Characteristics:**
- A static block is a section of code declared with the `static` keyword.
- It executes **only once** when the class is loaded into memory by the JVM.
- Primarily used for initializing static variables or performing setup tasks before the class is used.

#### **Usage:**
- Used to initialize static variables or perform shared configurations.

#### **Example:**
```java
public class StaticBlockExample {
    static String databaseUrl;

    // Static block for initialization
    static {
        databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Static block executed.");
    }

    public static void main(String[] args) {
        System.out.println("Database URL: " + databaseUrl);
    }
}
```

**Output:**
```
Static block executed.
Database URL: jdbc:mysql://localhost:3306/mydb
```

---

### **2.4. Static Nested Class**

#### **Characteristics:**
- A **static nested class** is a class declared inside another class but marked as `static`. It does not rely on the instance of its outer class.
- A static nested class can directly access the static members of its outer class (but not non-static members).

#### **Usage:**
- It can be referenced using the outer class name (`OuterClass.StaticNestedClass`).

#### **Example:**
```java
public class OuterClass {
    static String outerStaticField = "Hello from OuterClass!";

    // Static nested class
    static class NestedStaticClass {
        void displayMessage() {
            System.out.println(outerStaticField); // Accessing static variable of the outer class
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the static nested class
        OuterClass.NestedStaticClass nestedObj = new OuterClass.NestedStaticClass();
        nestedObj.displayMessage();
    }
}
```

**Output:**
```
Hello from OuterClass!
```

---

## **3. Summary of `static` in Java**

| **Type of static**      | **Description**                                                                             | **Access**                                                                                     |
|--------------------------|--------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| **Static Variable**      | Stores shared information at the class level, shared across all objects.                   | `ClassName.variableName` (recommended) or `objectName.variableName` (not recommended).        |
| **Static Method**        | Performs class-level operations and is callable without an instance (utility functions).    | `ClassName.methodName()`.                                                                     |
| **Static Block**         | Automatically executed when the class is loaded into JVM; used for initialization tasks.    | Executes automatically at class loading time.                                                |
| **Static Nested Class**  | A nested class independent of the outer (parent) class instance.                            | `OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();`.               |

---

## **4. Important Notes on `static`**

- **Use `static` wisely:** Although `static` saves memory, it can reduce flexibility if used excessively.
- **Cannot override static methods:** Static methods cannot be overridden because they pertain to the class and not the object.
- **Static methods cannot reference non-static members directly:** This limitation ensures that static methods do not rely on the instance state.

### **Example of Misuse:**
```java
public class StaticLimitations {
    int nonStaticField = 10;

    static void staticMethod() {
        // Error: Cannot reference non-static field from a static context
        // System.out.println(nonStaticField); 
    }
}
```

---

**Conclusion:**
The `static` keyword is a powerful tool in Java that helps manage shared data, reduce memory overhead, and create utility functions. However, it must be used cautiously to avoid compromising flexibility and maintainability of the code.
