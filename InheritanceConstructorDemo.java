// 父类
class Person {
    String name;
    int age;

    // 父类构造函数
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called.");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// 子类
class Student extends Person {
    String studentID;

    // 子类构造函数
    Student(String name, int age, String studentID) {
        super(name, age);  // 调用父类的构造函数
        this.studentID = studentID;
        System.out.println("Student constructor called.");
    }

    @Override
    void display() {
        super.display();  // 调用父类的display方法
        System.out.println("Student ID: " + studentID);
    }
}

public class InheritanceConstructorDemo {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "S12345");
        student.display();
    }
}
