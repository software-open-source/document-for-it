# Prevent inheritance

[English below](#english)

Để ngăn một lớp **không thể bị kế thừa trong Java**, bạn cần sử dụng từ khóa **`final`**. 

---

### **Từ khóa `final` trong Java**
- **`final`** là một từ khóa trong Java có thể được sử dụng với **biến**, **phương thức**, hoặc **lớp**.
- Khi một lớp được khai báo là **`final`**, nó **không thể bị kế thừa** bởi bất kỳ lớp nào khác. Điều này nhằm bảo vệ lớp khỏi bị thay đổi cấu trúc thông qua kế thừa.

---

### **Khai báo một lớp `final`**
Cú pháp:
```java
final class ClassName {
    // Các thuộc tính và phương thức của lớp
}
```

Khi một lớp được khai báo với từ khóa `final`, bất kỳ nỗ lực nào để kế thừa nó sẽ gây lỗi biên dịch.

---

#### **Ví dụ: Sử dụng `final` để ngăn lớp bị kế thừa**

```java
// Khai báo lớp là final
final class A {
    void display() {
        System.out.println("This is a final class.");
    }
}

// Lớp khác cố gắng kế thừa lớp final
class B extends A {  // Lỗi biên dịch: Cannot inherit from final class 'A'
    // Nội dung lớp B
}
```

#### **Giải thích:**
- Lớp `A` được khai báo là `final`, do đó không thể có bất kỳ lớp nào kế thừa từ `A`.
- Nếu cố gắng kế thừa `A`, trình biên dịch sẽ báo lỗi:  
  ```
  error: cannot inherit from final class A
  ```

---

### **Lý do cần sử dụng `final` với class**

Việc sử dụng `final` với class thường được áp dụng trong các trường hợp:
1. **Bảo vệ tính toàn vẹn của thiết kế lớp:**
   - Khi bạn muốn một lớp không bị thay đổi hoặc mở rộng bởi các lớp con.
2. **Ngăn chặn việc ghi đè các phương thức:**
   - Một khi một lớp được `final`, mọi phương thức trong lớp đều không thể bị thay đổi thông qua kế thừa.
3. **Bảo vệ các lớp tiện ích (Utility Classes):**
   - Nhiều lớp như `Math`, `String` trong Java được thiết kế là `final` để đảm bảo rằng chúng không thể bị kế thừa.

---

### **Ví dụ thực tế: Lớp `String` trong Java**

`String` là một ví dụ tiêu biểu của một lớp được đánh dấu là `final`. Java không cho phép kế thừa lớp `String` nhằm đảm bảo rằng hành vi của kiểu dữ liệu `String` không bị thay đổi.

```java
final class String {
    // Nội dung của lớp String
}
```

Nếu thử kế thừa lớp `String`, bạn sẽ gặp lỗi biên dịch:

```java
class MyString extends String {  // Lỗi biên dịch
    // Nội dung của MyString
}
```

---

### **Ngăn phương thức kế thừa: Sử dụng `final` cho phương thức**

Nếu bạn muốn **chỉ ngăn kế thừa một phương thức nhất định** (mà không ngăn lớp bị kế thừa), bạn có thể sử dụng từ khóa `final` với phương thức. Điều này cho phép lớp của bạn vẫn có thể được kế thừa, nhưng các phương thức `final` không thể bị ghi đè.

#### **Ví dụ: `final` với phương thức**
```java
class Parent {
    final void display() {
        System.out.println("This is a final method.");
    }
}

class Child extends Parent {
    // Lỗi biên dịch: Cannot override the final method from Parent
    void display() {
        System.out.println("Attempting to override final method.");
    }
}
```

#### **Giải thích:**
- Phương thức `display()` trong lớp `Parent` được khai báo là `final`, nên nó không thể bị ghi đè (override) trong lớp `Child`.

---

### **Hạn chế của lớp `final`**
Sử dụng một lớp là `final` có những hạn chế:
1. **Không thể mở rộng (Extensibility):**
   - Bất kỳ lớp nào được đánh dấu là `final` đều hạn chế các nhà phát triển khác tạo thêm chức năng bằng cách kế thừa.
2. **Giảm tính linh hoạt:**
   - Trong một số trường hợp, tính kế thừa được sử dụng để mở rộng hoặc tái sử dụng mã, nhưng `final` cản trở điều này.

---

### **Tóm tắt**
- Dùng **`final`** trước một **lớp** để ngăn nó bị kế thừa:  
  ```java
  final class A {
      // Nội dung lớp
  }
  ```
- Một lớp được khai báo `final` không thể có bất kỳ lớp con nào khác.
- Một số lớp trong Java như `String`, `Math` được thiết kế `final` để bảo vệ chúng khỏi bị thay đổi hành vi.
- Hãy sử dụng `final` một cách hợp lý, đặc biệt khi bạn cần bảo vệ tính toàn vẹn của một lớp khỏi việc mở rộng không mong muốn.

---

# English:

### **How to Prevent a Class from Being Inherited in Java?**

To prevent a class **from being inherited in Java**, you can use the **`final`** keyword.

---

### **The `final` Keyword in Java**

- The **`final`** keyword is a reserved keyword in Java that can be applied to **variables**, **methods**, or **classes**.
- When a class is declared as **`final`**, it **cannot be extended (inherited)** by any other class. This helps to protect the class from being modified through inheritance.

---

### **Declaring a `final` Class**

Syntax:
```java
final class ClassName {
    // Class properties and methods
}
```

When a class is declared as `final`, any attempt to extend it will result in a compilation error.

---

#### **Example: Using `final` to Prevent a Class from Being Inherited**

```java
// Declaring the class as final
final class A {
    void display() {
        System.out.println("This is a final class.");
    }
}

// A class trying to extend the final class
class B extends A {  // Compilation error: Cannot inherit from final class 'A'
    // Class B content
}
```

#### **Explanation:**
- The class `A` is declared as `final`, thus no other class can extend it.
- If another class (in this case, `B`) tries to inherit from `A`, the compiler will throw an error:  
  ```
  error: cannot inherit from final class A
  ```

---

### **Why Use the `final` Keyword for Classes?**

Using the `final` keyword with a class is often done in the following situations:

1. **To Protect the Integrity of the Class Design:**
   - When you want to prevent a class from being modified or extended by subclassing.
   
2. **To Prevent Overriding of Methods:**
   - When a class is `final`, all of its methods are also implicitly final, meaning they cannot be overridden by subclasses.

3. **For Utility or Helper Classes:**
   - Many utility classes like `Math` in Java are declared as `final` to ensure they are not extended.

---

### **Example: The `String` Class in Java**

The `String` class is a well-known example of a `final` class. Java does not allow classes to inherit the `String` class to ensure its behavior remains consistent.

```java
final class String {
    // Internal content of the String class
}
```

If you try to subclass the `String` class, you'll encounter a compilation error:

```java
class MyString extends String {  // Compilation error
    // Class content
}
```

---

### **Preventing Specific Methods from Being Overridden: Using `final` with Methods**

If you'd like to prevent only specific **methods** from being overridden while still allowing inheritance of the class, you can use the `final` keyword with methods.

#### **Example: `final` with Methods**

```java
class Parent {
    final void display() {
        System.out.println("This is a final method.");
    }
}

class Child extends Parent {
    // Compilation error: Cannot override the final method from Parent
    void display() {
        System.out.println("Attempting to override a final method.");
    }
}
```

#### **Explanation:**
- The `display()` method in the `Parent` class is declared as `final`, so it cannot be overridden in the `Child` class.

### **Advantages of Final Classes**

1. **Secures Class Design**: Prevents undesired modification.
2. **Performance Optimization**: JVM optimizes `final` classes.
3. **Restricts Override Usage**: Ensures finality for method behaviors.
