

public class StringArgsDemo {
    public static void main(String[] args){
        if(args.length > 0){
            System.out.println("接收到以下命令行参数：");
            for (int i = 0; i < args.length; i++){
                System.out.println("参数" + (i + 1)+ ":" + args[i]);
            }
        }else{
            System.out.println("没有接收到命令行参数");
        }
    }
}

/*
1.编译Java代码。在命令提示符中，使用javac命令编译StringArgsDemo.java文件，如下所示：
javac StringArgsDemo.java
如果代码没有错误，这将生成一个名为StringArgsDemo.class的字节码文件。

2.运行Java程序。在命令提示符中，使用java命令来运行编译后的程序，如下所示：
java com.lin.mypackage.StringArgsDemo arg1 arg2 arg3

请将arg1、arg2和arg3替换为您想要传递给main方法的命令行参数。运行后，程序将检查传递的参数并输出相应的消息。

例如，如果您运行以下命令：

java com.lin.mypackage.StringArgsDemo hello world

则输出将如下所示：

接收到以下命令行参数：
参数1: hello
参数2: world



*/
