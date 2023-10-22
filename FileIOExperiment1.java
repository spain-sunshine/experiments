package test2;
import java.io.*;

public class FileIOExperiment1 {
    public static void main(String[] args) {
        String fileName = "sample1.txt";  // 定义文件名

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
