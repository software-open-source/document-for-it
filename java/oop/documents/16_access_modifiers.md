# **Các Từ Khóa Quyền Truy Cập (Access Modifiers) trong Java**

[English below](#english)

Các từ khóa quyền truy cập trong Java được sử dụng để **kiểm soát mức độ truy cập** và **khả năng hiển thị** của lớp, thuộc tính (field), constructor, và các phương thức. Có bốn mức độ truy cập chính trong Java để xác định nơi các thành phần của chương trình có thể được truy cập.

---

## **1. Các Loại Access Modifiers trong Java**

### **a) Public**
- Từ khóa **`public`** cho phép truy cập từ **bất kỳ đâu** trong chương trình. 
- Thành viên (field, method, hoặc class) được khai báo là `public` có thể được truy cập bởi tất cả các lớp, gói (package), và lớp con (subclass).

**Ví dụ:**
```java
public class Example {
    public int number = 10;

    public void display() {
        System.out.println("Phương thức Công khai: " + number);
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.display(); // Truy cập ở mọi nơi
    }
}
```

**Kết quả:**
```
Phương thức Công khai: 10
```

---

### **b) Private**
- Từ khóa **`private`** giới hạn quyền truy cập **chỉ trong cùng một lớp**.
- Thành viên `private` **không thể truy cập** từ bên ngoài lớp, thậm chí không thể truy cập bởi lớp con (subclass) hoặc các lớp nằm trong cùng gói.

**Ví dụ:**
```java
public class Example {
    private int number = 10;

    private void display() {
        System.out.println("Phương thức Riêng tư: " + number);
    }

    public void accessPrivate() {
        display(); // Truy cập phương thức private trong cùng lớp
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.accessPrivate(); // Có thể truy cập thông qua phương thức công khai
        // obj.display(); // Lỗi: 'display()' có quyền truy cập là private
    }
}
```

**Kết quả:**
```
Phương thức Riêng tư: 10
```

---

### **c) Protected**
- Từ khóa **`protected`** cho phép truy cập trong **cùng một gói** và bởi **lớp con** (subclass), ngay cả khi lớp con thuộc gói khác.
- Rất hữu ích trong việc sử dụng **kế thừa** (Inheritance).

**Ví dụ:**
```java
package package1;

public class Parent {
    protected int number = 42;

    protected void display() {
        System.out.println("Phương thức Bảo vệ: " + number);
    }
}

// Trong một gói khác:

package package2;

import package1.Parent;

public class Child extends Parent {
    public void accessProtected() {
        display(); // Có thể truy cập vì đây là lớp con
    }

    public static void main(String[] args) {
        Child obj = new Child();
        obj.accessProtected();
    }
}
```

**Kết quả:**
```
Phương thức Bảo vệ: 42
```

**Giải thích:**
- Phương thức `display()` và thuộc tính `number` có quyền truy cập là `protected`, nên có thể được truy cập trong `Child` do `Child` kế thừa từ `Parent`.

---

### **d) Default (Mặc định - Package-private)**
- Khi không khai báo bất kỳ từ khóa nào, thành viên sẽ có quyền truy cập **"gói"** (package-private).
- Điều này có nghĩa là thành viên chỉ có thể truy cập **trong cùng một gói**, nhưng không được truy cập từ lớp bên ngoài gói.

**Ví dụ:**
```java
package package1;

class Example {
    int number = 10; // Quyền truy cập mặc định (không có modifier)

    void display() {
        System.out.println("Phương thức Mặc định: " + number);
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.display();  // Truy cập được vì cùng gói
    }
}
```

**Kết quả:**
```
Phương thức Mặc định: 10
```

**Giải thích:**
- Thuộc tính `number` và phương thức `display()` được khai báo mà không có modifier, nên chúng chỉ có thể được truy cập bởi các lớp trong cùng một gói.

---

## **2. Bảng So Sánh Các Access Modifiers**

| **Modifier**     | **Cùng Lớp** | **Cùng Gói** | **Lớp Con (Khác Gói)** | **Lớp Khác (Khác Gói)** |
|-------------------|--------------|--------------|-------------------------|--------------------------|
| **public**        | ✅ Có        | ✅ Có        | ✅ Có                   | ✅ Có                    |
| **protected**     | ✅ Có        | ✅ Có        | ✅ Có                   | ❌ Không                 |
| **default**       | ✅ Có        | ✅ Có        | ❌ Không                | ❌ Không                 |
| **private**       | ✅ Có        | ❌ Không     | ❌ Không                | ❌ Không                 |

---

## **3. Access Modifiers cho Class**

1. **Lớp Cấp Cao (Top-level Class):**
   - Chỉ có thể sử dụng các từ khóa `public` hoặc mặc định (package-private) khi khai báo lớp.
   - Không thể sử dụng từ khóa **`private`** hoặc **`protected`** với lớp cấp cao.

    **Ví dụ:**
    ```java
    public class PublicClass {
        // Hợp lệ
    }

    class DefaultClass {
        // Hợp lệ (quyền truy cập mặc định - chỉ trong cùng gói)
    }

    protected class ProtectedClass {
        // LỖI: Không thể sử dụng 'protected' với lớp ngoài cùng
    }
    ```

2. **Lớp Nội Bộ (Inner Class):**
   - Có thể sử dụng tất cả các từ khóa: `public`, `protected`, `default`, và `private`.

---

## **4. Ứng Dụng Thực Tế của Access Modifiers**

### **a) Public**
- **`public`** được sử dụng cho các phương thức hoặc thuộc tính cần được truy cập từ mọi nơi.
- **Use Case:** Sử dụng cho các hàm thư viện hoặc chức năng API.

---

### **b) Private**
- **`private`** được dùng để **đóng gói dữ liệu** và ngăn chặn truy cập từ bên ngoài.
- Kết hợp getter và setter để kiểm soát quyền truy cập.

**Ví dụ về Đóng gói (Encapsulation):**
```java
public class Person {
    private String name; // Thuộc tính riêng tư

    public String getName() { // Getter
        return name;
    }

    public void setName(String name) { // Setter
        this.name = name;
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Nguyen Van A");
        System.out.println(person.getName());
    }
}
```

---

### **c) Protected**
- **`protected`** được dùng cho các thuộc tính hoặc phương thức bạn muốn chia sẻ với lớp con, đồng thời hạn chế truy cập từ các lớp không liên quan.

**Ví dụ:**
```java
class Animal {
    protected String sound = "Animal sound";

    protected void makeSound() {
        System.out.println(sound);
    }
}

class Dog extends Animal {
    public void bark() {
        sound = "Woof!";
        makeSound();
    }
}

class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
    }
}
```

---

### **d) Default (Package-private)**
- **Mặc định** được sử dụng cho các thành viên mà bạn muốn chỉ chia sẻ trong cùng một gói.
- Thường được sử dụng trong các lớp hỗ trợ nội bộ.

**Ví dụ:**
```java
package package1;

class PackageHelper {
    void printMessage() {
        System.out.println("Truy cập mặc định, chỉ trong cùng gói!");
    }
}

class Main {
    public static void main(String[] args) {
        PackageHelper helper = new PackageHelper();
        helper.printMessage(); // Truy cập được vì trong cùng gói
    }
}
```

---

## **5. Một Số Câu Hỏi Thường Gặp**

### **Câu hỏi: Có thể kết hợp các Access Modifiers không?**
- Không, bạn chỉ có thể sử dụng **một từ khóa quyền truy cập** cho mỗi thành viên.
- Tuy nhiên, bạn có thể kết hợp với các từ khóa khác như `static`, `final`, hoặc `abstract`.

**Ví dụ:**
```java
public class MyClass {
    private static final int MAX_VALUE = 100; // Hợp lệ
    protected abstract void display(); // Hợp lệ
}
```

---

### **Câu hỏi: Phương thức main có thể là private không?**
- Không. Phương thức `main()` phải luôn luôn là **public** để đảm bảo Java Virtual Machine (JVM) có thể khởi chạy chương trình.

---

## **6. Tóm Tắt**

| **Access Modifier** | **Phạm Vi Truy Cập**                                                                   | **Use Case**                                                            |
|---------------------|----------------------------------------------------------------------------------------|--------------------------------------------------------------------------|
| **public**          | Có thể truy cập ở **mọi nơi**, trên tất cả các gói.                                    | Dùng cho các API hoặc chức năng cần truy cập toàn cầu.                   |
| **protected**       | Truy cập được trong **cùng một gói** và bởi **lớp con** trong gói khác.                | Dùng trong kế thừa để chia sẻ thành viên với lớp con.                    |
| **default**         | Chỉ truy cập được trong **cùng một gói**.                                              | Sử dụng cho các chức năng nội bộ của gói (package-private).              |
| **private**         | Chỉ truy cập được **trong lớp hiện tại**.                                              | Dùng để đóng gói dữ liệu và bảo vệ dữ liệu khỏi sự truy cập bên ngoài.    |

Sử dụng đúng `Access Modifiers` giúp mã nguồn của bạn trở nên **bảo mật**, **dễ bảo trì**, và **có cấu trúc tốt**!

---
# English:

# **Access Modifiers in Java**

Access modifiers in Java **control the visibility** and **accessibility** of a class, its attributes (fields), constructors, and methods. There are four main levels of access control in Java, and they determine where a given class member can be accessed from within your program.

---

## **1. Types of Access Modifiers in Java**

### **a) Public**
- The **`public`** modifier allows access from **anywhere** in the program. 
- A `public` member (field, method, or class) can be accessed by all other classes, packages, and subclasses.

**Example:**
```java
public class Example {
    public int number = 10;

    public void display() {
        System.out.println("Public method: " + number);
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.display(); // Accessible everywhere
    }
}
```

**Output:**
```
Public method: 10
```

---

### **b) Private**
- The **`private`** modifier makes members accessible **only within the same class**.
- `private` members are **not visible** outside the class (not even to subclasses or classes in the same package).

**Example:**
```java
public class Example {
    private int number = 10;

    private void display() {
        System.out.println("Private method: " + number);
    }

    public void accessPrivate() {
        display(); // Private method can be accessed within the same class
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.accessPrivate(); // Allowed via public method
        // obj.display(); // Error: 'display()' has private access
    }
}
```

**Output:**
```
Private method: 10
```

---

### **c) Protected**
- The **`protected`** modifier allows access within the **same package** and by **subclasses** (even if the subclass is in a different package).
- It's especially useful in Inheritance.

**Example:**
```java
package package1;

public class Parent {
    protected int number = 42;

    protected void display() {
        System.out.println("Protected method: " + number);
    }
}

// In another package:

package package2;

import package1.Parent;

public class Child extends Parent {
    public void accessProtected() {
        display(); // Accessible because it's a subclass
    }

    public static void main(String[] args) {
        Child obj = new Child();
        obj.accessProtected();
    }
}
```

**Output:**
```
Protected method: 42
```

**Explanation:**
- The `display()` method and `number` field are protected, so they are accessible in the `Child` class because it inherits from the `Parent`.

---

### **d) Default (Package-private)**
- When no access modifier is specified, the member is considered to have **default access** (also known as "package-private").
- This means the member is accessible **within the same package only** (not accessible to classes in other packages).

**Example:**
```java
package package1;

class Example {
    int number = 10; // Default access (no modifier)

    void display() {
        System.out.println("Default method: " + number);
    }
}

class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.display();  // Accessible because it's in the same package
    }
}
```

**Output:**
```
Default method: 10
```

**Explanation:**
- The `number` and `display()` are accessible because the `Main` class is in the same package as the `Example` class.

---

## **2. Key Differences Between Access Modifiers**

| **Modifier**   | **Same Class** | **Same Package** | **Subclasses (Different Package)** | **Other Classes (Different Package)** |
|----------------|----------------|------------------|-------------------------------------|----------------------------------------|
| **public**     | ✅ Yes         | ✅ Yes           | ✅ Yes                              | ✅ Yes                                 |
| **protected**  | ✅ Yes         | ✅ Yes           | ✅ Yes                              | ❌ No                                  |
| **default**    | ✅ Yes         | ✅ Yes           | ❌ No                               | ❌ No                                  |
| **private**    | ✅ Yes         | ❌ No            | ❌ No                               | ❌ No                                  |

---

## **3. Access Modifiers for Classes**

1. **Top-level classes (classes not nested or inner):**
   - Can only use `public` or default (package-private) as modifiers.
   - **`private` or `protected`** cannot be used for **top-level classes**.

    **Example:**
    ```java
    public class PublicClass {
        // This is allowed
    }

    class DefaultClass {
        // This is also allowed (package-private)
    }

    protected class ProtectedClass {
        // ERROR: Top-level classes cannot be 'protected'
    }
    ```

2. **Inner classes:**
   - Can use all four modifiers: `public`, `protected`, `default`, and `private`.

---

## **4. Practical Usage of Access Modifiers**

### **a) Public**
- Use **`public`** for methods or fields that need to be accessed universally (across packages or modules).
- **Examples:**
  - Utility classes or library functions.
  - Methods in APIs provided for external use.

---

### **b) Private**
- Use **`private`** to **encapsulate data** and prevent external access.
- Use getter and setter methods to control read/write access to private fields.

**Example of Encapsulation:**
```java
public class Person {
    private String name; // Private field

    public String getName() { // Getter
        return name;
    }

    public void setName(String name) { // Setter
        this.name = name;
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        System.out.println(person.getName());
    }
}
```

---

### **c) Protected**
- Use **`protected`** for fields or methods you want to share with subclasses while restricting access from unrelated classes.

**Example:**
```java
class Animal {
    protected String sound = "Animal sound";

    protected void makeSound() {
        System.out.println(sound);
    }
}

class Dog extends Animal {
    public void bark() {
        sound = "Bark";
        makeSound();
    }
}

class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
    }
}
```

---

### **d) Default (Package-private)**
- Use **default (package-private)** for members that should only be shared within the same package.
- Helpful when implementing classes that cooperate closely within the same package (but should remain hidden from other packages).

**Example:**
```java
package package1;

class PackageHelper {
    void printMessage() {
        System.out.println("Default access, accessible only within package!");
    }
}

class Main {
    public static void main(String[] args) {
        PackageHelper helper = new PackageHelper();
        helper.printMessage(); // Works because it's inside the same package
    }
}
```

---

## **5. Frequently Asked Questions**

### **Q: Can Access Modifiers be combined?**
- No, at most **one access modifier** can be used per member (e.g., `private`, `public`, etc.). 
- However, you can combine access modifiers with **other modifiers** like `static`, `final`, or `abstract`.

**Example:**
```java
public class MyClass {
    private static final int MAX_VALUE = 100; // Valid
    protected abstract void display(); // Also valid
}
```

---

### **Q: Can the main method be private?**
- No. The `main()` method must always be `public` so it can be accessed by the Java Virtual Machine (JVM) to start the program.

---

## **6. Summary**

| **Access Modifier** | **Accessibility**                                                                                 | **Use Case**                                                                 |
|---------------------|---------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| **public**          | Accessible **everywhere**, across all packages.                                                  | Use for APIs and public functionality that needs global access.             |
| **protected**       | Accessible within the **same package** and by **subclasses** in other packages.                   | Use in inheritance to expose members to subclasses.                         |
| **default**         | Accessible only within the **same package** (package-private).                                    | Use for package-specific functionality while hiding it from other packages. |
| **private**         | Accessible only **within the defining class**.                                                   | Use to encapsulate data and make it secure, accessible via getters/setters. |

Using the right access modifier helps make your code **more secure**, **maintainable**, and **well-structured**!
