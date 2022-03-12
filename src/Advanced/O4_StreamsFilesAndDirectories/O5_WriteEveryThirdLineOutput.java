package Advanced.O4_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class O5_WriteEveryThirdLineOutput {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";
        String pathOut = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\05.WriteEveryThirdLineOutput.txt";

        PrintWriter myFileOutput = new PrintWriter(new FileOutputStream(pathOut));

        try (Scanner scanner = new Scanner(new FileInputStream(pathIn))) {
            String line = scanner.nextLine();
            int counter = 1;
            while (scanner.hasNext()) {
                if (counter % 3 == 0) {
                    System.out.println(line);
                    myFileOutput.println(line);
                }
                counter ++;
                line = scanner.nextLine();
            }
        } catch (IOException e ) {
            System.out.println("Sorry");
        }
        myFileOutput.close();


    }
}
