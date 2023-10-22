package test2;
/*ava 提供了丰富的输入/输出 (I/O) 类库来处理各种 I/O 操作。这里，我将为你演示两个基本的 I/O 操作：

从控制台读取输入：使用 java.util.Scanner 类。
向控制台写入输出：使用 System.out.println() 方法。
下面是一个简单的实验，用户会被提示输入他们的名字，然后程序会向他们发送问候。 */
import java.util.Scanner;

public class IOExperiment{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello," + name + "!");
        scanner.close();
    }
}
/*Scanner 类：它是 Java 标准库中的一个实用工具类，可以用来读取各种输入，包括从控制台、文件等。在这个例子中，我们使用 nextLine() 方法从控制台读取一个完整的行。
System.out.println()：这是 Java 中最常用的向控制台输出文本的方法。
这个实验简单地展示了如何使用 Java 进行基本的控制台输入和输出操作。为了进一步探索 Java 的 I/O 功能，你可能还需要学习如何读写文件、如何使用数据流、如何处理序列化等。 */