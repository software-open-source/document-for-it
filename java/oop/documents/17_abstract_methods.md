# **Abstract Methods trong Java**

[English below](#english)

## **1. Định nghĩa**
- **Abstract methods** là các phương thức được khai báo mà **không có phần thân (body)** method. Chỉ được định nghĩa bằng từ khóa `abstract` và không có logic thực thi bên trong.
- Các abstract methods được sử dụng trong **abstract classes** hoặc trong các **interfaces** và cần được **lớp con (subclass)** ghi đè (override) để cung cấp logic cụ thể.

Cú pháp:
```java
abstract returnType methodName(parameters);
```

---

## **2. Đặc điểm của Abstract Methods**
- **Không có thân phương thức (method body):**
  - Abstract methods chỉ bao gồm phần khai báo (declaration) nhưng không có phần thực thi (implementation).

- **Bắt buộc phải override trong lớp con:**
  - Một lớp cụ thể (concrete class) kế thừa một lớp trừu tượng hoặc interface phải ghi đè tất cả các abstract methods.

- **Tồn tại bên trong các abstract classes hoặc interfaces:**
  - Abstract methods không thể tồn tại trong lớp thông thường (non-abstract classes).

- Lớp chứa abstract methods phải được khai báo là **abstract class**.

**Ví dụ:**
```java
abstract class Animal {
    // Abstract method: no body
    abstract void makeSound();

    // Non-abstract method: has a body
    void sleep() {
        System.out.println("Sleeping...");
    }
}
```

---

## **3. Cách sử dụng Abstract Methods**

### **a) Abstract Methods trong Abstract Classes**
- Abstract methods thường được khai báo trong **abstract classes**, nghĩa là những lớp không thể tạo đối tượng trực tiếp.
- Một lớp kế thừa cần phải cung cấp phần thân (implementation) cho tất cả các abstract methods được định nghĩa trong lớp cha.

**Ví dụ:**
```java
// Abstract class
abstract class Animal {
    // Abstract method (no implementation)
    abstract void makeSound();

    // Non-abstract method
    void sleep() {
        System.out.println("This animal is sleeping");
    }
}

// Concrete class (subclass)
class Dog extends Animal {
    // Overriding abstract method
    @Override
    void makeSound() {
        System.out.println("Woof Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        // Cannot instantiate abstract class:
        // Animal animal = new Animal(); // Error

        // Instantiate subclass
        Dog myDog = new Dog();
        myDog.makeSound(); // Output: "Woof Woof"
        myDog.sleep();     // Output: "This animal is sleeping"
    }
}
```

### Output:
```
Woof Woof
This animal is sleeping
```

**Giải thích:**
- Lớp `Animal` có phương thức trừu tượng `makeSound()` không được định nghĩa phần thân.
- Lớp `Dog` cung cấp triển khai cho phương thức `makeSound()` bằng cách ghi đè.

---

### **b) Abstract Methods trong Interfaces**
- Trong Java, **interfaces** là một loại kiểu dữ liệu trừu tượng hoàn toàn (**fully abstract**) và mặc định tất cả các phương thức là **abstract**.
- Không cần từ khóa `abstract` khi khai báo phương thức trong một interface, vì mặc định phương thức là abstract.

**Ví dụ:**
```java
// Interface
interface Animal {
    // Abstract method (implicitly abstract)
    void makeSound();
}

// Implementing class
class Cat implements Animal {
    // Overriding abstract method
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myCat = new Cat(); // Interface reference
        myCat.makeSound(); // Output: "Meow Meow"
    }
}
```

### Output:
```
Meow Meow
```

**Giải thích:**
- Interface `Animal` định nghĩa phương thức `makeSound()`.
- Lớp `Cat` triển khai (implements) interface và cung cấp logic thực thi cho phương thức `makeSound()`.

---

## **4. Khác biệt giữa Abstract Methods và Non-Abstract Methods**

| **Đặc điểm**                | **Abstract Methods**                                                  | **Non-Abstract Methods**                                      |
|-----------------------------|----------------------------------------------------------------------|--------------------------------------------------------------|
| **Thân (body)**             | Không có phần thân (method body).                                    | Có logic thực thi (method body) trong định nghĩa.            |
| **Override**                | Bắt buộc phải ghi đè (override) trong lớp kế thừa cụ thể.            | Có thể được ghi đè (không bắt buộc).                        |
| **Vị trí khai báo**          | Chỉ tồn tại trong abstract classes hoặc interfaces.                 | Có thể tồn tại trong bất kỳ loại lớp nào.                   |
| **Mục đích**                | Dùng làm "khuôn mẫu chung" để các lớp con triển khai.               | Để định nghĩa logic cụ thể trong lớp.                       |

**Ví dụ:**

```java
abstract class Animal {
    // Abstract Method
    abstract void makeSound(); 

    // Non-Abstract Method
    void eat() {
        System.out.println("This animal is eating");
    }
}
```

---

## **5. Tại sao sử dụng Abstract Methods?**

- **Thiết kế hướng đối tượng tốt hơn:**
  - Abstract methods được sử dụng để đảm bảo rằng **tất cả lớp con phải chia sẻ cùng một hình thức hành vi (behavior)** nhưng với **triển khai cụ thể riêng của lớp đó**.
  
- **Tạo bản mẫu chung (Common Template):**
  - Lớp cha chỉ định cấu trúc hoặc giao diện mà lớp con phải tuân theo.

- **Khuyến khích tính nhất quán:**
  - Giảm thiểu lỗi bằng cách buộc các lập trình viên ghi đè (override) đúng các phương thức cần thiết.

---

## **6. Quy tắc quan trọng về Abstract Methods**

1. **Không thể có phương thức abstract trong lớp không phải abstract:**
   ```java
   class Animal { // Error
       abstract void makeSound(); // Error: Must be inside an abstract class
   }
   ```

2. **Lớp abstract có thể không chứa abstract methods:**
   - Một lớp abstract **không bắt buộc** phải có abstract methods, nhưng vẫn không thể được thể hiện (instantiated).

   **Ví dụ:**
   ```java
   abstract class Animal {
       void breathe() { 
           System.out.println("This animal is breathing");
       }
   }
   ```

3. **Các lớp con phải ghi đè tất cả các phương thức abstract:**
   - Trừ khi lớp con cũng được khai báo là abstract.

   **Ví dụ:**
   ```java
   abstract class Animal {
       abstract void makeSound();
   }

   abstract class Dog extends Animal {
       // Không cần ghi đè makeSound()
   }

   class Bulldog extends Dog {
       @Override
       void makeSound() {
           System.out.println("Woof Woof");
       }
   }
   ```

4. **Không thể khai báo phương thức `abstract` là `static`, `final`, hoặc `private`:**
   - Vì:
     - `static` phương thức không thể bị override bởi lớp con.
     - `final` ngăn chặn việc ghi đè (override).
     - `private` không được kế thừa bởi lớp con.

---

## **7. Sự khác biệt giữa Abstract Method và Interface**

| **Đặc điểm**                        | **Abstract Methods** in Abstract Classes             | **Abstract Methods** in Interfaces                            |
|-------------------------------------|------------------------------------------------------|--------------------------------------------------------------|
| **Từ khóa `abstract`**              | Cần từ khóa `abstract` để khai báo phương thức.       | Không cần `abstract` vì mặc định đã là abstract.             |
| **Kế thừa**                         | Lớp con chỉ có thể kế thừa một lớp abstract.           | Một lớp có thể triển khai nhiều interfaces (đa kế thừa).      |
| **Phương thức mặc định (default)**  | Không hỗ trợ phương thức mặc định trong lớp abstract.  | Có thể có `default` hoặc `static methods`.                   |
| **Hỗ trợ fields**                   | Cho phép khai báo fields (biến) thông thường.          | Chỉ hỗ trợ hằng số (biến `final static`).                    |

---

## **8. Tóm tắt**

- **Abstract methods** là các phương thức không có thân (body), chúng cung cấp giao diện (interface) hoặc mô tả các hành vi mà lớp con phải triển khai.
- **Abstract methods** bắt buộc phải định nghĩa bên trong các abstract classes hoặc interfaces.
- Được sử dụng để xây dựng thiết kế modul hóa (modular design), tăng tính thống nhất của chương trình, và đảm bảo lớp con tuân theo các phương thức chung cùng với triển khai riêng.

## **Khi sử dụng Abstract Methods**:
- Khi bạn cần cung cấp một **giao diện chung (common interface)** cho các hành vi mà các lớp con sẽ triển khai.
- Khi bạn muốn xây dựng phần logic chung ở lớp cha kết hợp với các phần logic riêng ở lớp con.

**Ví dụ chung:** Một lớp `Shape` có phương thức abstract `draw()`, và các lớp con (`Circle`, `Rectangle`) sẽ triển khai phương thức này theo cách riêng tùy thuộc vào loại hình.

---
# English:

# **Abstract Methods in Java**

## **1. Definition**
- **Abstract methods** are methods declared without a **body** (method implementation). They are defined using the `abstract` keyword and do not contain any executable code inside them.
- Abstract methods are typically used in **abstract classes** or **interfaces** and must be **overridden** by a **subclass** to provide a concrete implementation.

Syntax:
```java
abstract returnType methodName(parameters);
```

---

## **2. Key Characteristics of Abstract Methods**
- **No method body:**
  - Abstract methods only have a declaration (method signature) but no implementation (logic).
  
- **Must be overridden in subclasses:**
  - A concrete class (non-abstract class) inheriting an abstract class or interface must provide implementations for all abstract methods.

- **Exist in abstract classes or interfaces:**
  - Abstract methods cannot exist directly in a regular (non-abstract) class.

- The class containing abstract methods must be declared as an **abstract class**.

**Example:**
```java
abstract class Animal {
    // Abstract method: no body
    abstract void makeSound(); // Only there for subclasses to implement

    // Non-abstract method: has a body
    void sleep() {
        System.out.println("Sleeping...");
    }
}
```

---

## **3. How to Use Abstract Methods**

### **a) Abstract Methods in Abstract Classes**
- Abstract methods are often declared in **abstract classes**, meaning these classes cannot be instantiated directly.
- A subclass must implement all the abstract methods of its parent abstract class.

**Example:**
```java
// Abstract class
abstract class Animal {
    // Abstract method (no body)
    abstract void makeSound();

    // Non-abstract method
    void sleep() {
        System.out.println("This animal is sleeping");
    }
}

// Concrete class (subclass)
class Dog extends Animal {
    // Overriding abstract method
    @Override
    void makeSound() {
        System.out.println("Woof Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        // Cannot instantiate abstract class:
        // Animal animal = new Animal(); // Error

        // Instantiate subclass
        Dog myDog = new Dog();
        myDog.makeSound(); // Output: "Woof Woof"
        myDog.sleep();     // Output: "This animal is sleeping"
    }
}
```

### Output:
```
Woof Woof
This animal is sleeping
```

**Explanation:**
- The `Animal` class has the abstract method `makeSound()` with no body.
- The `Dog` class provides the concrete implementation of `makeSound()`. 

---

### **b) Abstract Methods in Interfaces**
- In Java, **interfaces** are a fully abstract type, meaning all methods in an interface are automatically **abstract**.
- The `abstract` keyword is optional for methods in interfaces as they are abstract by default.

**Example:**
```java
// Interface
interface Animal {
    // Abstract method (implicitly abstract)
    void makeSound();
}

// Implementing class
class Cat implements Animal {
    // Overriding abstract method
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myCat = new Cat(); // Interface reference
        myCat.makeSound(); // Output: "Meow Meow"
    }
}
```

### Output:
```
Meow Meow
```

**Explanation:**
- The `Animal` interface declares the `makeSound()` method.
- The `Cat` class implements the interface and provides the logic for the `makeSound()` method.

---

## **4. Difference Between Abstract Methods and Non-Abstract Methods**

| **Characteristic**        | **Abstract Methods**                                               | **Non-Abstract Methods**                                      |
|---------------------------|--------------------------------------------------------------------|-------------------------------------------------------------|
| **Body (Implementation)** | No body (method implementation) is provided.                      | Contains implementation (method body).                      |
| **Override Requirement**  | Must be overridden in a concrete subclass.                        | Can be overridden, but it’s optional.                       |
| **Location**              | Exists only in abstract classes or interfaces.                   | Can exist in any class (abstract, concrete, or regular class). |
| **Purpose**               | Serves as a "template" for subclasses to implement behavior.      | Provides specific functionality to be used as-is.           |

**Example:**
```java
abstract class Animal {
    // Abstract Method
    abstract void makeSound();

    // Non-Abstract Method
    void eat() {
        System.out.println("This animal is eating");
    }
}
```

---

## **5. Why Use Abstract Methods?**

- **Better OOP Design:**
  - Abstract methods ensure that **all subclasses share the same behavior format** but with **custom implementations**.

- **Common Template:**
  - Abstract methods allow a base class to define a common interface for all subclasses.

- **Encourages Consistency:**
  - By enforcing subclasses to override required methods, abstract methods reduce the chances of missing or inconsistent behavior.

---

## **6. Important Rules for Abstract Methods**

1. **Cannot exist in non-abstract classes:**
   ```java
   class Animal { // Error
       abstract void makeSound(); // Error: Must be inside an abstract class
   }
   ```

2. **Abstract classes do not have to declare abstract methods:**
   - An abstract class can exist without abstract methods, but it cannot be instantiated.

   **Example:**
   ```java
   abstract class Animal {
       void breathe() { 
           System.out.println("This animal is breathing");
       }
   }
   ```

3. **Subclasses must override all abstract methods:**
   - Unless the subclass is also declared as abstract.

   **Example:**
   ```java
   abstract class Animal {
       abstract void makeSound();
   }

   abstract class Dog extends Animal {
       // Does not need to override makeSound()
   }

   class Bulldog extends Dog {
       @Override
       void makeSound() {
           System.out.println("Woof Woof");
       }
   }
   ```

4. **Cannot declare `abstract` with `static`, `final`, or `private`:**
   - `static` methods cannot be overridden.
   - `final` prevents overriding.
   - `private` methods are not inherited.

---

## **7. Differences Between Abstract Methods and Interface Methods**

| **Characteristic**              | **Abstract Methods in Abstract Classes**                  | **Abstract Methods in Interfaces**                             |
|---------------------------------|-----------------------------------------------------------|----------------------------------------------------------------|
| **`abstract` Keyword Required** | Needs the `abstract` keyword for the method declaration.   | `abstract` keyword is optional (implicitly abstract).          |
| **Inheritance**                 | A class can inherit only one abstract class.              | A class can implement multiple interfaces (multiple inheritance). |
| **Default/Static Methods**      | Cannot have `default` or `static` methods.                | Can contain `default` and `static` methods.                    |
| **Fields**                      | Allows regular fields (instance variables).               | Only supports constants (`final static` variables).            |

---

## **8. Summary**

- **Abstract methods** are methods without implementation, requiring subclasses to override and implement them.
- **Abstract methods** are declared within abstract classes or interfaces.
- They are used to enforce a **common interface or behavior format**, requiring concrete implementation by subclasses.

---

## **When to Use Abstract Methods?**
- When you need to define a **common interface** for behavior, where the implementation may vary across different classes.
- When you want to set up a **template** that ensures subclasses adhere to a specific structure.

**Common Example:** A `Shape` class can have an abstract method `draw()`, and subclasses like `Circle` or `Rectangle` implement the method in ways that align with their behavior.
