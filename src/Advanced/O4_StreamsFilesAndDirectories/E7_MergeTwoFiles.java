package Advanced.O4_StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E7_MergeTwoFiles {
    public static void main(String[] args) throws IOException, IOException {
        //1. четем всички редове от файл 1
        String pathFileOne = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        //2. четем всички редове от файл 2
        String pathFileTwo = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        //3. записваме всички редове във файл 3
        PrintWriter writer = new PrintWriter("outputMerge.txt");

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathFileOne)); //всички редове от файл 1
        allLinesFileOne.forEach(line -> writer.println(line));
        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathFileTwo)); //всички редове от файл 2
        allLinesFileTwo.forEach(line -> writer.println(line));

        writer.close();


    }
}
