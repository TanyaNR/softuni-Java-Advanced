package Advanced.O4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E1_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));
        for (String line : lines) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                sum += currentChar;
            }
            System.out.println(sum);
        }

    }
}
