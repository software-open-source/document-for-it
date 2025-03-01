package main.org.software.open.source.core;

// Không được trùng tên với interface
public class Common {

    private String name; // Tên loại động vật. Vd: con chó, con mèo
    private int age; // Tuổi

    public Common(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Common(String name) {
        this.name = name;
    }
    
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
        this.age = age;
    }

}
