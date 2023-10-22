package test2;

public class MyRunnable implements Runnable {
    public void run(){
        System.out.println("Running in a separate thread!");
    }
    public static void main(String[] args){
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
/*Runnable 接口是 Java 标准库中的一个接口，主要用于表示一个可以被线程执行的任务。它是 Java 中实现多线程编程的两种主要方式之一，另一种是继承 Thread 类。

Runnable 接口只有一个方法，即 run()，这个方法没有参数，也没有返回值： 
public interface Runnable {
    void run();
}
当你想要并发地运行一段代码时，你可以创建一个实现 Runnable 接口的类，然后在 run 方法中定义你想要执行的任务。

在上面的例子中，MyRunnable 实现了 Runnable 接口，并重写了 run 方法。在 main 方法中，我们创建了一个新的 Thread 对象，将 MyRunnable 的实例传递给它，并启动该线程。这将导致 run 方法在一个单独的线程中执行。

为什么使用 Runnable？

灵活性：由于 Java 不支持多重继承，如果你的类已经继承了另一个类，你不能再继承 Thread 类。但你仍然可以实现 Runnable 接口。
代码重用：你可以将相同的 Runnable 对象传递给多个线程，这样多个线程可以执行相同的代码。
单一职责原则：将线程执行的任务（Runnable）与线程管理（Thread）分开，使代码更加清晰。
总的来说，Runnable 接口提供了一种简洁的方式来定义并发任务，而不需要继承整个 Thread 类。
*/