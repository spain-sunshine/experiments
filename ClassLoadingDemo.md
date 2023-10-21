## 类加载
Java 的类加载过程主要包括：加载（Loading）、链接（Linking: 验证、准备、解析）和初始化（Initialization）

## 加载：
当 JVM 遇到 Child child = new Child(); 这一行时，它开始加载 Child 类。在此过程中，JVM 也会确保 Parent 类被加载，因为 Child 继承自 Parent。

## 链接：

验证：确保加载的 .class 文件没有被篡改且格式正确。

准备：为类变量分配内存并设置默认值。

解析：将符号引用转换为直接引用。

## 初始化：
这是类加载的最后阶段，其中静态变量被初始化为指定的值，并执行静态代码块。对于上述代码：

首先，Parent 类的静态块被执行。

接着，Child 类的静态块被执行。

当我们创建一个 Child 类的实例时，Parent 的实例初始化块、Parent 的构造函数、Child 的实例初始化块和 Child 的构造函数按顺序执行。

注意，静态块只在类首次加载时执行一次。这就是为什么当我们创建第二个 Child 对象时，静态块没有被再次执行。

## 静态块
静态块，也称为静态初始化块，是Java中的一个特殊结构，用于初始化静态成员（如静态变量）。它在类首次加载到JVM时执行，并且只执行一次。

## 静态块的主要用途：

初始化静态变量：静态变量可以在声明时初始化，但有时我们可能需要执行一些逻辑操作来初始化它们。静态块提供了一个地方来执行这样的初始化操作。

执行一次性操作：如果有某些操作只需要在类加载时执行一次，那么静态块是一个很好的地方。例如，加载本地库或设置一些静态配置。

预加载资源：如果你的类依赖于某些资源，如文件或外部连接，你可能希望在类首次使用前预加载它们。静态块可以帮助你实现这一点。
## 以下是一个示例来说明静态块的用法：
```public class StaticBlockExample {
    
    // 静态变量
    static int staticVariable;

    // 静态块
    static {
        System.out.println("Static block executed!");
        staticVariable = 10;
    }

    public static void main(String[] args) {
        System.out.println("Main method executed!");
        System.out.println("Value of staticVariable: " + staticVariable);
    }
}
```
## 输出：
```Static block executed!
Main method executed!
Value of staticVariable: 10
```
从上述代码中可以看到，静态块在主方法执行前执行，并且初始化了静态变量 staticVariable。这展示了静态块的主要用途之一：初始化静态成员。

## 问题 
怎么就知道System.out.println("2. Parent instance block");
是实例初始化块了？没标注啊

## 答案：
代码中并没有明确标注该块为 "实例初始化块"。但在 Java 中，实例初始化块（也称为初始化块）是定义在类中的非静态块，并且它在每次创建类的实例时执行。实例初始化块的语法是：
    
    {
    // 代码...
    }
它没有前置关键字，也没有名称，只是由一对大括号包围的代码块。所以，当你在 Java 类中看到这样的代码块时，你可以知道它是一个实例初始化块。

与此对应的，静态初始化块是使用 static 关键字定义的：

static {
// 代码...
}

静态初始化块在类首次加载时执行，而实例初始化块在每次创建类的实例时执行。
因此，基于这些特征，我们可以识别并确定给定的代码块是静态的还是实例的。


