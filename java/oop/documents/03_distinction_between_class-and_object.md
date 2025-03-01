# Phân biệt giữa class và object
[English below](#english)

Sự khác biệt giữa **class (lớp)** và **object (đối tượng)** nằm ở bản chất, chức năng và cách chúng hoạt động trong lập trình hướng đối tượng (OOP). Dưới đây là những điểm chính phân biệt giữa hai khái niệm này:

---

### **1. Định nghĩa**
- **Lớp (Class):**
  - Một lớp là **khuôn mẫu (blueprint)** hoặc định nghĩa trừu tượng được sử dụng để tạo ra các đối tượng.
  - Nó xác định **thuộc tính (attributes)** và **hành vi (methods)** mà các đối tượng thuộc lớp đó sẽ có.
  - Bạn có thể xem lớp như một thiết kế chung, chưa cụ thể hoặc chỉ là lý thuyết mà không có thực tế.

- **Đối tượng (Object):**
  - Một đối tượng là một **thực thể cụ thể (instance)** của một lớp.
  - Nó là **phiên bản thực tế** được tạo từ lớp, chứa cụ thể các giá trị cho thuộc tính và có thể thực thi các hành vi.
  - Đối tượng đại diện cho một thực thể trong thế giới thực.

---

### **2. Bản chất**
- **Lớp (Class):**
  - Là một khái niệm logic, không tồn tại vật lý trong bộ nhớ (until instantiated).
  - Được định nghĩa một lần nhưng có thể tạo nhiều đối tượng từ lớp đó.

- **Đối tượng (Object):**
  - Là một khái niệm cụ thể và thực tế, tồn tại vật lý trong bộ nhớ.
  - Được tạo bằng cách sử dụng lớp như một khuôn mẫu.

---

### **3. Ví dụ thực tế**
- Lớp (Class): Là một bản thiết kế (blueprint) của một ngôi nhà, chỉ định các thuộc tính (số phòng, diện tích, màu sắc,...) và hành vi (mở cửa, đóng cửa,...).
- Đối tượng (Object): Là các nhà thực tế được xây dựng dựa vào bản thiết kế đó. Mỗi căn nhà sẽ có thông tin cụ thể như số phòng là 3, diện tích là 100m².

Trong lập trình:
- **Lớp (Class):**
  ```java
  public class Car {
      String brand;  // Thuộc tính
      int speed;

      void drive() { // Hành vi
          System.out.println("Driving at " + speed + " km/h");
      }
  }
  ```
- **Đối tượng (Object):**
  ```java
  public class Main {
      public static void main(String[] args) {
          // Tạo đối tượng từ lớp Car
          Car car1 = new Car();
          car1.brand = "Toyota";
          car1.speed = 120;
          car1.drive();  // Output: Driving at 120 km/h
      }
  }
  ```

---

### **4. Ý nghĩa trong lập trình**
- **Lớp (Class):**
  - Lớp cung cấp một khung (template) để tổ chức và chia sẻ mã.
  - Giúp lập trình viên định nghĩa rõ ràng mối quan hệ và hành vi trong chương trình.

- **Đối tượng (Object):**
  - Đối tượng là một biểu hiện cụ thể của lớp, mang dữ liệu cụ thể và hoạt động theo chức năng được định nghĩa trong lớp.

---

### **5. Sự thay đổi**
- **Lớp (Class):**
  - Lớp không thay đổi khi giá trị thuộc tính của các đối tượng thay đổi.
  - Ví dụ: Bạn tạo lớp `Person` một lần, nhưng mỗi đối tượng tạo từ lớp sẽ có thông tin khác nhau (như tên và tuổi).

- **Đối tượng (Object):**
  - Các đối tượng được tạo ra từ cùng một lớp nhưng sẽ có thông tin có thể khác nhau.
  - Ví dụ:
    ```java
    Car car1 = new Car();
    car1.brand = "Toyota";
    car1.speed = 80;

    Car car2 = new Car();
    car2.brand = "Ford";
    car2.speed = 100;
    ```

---

### **6. Từ khoá sử dụng**
- **Lớp (Class):** Sử dụng từ khóa `class` để định nghĩa.
    ```java
    public class Animal {
        String name;
        void makeSound() {
            System.out.println("Animal makes sound");
        }
    }
    ```
- **Đối tượng (Object):** Được tạo bằng từ khóa `new` hoặc thông qua các phương pháp khác như `getInstance()`.
    ```java
    Animal dog = new Animal();  // Tạo đối tượng từ class Animal
    ```

---

### **7. So sánh cụ thể**
| **Tiêu chí**           | **Lớp (Class)**                                   | **Đối tượng (Object)**                       |
|-------------------------|--------------------------------------------------|----------------------------------------------|
| **Định nghĩa**           | Là khuôn mẫu để tạo ra các đối tượng.             | Là thực thể của lớp, hiện diện trong thực tế.    |
| **Bản chất**            | Một khái niệm logic, không tồn tại trong bộ nhớ. | Một thực thể cụ thể, tồn tại trong bộ nhớ.      |
| **Ví dụ thực tế**        | Bản thiết kế của một chiếc xe.                   | Một chiếc xe cụ thể như Toyota hoặc Honda.     |
| **Số lượng**            | Được định nghĩa một lần.                         | Có thể tạo ra nhiều đối tượng từ một lớp.       |
| **Dữ liệu cụ thể**      | Không chứa dữ liệu cụ thể.                       | Chứa dữ liệu cụ thể, được gán vào tại runtime.  |
| **Tạo ra bằng**         | Sử dụng từ khóa `class`.                        | Sử dụng từ khóa `new` hoặc cách khác.          |

---

### **Tóm lại**
- **Class** is the "definition" or "blueprint", while **object** is the "implementation" or "instance" of the class. 
- Without classes, objects cannot exist, but without objects, classes are just theoretical structures without practical use.

---
# English:

# Distinction between class and object

The difference between a **class** and an **object** lies in their nature, functionality, and how they operate within Object-Oriented Programming (OOP). Below are the main points that distinguish these two concepts:

---

### **1. Definition**
- **Class:**
  - A class is a **blueprint (template)** or an abstract definition used to create objects.
  - It defines the **attributes (properties)** and **behavior (methods)** that objects of the class can have.
  - You can think of a class as a general, theoretical design without actual implementation.

- **Object:**
  - An object is a **specific instance** of a class.
  - It is the **real-world implementation**, containing specific values for attributes and capable of performing defined behaviors.
  - Objects represent real-world entities.

---

### **2. Nature**
- **Class:**
  - A class is a logical concept and does not have a physical existence in memory (until an object is created).
  - It is defined once but can be used to create multiple objects.

- **Object:**
  - An object is a concrete entity, and it occupies actual memory space.
  - It is created using the class as its template.

---

### **3. Real-World Example**
- Class: A **blueprint** of a house describing its attributes (number of rooms, size, color, etc.) and behaviors (open door, close door, etc.).
- Object: A **specific house** built based on that blueprint, containing particular details like 3 rooms, 100m² size, and painted white.

In programming:
- **Class:**
  ```java
  public class Car {
      String brand;  // Attribute
      int speed;

      void drive() { // Behavior
          System.out.println("Driving at " + speed + " km/h");
      }
  }
  ```
- **Object:**
  ```java
  public class Main {
      public static void main(String[] args) {
          // Creating an object from the Car class
          Car car1 = new Car();
          car1.brand = "Toyota";
          car1.speed = 120;
          car1.drive();  // Output: Driving at 120 km/h
      }
  }
  ```

---

### **4. Importance in Programming**
- **Class:**
  - A class serves as a framework (template) for organizing and sharing code.
  - It helps programmers define clear relationships and behaviors in their programs.

- **Object:**
  - An object is a concrete representation of the class, holding specific data and acting according to the class definitions.

---

### **5. Mutability**
- **Class:**
  - A class does not change when the attributes or data in its objects change.
  - Example: You only define the `Person` class once, but each object created from the class will have different information (like name or age).

- **Object:**
  - Objects created from the same class can hold different information.
  - Example:
    ```java
    Car car1 = new Car();
    car1.brand = "Toyota";
    car1.speed = 80;

    Car car2 = new Car();
    car2.brand = "Ford";
    car2.speed = 100;
    ```

---

### **6. Keywords**
- **Class:** Defined using the `class` keyword.
    ```java
    public class Animal {
        String name;
        void makeSound() {
            System.out.println("Animal makes sound");
        }
    }
    ```
- **Object:** Created using the `new` keyword or other methods like factories or builders.
    ```java
    Animal dog = new Animal();  // Create an object from the Animal class
    ```

---

### **7. Detailed Comparison**

| **Criteria**             | **Class**                                        | **Object**                                         |
|---------------------------|-------------------------------------------------|---------------------------------------------------|
| **Definition**            | A blueprint to create objects.                 | A specific instance of a class.                  |
| **Nature**                | A logical concept, no physical memory.         | A concrete entity, exists in memory.             |
| **Real-World Example**    | Blueprint of a car.                            | A specific car, like Toyota or Honda.            |
| **Quantity**              | Defined once.                                  | Many objects can be created from a single class. |
| **Specific Data**         | Does not hold specific data.                   | Contains specific data, assigned at runtime.     |
| **Created By**            | Defined using the `class` keyword.             | Created using the `new` keyword.                |

---

### **Summary**
- **Class** is the "definition" or "blueprint," while **object** is the "implementation" or "instance" of the class. 
- Without classes, objects cannot exist, but without objects, classes are just theoretical structures without practical use.
