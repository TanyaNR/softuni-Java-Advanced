package Advanced.O4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E5_LineNumbers {
    public static void main(String[] args) throws IOException {
        //1. прочитаме всички редове
        //2. обхождаме всеки един от редовете -> отпечатвам го с номер на реда
        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("output_line_numbers.txt");
        int number = 1;
        for (String line : allLines) {
            writer.println(number + ". " + line);
            number++;
        }

        writer.close(); //спирам да пиша във файла и файлът се затваря
    }
}
