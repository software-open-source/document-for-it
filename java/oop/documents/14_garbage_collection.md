# **Xử lý khi một đối tượng không còn cần thiết: Garbage Collection trong Java**

[English below](#english)

Trong Java, bạn **không cần tự quản lý việc giải phóng bộ nhớ**, như trong các ngôn ngữ lập trình C/C++. Thay vào đó, Java cung cấp một **cơ chế tự động quản lý bộ nhớ** được gọi là **Garbage Collection (GC)**, giúp tự động dọn dẹp và giải phóng bộ nhớ của những **đối tượng không còn được sử dụng nữa** (unreferenced objects).

---

## **1. Garbage Collection là gì?**

- **Garbage Collection (GC)** là cơ chế trong Java để giải phóng bộ nhớ bị các đối tượng không còn tham chiếu (unreachable objects) chiếm dụng.
- GC đảm bảo rằng Java có đủ bộ nhớ để tạo đối tượng mới mà không yêu cầu lập trình viên phải tự giải phóng bộ nhớ như trong các ngôn ngữ như C/C++ (với `free()` hoặc `delete`).
- Java hỗ trợ một **Garbage Collector (Trình thu gom rác)** hoạt động trong nền, nó theo dõi các đối tượng không còn cần thiết và giải phóng vùng nhớ của chúng.

---

## **2. Khi nào một đối tượng trở thành "garbage" (rác)?**

Một đối tượng trong Java trở thành "rác" nếu **không còn bất kỳ tham chiếu nào trỏ tới nó**. Dưới đây là một số trường hợp khiến một đối tượng trở thành không sử dụng được:

### **Ví dụ về một đối tượng không còn được sử dụng**:

#### **Ví dụ 1: Một đối tượng không được tham chiếu**
```java
public class GarbageExample {
    public static void main(String[] args) {
        String str = new String("Hello, Java!");
        str = null; // "Hello, Java!" is now eligible for garbage collection
    }
}
```
- Khi `str = null`, đối tượng `"Hello, Java!"` trở thành đối tượng không còn tham chiếu và sẽ được thu gom bởi Garbage Collector.

---

#### **Ví dụ 2: Gán một tham chiếu cho đối tượng khác**
```java
public class GarbageExample {
    public static void main(String[] args) {
        String str1 = new String("First String");
        String str2 = new String("Second String");

        str1 = str2; // The "First String" object is now eligible for garbage collection
    }
}
```
- Ở đây, biến `str1` trước đó giữ tham chiếu đến đối tượng `"First String"`. Nhưng khi `str1` được gán cho `str2`, đối tượng `"First String"` không còn được tham chiếu nữa và đủ điều kiện để được thu gom rác.

---

#### **Ví dụ 3: Đối tượng của một lớp không còn được tham chiếu**
```java
class MyClass {
    int x;
}

public class GarbageExample {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        obj1 = obj2; // The object initially pointed to by obj1 is now garbage
    }
}
```
- Biến `obj1` ban đầu tham chiếu đến một đối tượng, nhưng khi gán nó bằng `obj2`, đối tượng ban đầu không còn tham chiếu nào trỏ tới và trở thành rác.

---

## **3. Cách Garbage Collector hoạt động**

### **a) Thuật toán của Garbage Collector**
1. **Mark:** GC tìm tất cả các đối tượng còn được tham chiếu và "đánh dấu" chúng.
2. **Sweep:** GC quét qua bộ nhớ heap và thu hồi vùng bộ nhớ của tất cả các đối tượng không được đánh dấu.

---

### **b) Thời điểm hoạt động của Garbage Collector**
- Garbage Collector **không được kích hoạt một cách thủ công trực tiếp**. Java quyết định khi nào cần gọi GC dựa trên:
  1. **Bộ nhớ thấp:** Khi JVM gần hết bộ nhớ heap.
  2. **Quản lý tài nguyên:** Khi JVM cảm thấy cần phải tối ưu hóa việc sử dụng bộ nhớ.

### **c) Triệu hồi Garbage Collector bằng cách gợi ý**
- Bạn có thể **gợi ý JVM gọi Garbage Collector** bằng cách sử dụng:
  ```java
  System.gc(); // Requests JVM to run Garbage Collector
  Runtime.getRuntime().gc();
  ```
- Lưu ý: Lời gọi `System.gc()` chỉ là **một yêu cầu** với JVM, không đảm bảo rằng GC sẽ chạy ngay lập tức.

#### **Ví dụ:**
```java
public class GarbageExample {
    public static void main(String[] args) {
        GarbageExample obj = new GarbageExample();

        obj = null; // Make the object eligible for GC
        System.gc(); // Suggest JVM to run GC
    }

    // Finalize method invoked before object is garbage collected
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collected");
    }
}
```

**Output:**
```
Garbage Collected
```

**Giải thích:**
- Khi đối tượng `obj` được gán `null`, nó đủ điều kiện để bị thu gom bởi Garbage Collector.
- `System.gc()` gợi ý JVM thực hiện GC, và phương thức **`finalize()`** được gọi trước khi đối tượng bị hủy.

---

## **4. Lưu ý quan trọng về Garbage Collection**

1. **Không kiểm soát hoàn toàn được GC:**
   - Garbage Collection được quản lý hoàn toàn bởi JVM. Bạn **không thể buộc GC** phải chạy ngay lập tức.
   - Ngay cả khi gọi `System.gc()`, JVM có thể quyết định không thực hiện thu gom rác.

2. **Phương thức `finalize()` (Deprecated):**
   - Phương thức `finalize()` được JVM gọi **một lần duy nhất** trước khi đối tượng được thu gom rác.
   - Tuy nhiên, `finalize()` được xem là **không khuyến nghị sử dụng** vì nó có thể gây ra hiệu năng kém và lỗi khó đoán. Nó đã bị đánh dấu **"deprecated"** từ Java 9.

---

## **5. Ưu điểm của Garbage Collection**

- **Tự động hóa quản lý bộ nhớ:**
  - Người lập trình **không cần giải phóng bộ nhớ thủ công**.
- **Tránh lỗi như "Dangling Pointer":**
  - Việc quản lý tự động tránh các lỗi truy cập vào bộ nhớ không còn hợp lệ.

---

## **6. Vòng đời của một đối tượng trong Java**

1. **Tạo đối tượng:**
   - Đối tượng được tạo ra bằng từ khóa `new` và bộ nhớ được cấp phát trên heap.
   ```java
   MyClass obj = new MyClass();
   ```
2. **Sử dụng đối tượng:**
   - Đối tượng tồn tại miễn là ít nhất một tham chiếu vẫn trỏ tới nó.
3. **Trở thành không tham chiếu ("Garbage"):**
   - Đối tượng không còn tham chiếu trở thành ứng viên của garbage collection.
4. **Giải phóng bởi GC:**
   - JVM khởi chạy Garbage Collector để giải phóng bộ nhớ bị chiếm dụng bởi đối tượng không cần thiết.

---

## **7. Các thuật toán Garbage Collection trong JVM**

JVM có hỗ trợ các thuật toán Garbage Collection hiện đại như:
1. **Serial Garbage Collector:**
   - Sử dụng một luồng duy nhất, thích hợp cho các ứng dụng đơn luồng.
2. **Parallel Garbage Collector:**
   - Sử dụng nhiều luồng để xử lý, phù hợp cho các ứng dụng đa luồng.
3. **G1 Garbage Collector:**
   - Tối ưu cho các ứng dụng yêu cầu độ trễ thấp.
4. **Z Garbage Collector (Java 11+):**
   - GC hiện đại với khả năng tối thiểu hóa độ trễ.

Bạn có thể tùy chỉnh Garbage Collector bằng tham số JVM, ví dụ:
```bash
java -XX:+UseG1GC MyApplication
```

---

## **8. Tóm tắt**

- **Garbage Collection** trong Java là một cơ chế tự động giúp giải phóng bộ nhớ cho các đối tượng không còn được tham chiếu.
- **Garbage Collector (GC)** hoạt động tự động và chủ yếu được quyết định bởi JVM.
- Lập trình viên chỉ cần đảm bảo rằng không giữ tham chiếu đến các đối tượng không còn cần thiết để tối ưu hóa bộ nhớ.
- Sử dụng `System.gc()` để **gợi ý Garbage Collector**, nhưng không đảm bảo GC sẽ chạy ngay lập tức.

Garbage Collection đóng vai trò quan trọng trong việc giúp Java trở thành một ngôn ngữ **bảo mật và đáng tin cậy**, giảm thiểu rủi ro lỗi quản lý bộ nhớ so với các ngôn ngữ thủ công như C/C++.


---
# English:

# **Handling Unused Objects: Garbage Collection in Java**

In Java, you **do not need to manually manage memory deallocation**, unlike in programming languages like C/C++. Instead, Java provides an **automatic memory management mechanism** called **Garbage Collection (GC)**. This mechanism automatically cleans up and frees memory occupied by **objects that are no longer in use** or **unreachable**.

---

## **1. What is Garbage Collection (GC)?**

- **Garbage Collection (GC)** is the process in Java that **automatically frees memory** occupied by objects that are no longer referenced or used.
- GC ensures that Java always has sufficient memory available to create new objects without requiring developers to explicitly free memory (as in C, with `free()` or `delete`).
- Java uses a **Garbage Collector**, which runs in the background to periodically identify and remove unused objects from memory.

---

## **2. When Does an Object Become Garbage?**

An object becomes "garbage" or **eligible for garbage collection** when it **no longer has any references pointing to it**. Below are some scenarios where objects can become garbage:

### **Examples of Unused Objects**

#### **Example 1: An object with no reference**
```java
public class GarbageExample {
    public static void main(String[] args) {
        String str = new String("Hello, Java!");
        str = null; // The "Hello, Java!" object is now eligible for garbage collection
    }
}
```
- When `str = null`, the `"Hello, Java!"` object no longer has any references pointing to it, making it eligible for garbage collection.

---

#### **Example 2: Reassigning a reference**
```java
public class GarbageExample {
    public static void main(String[] args) {
        String str1 = new String("First String");
        String str2 = new String("Second String");

        str1 = str2; // The "First String" object is now eligible for garbage collection
    }
}
```
- Here, the variable `str1` initially referenced the `"First String"` object. When `str1` is reassigned to `str2`, the `"First String"` object becomes garbage because no references point to it.

---

#### **Example 3: Objects of a class no longer referenced**
```java
class MyClass {
    int x;
}

public class GarbageExample {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        obj1 = obj2; // The object initially pointed to by obj1 is now garbage
    }
}
```
- The variable `obj1` was initially referencing an object of `MyClass`. When its reference is reassigned to `obj2`, the object previously referenced by `obj1` becomes unreachable and is eligible for garbage collection.

---

## **3. How Does the Garbage Collector Work?**

### **a) GC Algorithm**
1. **Mark Phase:** The Garbage Collector identifies all the objects that are still being referenced (reachable objects).
2. **Sweep Phase:** The Garbage Collector frees the memory of all the objects that are no longer reachable.

---

### **b) When Does the GC Run?**
- The JVM decides **when** to run the Garbage Collector automatically, usually based on:
  1. **Low memory:** When the heap memory runs low, the JVM attempts to free up memory.
  2. **Memory optimization:** When the JVM deems it necessary to improve resource utilization.

---

### **c) Suggesting the Garbage Collector to Run**
- You can **request** the Garbage Collector to run using the following methods:
  ```java
  System.gc(); // Request the Garbage Collector to run
  Runtime.getRuntime().gc();
  ```
- Important: These methods only **suggest** that the JVM should run the Garbage Collector. There is no guarantee that the GC will execute immediately.

#### **Example:**
```java
public class GarbageExample {
    public static void main(String[] args) {
        GarbageExample obj = new GarbageExample();

        obj = null; // Make the object eligible for garbage collection
        System.gc(); // Suggest JVM to run Garbage Collector
    }

    // The finalize method is called before the object is garbage collected
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collected");
    }
}
```

**Output:**
```
Garbage Collected
```

**Explanation:**
- When `obj` is set to `null`, the object becomes eligible for garbage collection.
- The `finalize()` method is invoked by the garbage collector before reclaiming the memory of the object.

---

## **4. Important Points About Garbage Collection**

1. **You Cannot Fully Control GC:**
   - The Garbage Collection process is fully managed by the JVM. You **cannot force GC** to run immediately.
   - Even if you call `System.gc()`, the JVM decides whether or not to execute it.

2. **The `finalize()` Method (Deprecated):**
   - The `finalize()` method is invoked once by the garbage collector before an object is destroyed.
   - However, this method is **deprecated** (discouraged) starting from Java 9, as it can lead to unpredictable behavior and performance degradation.

---

## **5. Advantages of Garbage Collection**

- **Automatic Memory Management:**
  - Developers don't need to explicitly free up memory for unused objects, making programming easier and less error-prone.
- **Prevents Dangling Pointer Errors:**
  - GC eliminates risks associated with accessing invalid memory locations, as seen in low-level programming languages.

---

## **6. Life Cycle of an Object in Java**

1. **Object Creation:**
   - An object is created using the `new` keyword, and memory for it is allocated on the heap.
   ```java
   MyClass obj = new MyClass();
   ```
2. **Object in Use:**
   - The object will remain in use as long as at least one reference is pointing to it.
3. **Becomes Unreferenced:**
   - When no reference points to the object, it becomes "garbage."
4. **Garbage Collection:**
   - The Garbage Collector runs and releases the memory occupied by the garbage.

---

## **7. Common Garbage Collection Algorithms in JVM**

The JVM supports different garbage collection algorithms, including:
1. **Serial Garbage Collector:**
   - Single-threaded, suitable for single-threaded applications.
2. **Parallel Garbage Collector:**
   - Multi-threaded Garbage Collector for multi-threaded applications.
3. **G1 Garbage Collector:**
   - Optimized for applications requiring low-latency.
4. **Z Garbage Collector (Java 11+):**
   - Modern GC designed to minimize latency.

You can choose the Garbage Collector using JVM parameters, for example:
```bash
java -XX:+UseG1GC MyApplication
```

---

## **8. Summary**

- **Garbage Collection** is an automatic feature in Java that manages memory for unused objects.
- **The Garbage Collector (GC)** runs in the background and decides when to clean up memory.
- Developers should avoid holding references to unused objects to optimize memory usage.
- Using `System.gc()` is only a **suggestion** to run the Garbage Collector, but it is not guaranteed.

Garbage Collection is one of the key features of Java that makes it a **safe and reliable programming language**, reducing the risks associated with manual memory management in languages like C/C++.
