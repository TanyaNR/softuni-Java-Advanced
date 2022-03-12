package Advanced.O4_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class O2_WriteToFile {
    public static void main(String[] args) {

        String patchIn = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";
        String patchOut = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\02.WriteToFileOutput.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (InputStream inputFile = new FileInputStream(patchIn);
             OutputStream outputFile = new FileOutputStream(patchOut)) {
            int oneByte = inputFile.read();
            while (oneByte >= 0) {
                char charOfOneByte = (char) oneByte;
                if (!punctuation.contains(charOfOneByte)) {
                    outputFile.write(oneByte);
                    System.out.printf("%s", charOfOneByte);
                }

                oneByte = inputFile.read();
            }

        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }
}
