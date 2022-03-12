package Advanced.O4_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class E2_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sumAll = 0;
        BufferedReader br = new BufferedReader(new FileReader(path));

        List<String> list = Files.readAllLines(Path.of(path));
        for (String s : list) {
         int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                sum += currentChar;
            }
        sumAll += sum;
        }
        System.out.println(sumAll);
    }
}
