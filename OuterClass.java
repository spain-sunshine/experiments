package test2;
public class OuterClass {

    // 成员内部类
    class MemberInnerClass {
        void show() {
            System.out.println("This is a member inner class.");
        }
    }

    // 静态内部类
    static class StaticInnerClass {
        void show() {
            System.out.println("This is a static inner class.");
        }
    }

    void display() {
        // 局部内部类
        class LocalInnerClass {
            void show() {
                System.out.println("This is a local inner class.");
            }
        }
        
        LocalInnerClass local = new LocalInnerClass();
        local.show();
        
        // 匿名内部类
        MyRunnable r = new MyRunnable() {
            public void run() {
                System.out.println("This is an anonymous inner class.");
            }
        };
        
        r.run();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // 创建并使用成员内部类
        MemberInnerClass member = outer.new MemberInnerClass();
        member.show();

        // 创建并使用静态内部类
        StaticInnerClass staticClass = new StaticInnerClass();
        staticClass.show();

        // 局部内部类和匿名内部类在display方法中被使用
        outer.display();
    }
}
/*
成员内部类：它是定义在外部类中的非静态类。你需要一个外部类的实例来创建它的对象。
静态内部类：它是定义在外部类中的静态类。它不能访问外部类的非静态成员。你不需要外部类的实例来创建它的对象。
局部内部类：它是定义在方法中的类。它只能在定义它的方法中被使用。
匿名内部类：它没有名称，通常用于覆盖类或接口的方法。在上面的例子中，我们使用了一个匿名类来实现 Runnable 接口。 */




