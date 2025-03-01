# Áp dụng đóng gói thực tiễn

[English below](#english)

### **Cách áp dụng đóng gói trong thực tiễn**

Để áp dụng **đóng gói** trong thực tiễn, chúng ta sử dụng các từ khóa kiểm soát truy cập như **`private`**, **`public`**, và **`protected`** trong các lớp (classes). Những từ khóa này giúp kiểm soát quyền truy cập vào các thuộc tính và phương thức của lớp từ các đối tượng hoặc lớp khác.

---

### **1. Sử dụng từ khóa `private`, `public`, và `protected`**

1. **`private`:**
   - Dữ liệu hoặc phương thức được khai báo là `private` chỉ có thể được truy cập bởi chính lớp đó.
   - Đây là mức độ bảo vệ cao nhất để ngăn việc truy cập trực tiếp từ bên ngoài.

2. **`public`:**
   - Dữ liệu hoặc phương thức được khai báo là `public` có thể được truy cập từ **mọi nơi** (trong cùng một class, package, hoặc class bên ngoài).

3. **`protected`:**
   - Dữ liệu hoặc phương thức được khai báo là `protected` có thể được truy cập từ:
     - Cùng một package.
     - Các lớp con kế thừa từ lớp cha, ngay cả khi ở khác package.

---

### **Ví dụ minh họa về đóng gói**

#### **Quản lý quyền truy cập với từ khóa `private`, `public`, và `protected`:**

```java
package encapsulationExample;

// Lớp Employee sử dụng các từ khóa private, public và protected để áp dụng đóng gói
class Employee {
    // Thuộc tính private - chỉ truy cập được từ trong chính lớp Employee
    private String name;
    private int age;

    // Constructor (public) - có thể gọi từ bất kỳ đâu để tạo Object
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter (public) - lấy giá trị của thuộc tính name
    public String getName() {
        return name;
    }

    // Setter (public) - kiểm soát việc thay đổi giá trị của thuộc tính name
    public void setName(String name) {
        this.name = name;
    }

    // Getter (public) - lấy giá trị của thuộc tính age
    public int getAge() {
        return age;
    }

    // Setter (public) - kiểm soát việc thay đổi giá trị của thuộc tính age
    public void setAge(int age) {
        if (age > 0) { 
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be positive.");
        }
    }

    // Phương thức protected - chỉ có thể truy cập trong package hoặc lớp con
    protected void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

#### **Kiểm tra đóng gói trong thực tế**

```java
package encapsulationExample;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Employee
        Employee emp = new Employee("Alice", 25);

        // Truy cập dữ liệu thông qua các phương thức public (getter và setter)
        System.out.println("Employee Name: " + emp.getName()); // Alice
        System.out.println("Employee Age: " + emp.getAge());   // 25

        // Thay đổi giá trị của các thuộc tính thông qua setter
        emp.setName("Bob");
        emp.setAge(30);
        System.out.println("Updated Name: " + emp.getName()); // Bob
        System.out.println("Updated Age: " + emp.getAge());   // 30

        // Gọi phương thức protected (trong cùng package)
        emp.displayDetails(); // Output: Name: Bob, Age: 30

        // Cố gắng truy cập trực tiếp vào thuộc tính private (Lỗi biên dịch)
        // emp.name = "Charlie"; 
        // emp.age = 35;
        // => Lỗi: name has private access in Employee
    }
}
```

---

#### **Giải thích:**
1. **Kiểm soát truy cập nhờ từ khóa `private`:**
   - Các thuộc tính `name` và `age` được khai báo là `private`, nên chúng không thể được truy cập trực tiếp từ bên ngoài. Điều này đảm bảo dữ liệu được bảo vệ.
2. **Truy cập gián tiếp thông qua `getter` và `setter`:**
   - Phương thức `getName`, `setName`, `getAge`, `setAge` giúp cấp quyền kiểm soát dữ liệu (chỉ cho phép chỉnh sửa hợp lệ, như kiểm tra tuổi trong setter `setAge`).
3. **Phương thức `protected`:**
   - Phương thức `displayDetails` chỉ có thể gọi từ các lớp trong cùng package hoặc các lớp con kế thừa.
4. **Phương thức `public`:**
   - Constructor, getter, và setter được khai báo là `public` để có thể truy cập ở bất kỳ đâu.

---

### **2. Tại sao sử dụng từ khóa kiểm soát truy cập (`private`, `public`, `protected`)?**

Sử dụng các từ khóa này cho phép kiểm soát tốt hơn quyền truy cập và chỉnh sửa dữ liệu, từ đó đạt được:

1. **Bảo vệ thông tin nội bộ (`private`)**
   - Ngăn người dùng hoặc lớp khác làm hỏng hoặc thay đổi trái phép dữ liệu nhạy cảm.

2. **Kiểm tra tính hợp lệ dữ liệu (`public` getter & setter):**
   - Thông qua các phương thức getter và setter công khai, bạn có thể thêm logic kiểm tra hoặc xử lý dữ liệu trước khi lưu nó.

3. **Đảm bảo tính kế thừa an toàn (`protected`):**
   - Khi lớp con kế thừa lớp cha, dữ liệu `protected` của lớp cha có thể được sử dụng và tùy chỉnh mà không phá hủy tính đóng gói.

4. **Che giấu sự phức tạp:**
   - Chi tiết nội bộ của một lớp được ẩn khỏi các lớp khác. Các lớp bên ngoài chỉ cần sử dụng các phương thức public để giao tiếp.

---

### **3. So sánh các từ khóa truy cập**

| **Modifier**  | Trong cùng lớp | Trong cùng package | Lớp khác (kế thừa) | Bên ngoài package |
|----------------|----------------|---------------------|---------------------|--------------------|
| **`private`**  | ✔              | ✖                   | ✖                   | ✖                  |
| **`protected`**| ✔              | ✔                   | ✔                   | ✖                  |
| **`public`**   | ✔              | ✔                   | ✔                   | ✔                  |

---

### **4. Lưu ý khi áp dụng đóng gói**
- **Dữ liệu nhạy cảm nên luôn được khai báo là `private`,** không bao giờ để ở mức `public` để tránh bị thay đổi trực tiếp.
- Quyền truy cập **chỉ mở đủ mức cần thiết**:
  - Nếu không cần lớp con truy cập, hãy giữ các thuộc tính/phương thức là `private`.
  - Chỉ sử dụng `protected` khi lớp con cần kế thừa hoặc phương thức cần được chia sẻ trong cùng package.
  - Sử dụng `public` cho các API hoặc phương thức mà bạn muốn công khai cho các lớp khác dùng.

---

# English:

### **How to Apply Encapsulation in Practice**

To apply **encapsulation** effectively, we use access modifiers such as **`private`**, **`public`**, and **`protected`** in classes. These modifiers control the visibility of class attributes and methods, allowing us to achieve data protection and controlled access. 

---

### **1. Access Modifiers Overview**

1. **`private`:**
   - The **private** fields and methods can only be accessed within the same class. This provides the highest level of protection.

2. **`public`:**
   - The **public** fields and methods can be accessed from **anywhere** (inside the same class, package, subclass, or even outside).

3. **`protected`:**
   - The **protected** fields and methods can be accessed in the same package or from subclasses in other packages.

---

### **Example of Encapsulation with Access Modifiers**

```java
class Employee {
    private String name;       // private field
    private int age;           // private field

    // Constructor (public)
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be positive.");
        }
    }

    // Protected method
    protected void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

#### **Explanation**

1. Use **`private`** to hide sensitive data (`name` and `age`), protecting it from direct access.
2. Allow controlled access to the data via **`public` getters and setters**.
3. Use **`protected`** for methods that are accessible to subclasses.

Encapsulation ensures **data security**, **flexibility**, and **controlled access**, enabling safe and maintainable object-oriented code.
