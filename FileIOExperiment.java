package test2;

import java.io.*;

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

        // 2. 读取文件
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nReading from the file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(new File(".").getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
}