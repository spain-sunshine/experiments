// 基类 (父类)
class Animal {
    // 公共属性
    public String name;

    // 受保护的属性，只能被子类和同一包中的类访问
    protected String type;

    // 私有属性，只能在这个类内部访问
    private int age;

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    // 公共方法
    public void eat() {
        System.out.println(name + " is eating.");
    }

    // 受保护的方法
    protected void makeSound() {
        System.out.println("Some sound...");
    }

    // 私有方法
    private void growOld() {
        age += 1;
    }
}

// Dog 类，继承自 Animal 类
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, "Dog", age); // 调用父类的构造方法
    }

    // 重写父类的受保护方法
    @Override
    protected void makeSound() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 5);

        dog.eat();             // 调用从 Animal 类继承的公共方法
        dog.makeSound();       // 调用 Dog 类重写的方法
        dog.fetch();           // 调用 Dog 类特有的方法

        // System.out.println("Dog's name: " + dog.name);  // 访问公共属性
        // 无法访问受保护和私有的属性和方法
        // dog.type;  // 错误
        // dog.age;   // 错误
    }
}
