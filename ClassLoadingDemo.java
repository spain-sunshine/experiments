class Parent {
    static {
        System.out.println("1. Parent static block");
    }

    {
        System.out.println("2. Parent instance block");
    }

    public Parent() {
        System.out.println("3. Parent constructor");
    }
}

class Child extends Parent {
    static {
        System.out.println("4. Child static block");
    }

    {
        System.out.println("5. Child instance block");
    }

    public Child() {
        System.out.println("6. Child constructor");
    }
}

public class ClassLoadingDemo {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("---");
        Child anotherChild = new Child();
    }
}
//执行结果
/*1. Parent static block
4. Child static block
2. Parent instance block
3. Parent constructor
5. Child instance block
6. Child constructor
---
2. Parent instance block
3. Parent constructor
5. Child instance block
6. Child constructor
 */