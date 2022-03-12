package Advanced.O4_StreamsFilesAndDirectories;

import java.io.*;

public class O3_CopyBytes {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";
        String pathOut = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\03.CopyBytesOutput.txt";

        try (InputStream inputFile = new FileInputStream(pathIn);
             OutputStream outputFile = new FileOutputStream(pathOut)) {
            int oneByte = inputFile.read();
            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10){
                    outputFile.write((char)oneByte);
                }
                else {
                    String digit = String.valueOf(oneByte);
                    for (int i = 0; i < digit.length(); i++) {
                        outputFile.write(digit.charAt(i));
                    }
                }
                oneByte = inputFile.read();
            }
        }
        catch (IOException e) {
            System.out.println("Sorry");
        }
    }
}
