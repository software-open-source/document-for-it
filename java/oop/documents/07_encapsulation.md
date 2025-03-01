# Đóng gói

[English below](#english)

### **Đóng gói là gì?**

Đóng gói (**Encapsulation**) là một trong những nguyên lý cơ bản của **Lập trình hướng đối tượng (Object-Oriented Programming - OOP)**. Nó đề cập đến việc **ẩn giấu thông tin** (data hiding) và **bảo vệ dữ liệu** bên trong một lớp (class), chỉ cho phép truy cập và chỉnh sửa dữ liệu thông qua các phương thức (methods) được định nghĩa công khai (public). 

Trong Java (hoặc các ngôn ngữ lập trình OOP), đóng gói thường đạt được bằng cách:
1. **Khai báo các thuộc tính của lớp (fields) ở dạng `private`** để chúng không thể truy cập trực tiếp từ bên ngoài.
2. **Cung cấp các phương thức `getter` và `setter`** để kiểm soát quyền truy cập và sửa đổi dữ liệu.

---

### **Lợi ích chính của đóng gói**

1. **Bảo vệ dữ liệu (Data Security):**
   - Ngăn chặn việc truy cập hoặc thay đổi dữ liệu trực tiếp từ bên ngoài. Điều này đảm bảo dữ liệu chỉ được thao tác theo cách được định nghĩa.
   
2. **Kiểm soát quyền truy cập:**
   - Bạn có thể kiểm soát và giới hạn cách thức các đối tượng khác truy cập và sửa đổi dữ liệu thông qua `getter` và `setter`.

3. **Tăng khả năng bảo trì (Maintainability):**
   - Nếu bạn cần thay đổi cách dữ liệu của lớp hoạt động, bạn chỉ cần thay đổi trong lớp đó mà không làm ảnh hưởng đến các đoạn mã khác.

4. **Tăng tính tái sử dụng mã:**
   - Các lớp được đóng gói cẩn thận có thể được sử dụng lại dễ dàng bởi các phần khác của chương trình vì nó che giấu cách dữ liệu hoạt động bên trong.

---

### **Ví dụ: Đóng gói trong Java**

Hãy xem ví dụ sau minh họa sử dụng đóng gói trong Java:

```java
// Class sử dụng đóng gói
class Employee {
    // Thuộc tính private: chỉ có thể truy cập và chỉnh sửa thông qua các phương thức
    private String name;
    private int age;

    // Constructor để khởi tạo Employee
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Phương thức getter cho thuộc tính name
    public String getName() {
        return name;
    }

    // Phương thức setter cho thuộc tính name
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức getter cho thuộc tính age
    public int getAge() {
        return age;
    }

    // Phương thức setter cho thuộc tính age
    public void setAge(int age) {
        if (age > 0) { // Kiểm tra giá trị để đảm bảo tính hợp lệ
            this.age = age;
        } else {
            System.out.println("Invalid age entered. Age must be positive.");
        }
    }
}

// Class Main kiểm tra đóng gói
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Employee
        Employee emp = new Employee("Alice", 25);

        // Sử dụng getter để truy cập dữ liệu
        System.out.println("Name: " + emp.getName()); // Output: Name: Alice
        System.out.println("Age: " + emp.getAge());   // Output: Age: 25

        // Sử dụng setter để thay đổi dữ liệu
        emp.setName("Bob");
        emp.setAge(30);

        // Sau khi cập nhật
        System.out.println("Updated Name: " + emp.getName()); // Output: Updated Name: Bob
        System.out.println("Updated Age: " + emp.getAge());   // Output: Updated Age: 30

        // Cố ý nhập tuổi không hợp lệ
        emp.setAge(-5); // Output: Invalid age entered. Age must be positive.
    }
}
```

---

### **Giải thích:**
1. **Ẩn dấu dữ liệu:**
   - Các thuộc tính `name` và `age` được khai báo là `private`, do đó chúng chỉ có thể được truy cập và chỉnh sửa thông qua các phương thức công khai `getName`, `setName`, `getAge`, và `setAge`.
   
2. **Kiểm tra hợp lệ:**
   - Trong setter `setAge`, kiểm tra được thêm vào để đảm bảo giá trị tuổi phải là số dương. Điều này bảo vệ dữ liệu khỏi bị gán giá trị không hợp lệ.

3. **Kiểm soát việc truy cập dữ liệu:**
   - Các phương thức `getter` và `setter` cho phép bạn quản lý cách các đối tượng khác truy cập và chỉnh sửa dữ liệu của class.

4. **Bảo vệ tính toàn vẹn của dữ liệu:**
   - Người dùng không thể thay đổi trực tiếp giá trị các thuộc tính. Điều này làm tăng tính bảo mật và tính toàn vẹn của dữ liệu.

---

### **Ứng dụng thực tế của Đóng gói**

1. **Che giấu thông tin nội bộ của hệ thống:**
   - Đóng gói giúp bạn che giấu các thông tin không cần thiết khỏi các đối tượng bên ngoài. Ví dụ: trong hệ thống ngân hàng, số PIN hoặc số tài khoản thường được ẩn sau các lớp xử lý với quyền truy cập cụ thể.

2. **Bảo trì và thay đổi dễ dàng:**
   - Nếu bạn thay đổi cách dữ liệu được lưu trữ hoặc xử lý, các thay đổi này chỉ cần thực hiện trong lớp, thay vì thay đổi hàng loạt mã trong toàn hệ thống.

3. **Khả năng tái sử dụng:**
   - Lớp được đóng gói (ví dụ: `Employee`) có thể được sử dụng lại trong các phân hệ khác nhau của chương trình mà không cần lo lắng về cách thức quản lý dữ liệu bên trong.

4. **An toàn dữ liệu:**
   - Đóng gói ngăn chặn các bên thứ ba truy cập trái phép hoặc làm hỏng dữ liệu nhạy cảm.

---

# English:

### **What is Encapsulation?**

Encapsulation is one of the fundamental principles of **Object-Oriented Programming (OOP)**. It refers to the practice of **hiding internal details** and **protecting data** within a class. This is achieved by making the class's fields (`attributes`) **private** and providing controlled access to them through public methods, normally called `getters` and `setters`.

---

### **Key Benefits of Encapsulation**

1. **Data Protection:**
   - It prevents unauthorized access or direct modification of class data from external code, thus ensuring data security.

2. **Control Over Data:**
   - Using `getters` and `setters`, you can control what values can be retrieved or set, and validate data as needed.

3. **Improved Maintainability:**
   - If the internal data representation changes, you only need to modify the class, leaving external code that uses the class untouched.

4. **Code Reusability:**
   - Encapsulated classes with well-defined access make code modular and reusable in different parts of the program.

---

### **Example: Encapsulation in Java**

Here’s an example of encapsulation implemented in Java:

```java
class Employee {
    private String name; // Private field
    private int age;     // Private field

    // Constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age entered. Age must be positive.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 25);
        System.out.println(emp.getName()); // Output: Alice
        System.out.println(emp.getAge());  // Output: 25

        // Modify name and age using setters
        emp.setName("Bob");
        emp.setAge(30);

        System.out.println(emp.getName()); // Output: Bob
        System.out.println(emp.getAge());  // Output: 30

        // Enter invalid age
        emp.setAge(-5); // Output: Invalid age entered. Age must be positive.
    }
}
```

---

### **Applications of Encapsulation**

1. **Data Security:**
   - Encapsulation ensures sensitive information like passwords, PINs, or financial data is protected from unauthorized access.

2. **Modifiability:**
   - If the way data is stored or handled changes (e.g., transitioning from integers to strings), only the encapsulated class needs modification.

3. **Reusable and Reliable Code:**
   - Encapsulated classes can easily be reused across various projects with proper modular structure.

4. **Validation and Error Control:**
   - Encapsulation allows you to add validation logic (e.g., ensuring an age is positive) to ensure data integrity.

---

### **Conclusion**

Encapsulation is a powerful pillar of OOP that boosts **data security**, **maintainability**, and **modularity**. It allows a class to completely control access to its internal properties and how those properties are modified, ensuring the consistency and integrity of code and data.
