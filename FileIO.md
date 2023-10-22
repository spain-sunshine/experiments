## new File(".")
在 Java 中，new File(".") 创建一个代表当前工作目录的 File 对象。其中 "." 是一个特殊的文件路径，代表当前目录。

解释一下各个部分：

new File(String pathname)：这是 java.io.File 类的构造方法，用于根据给定的路径字符串创建一个新的 File 实例。

"."：这是一个特殊的路径字符串，它代表当前工作目录。在文件系统中，. 总是指代当前目录，而 .. 指代上一级目录。

当你调用 new File(".").getAbsolutePath()，它会返回当前工作目录的绝对路径。这对于确定你的 Java 程序在哪里运行，或者确定文件被写入哪个目录很有用。
## 为什么要用BufferReader，直接用FileReader读取文件不行吗
可以直接使用 FileReader 来读取文件内容，但使用 BufferedReader 有几个主要优势：

缓冲：BufferedReader 为输入提供缓冲，这意味着它会一次从文件中读取较大的数据块（而不是一个字符），然后从这个缓冲区中提供数据。这可以显著提高读取效率，特别是当处理大文件时。

方便的读取方法：BufferedReader 提供了 readLine() 方法，这使得按行读取文本文件变得非常方便。而直接使用 FileReader 时，你可能需要自己实现按行读取的逻辑。

可扩展性：BufferedReader 是 Java I/O 类库中的一个装饰器。这意味着你可以很容易地将它与其他的读取器（如 InputStreamReader）组合起来，以提供其他的功能。

不过，也有些场景你可能不需要缓冲或者其他特性，直接使用 FileReader 就足够了。但在许多常见的文件读取场景中，使用 BufferedReader 都是一个好的选择，因为它提供了效率和方便性。
## 源代码改成用FileReader
```import java.io.*;

public class FileIOExperiment {
    public static void main(String[] args) {
        String fileName = "sample.txt";  // 定义文件名

        // 1. 写入文件
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a simple file I/O experiment in Java.\n");
            writer.write("Java makes file operations relatively easy!");
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }

        // 2. 读取文件 using FileReader
        try (FileReader reader = new FileReader(fileName)) {
            System.out.println("\nReading from the file:");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
}
```
1.移除了 BufferedReader 的引用。

2.在读取文件时，使用了 FileReader 的 read() 方法，它一次读取一个字符。 read() 方法返回 -1 时，表示文件已经读取完毕。

3.由于现在是字符接字符地读取，所以不再有按行读取的便利性。结果会直接打印到控制台，没有行分隔。

这个版本的代码展示了如何使用 FileReader 直接读取文件。虽然这种方法在处理小文件时效果还不错，但在处理大文件或需要按行读取的场景中，BufferedReader 会更加高效和方便。
## 为什么int character，直接用char不行吗？
当你使用 FileReader 的 read() 方法时，它实际上返回一个 int 值，而不是 char。这是为了允许它返回范围在 0 到 65535（包括）之间的所有有效 char 值，以及一个特殊的值 -1，表示已经到达文件的末尾。如果 read() 方法只返回 char，它就不能同时表示所有有效字符和文件结束标记。

因此，我们使用 int 类型的变量 character 来存储返回的值，并在读取文件内容时检查它是否为 -1。当我们需要将其作为字符打印时，我们可以将其转换为 char，如下所示：
```
System.out.print((char) character);
```
如果你直接使用 char，那么在到达文件末尾时，你无法区分返回的是一个实际的字符还是文件结束标记。
## 用char代码
```import java.io.*;

public class FileIOExperiment {
    public static void main(String[] args) {
        String fileName = "sample.txt";  // 定义文件名

        // 1. 写入文件
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a simple file I/O experiment in Java.\n");
            writer.write("Java makes file operations relatively easy!");
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }

        // 2. 读取文件 using FileReader
        try (FileReader reader = new FileReader(fileName)) {
            System.out.println("\nReading from the file:");
            char character;
            while ((character = (char) reader.read()) != 65535) {
                System.out.print(character);
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
}
```
1.将 int character; 改为了 char character;。

2.当检查文件是否结束时，我用 (character = (char) reader.read()) != 65535。但这实际上是不正确的，因为 char 类型无法表示 -1（文件结束）。而将 -1 转换为 char 会得到 65535（即 0xFFFF）。

这种方法的问题是，如果你的文件恰好以字符 65535（0xFFFF）结束，你的循环会提前退出。而在实际应用中，这个字符是一个合法的 Unicode 字符，可能会出现在文件中。因此，使用 int 类型来接收 read() 的返回值是更加安全和正确的做法。
## BufferedReader reader = new BufferedReader(new FileReader(fileName))
这段代码初始化了一个 BufferedReader 对象，它用于从一个文件中读取文本内容。下面是这段代码的逐步解析：

new FileReader(fileName)
FileReader：这是 Java I/O 库中的一个类，它用于读取字符文件。

fileName：这是一个字符串变量，它包含了你想要读取的文件的名称（可能还包含路径）。

当你创建一个 FileReader 的实例时，你告诉它你想要读取哪个文件。

new BufferedReader(...)

BufferedReader：这是 Java I/O 库中的另一个类。它是一个字符输入流，用于从一个字符输入流中读取文本，缓冲字符，以提供字符、数组和行的高效读取。

new FileReader(fileName)：这是一个已经存在的 FileReader 对象，它现在被用作 BufferedReader 的输入源。

通过将 FileReader 传递给 BufferedReader，你创建了一个缓冲的文件读取器。这意味着，而不是每次从文件中读取一个字符，BufferedReader 会一次读取多个字符（通常是一次多行），并将它们存储在内部缓冲区中。

这样，当你要求读取下一个字符或行时，BufferedReader 可以从其内部缓冲区中提供数据，而不是每次都从文件中读取。这大大提高了读取效率。

总结  
这段代码的目的是为了高效地从一个文件中读取文本。BufferedReader 提供了缓冲功能和方便的方法，如 readLine()，以按行读取文本，而 FileReader 则直接从文件中读取字符数据。