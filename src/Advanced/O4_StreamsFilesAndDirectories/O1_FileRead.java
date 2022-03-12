package Advanced.O4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class O1_FileRead {
    public static void main(String[] args) {

        String patch = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";

        try (InputStream inputFile = new FileInputStream(patch)) {
            int oneByte = inputFile.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputFile.read();
            }

        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }
}
