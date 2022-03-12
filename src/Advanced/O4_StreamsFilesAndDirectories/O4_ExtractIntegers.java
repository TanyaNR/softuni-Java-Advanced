package Advanced.O4_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class O4_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";
        String pathOut = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\04.ExtractIntegersOutput.txt";

        PrintWriter myFileOutput = new PrintWriter(new FileOutputStream(pathOut));

        try (Scanner scanner = new Scanner(new FileInputStream(pathIn))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int integer = scanner.nextInt();
                    System.out.println(integer);
                    myFileOutput.println(integer);
                }

                scanner.next();
            }
        } catch (IOException e ) {
            System.out.println("Sorry");
        }
        myFileOutput.close();
    }
}
