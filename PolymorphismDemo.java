// 多态演示

/* 在这个例子中，我们将创建一个Animal基类和几个继承自Animal的派生类：Dog和Cat。
每个类都有一个makeSound方法，但每个派生类都有自己的实现。
通过多态，我们可以定义一个Animal类型的引用，并将其指向Dog或Cat的对象，然后调用makeSound方法，而不必知道对象的确切类型。
*/
// 定义Animal基类
abstract class Animal {
    // 抽象方法，子类需要提供具体实现
    public abstract void makeSound();
}

// Dog类继承自Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Cat类继承自Animal
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // 使用Animal引用指向Dog对象
        Animal myDog = new Dog();
        // 使用Animal引用指向Cat对象
        Animal myCat = new Cat();

        // 调用makeSound方法，尽管引用是Animal类型的，但实际上调用的是具体对象的makeSound方法
        myDog.makeSound();  // 输出：Woof!
        myCat.makeSound();  // 输出：Meow!
        
        // 使用方法演示多态
        makeAnimalSound(new Dog()); // 输出：Woof!
        makeAnimalSound(new Cat()); // 输出：Meow!
    }
    
    public static void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }
}

/*使用Animal类型的引用来指向Dog和Cat对象，并成功调用了它们的makeSound方法。这就是多态的魔力！
当我们调用makeSound方法时，Java运行时系统确定应该调用哪个类的方法。这称为动态方法调度或运行时多态。*/