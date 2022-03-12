package Advanced.O4_StreamsFilesAndDirectories;

import java.io.*;

public class E3_AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //1. прочитаме файла
        //2. обхождаме всеки ред -> правим всички букви главни -> записваме реда в нов файл

        //начин 1
        /*List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            bw.write(line.toUpperCase());
            bw.newLine();
        }
        bw.close();*/

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }
        writer.close();
    }
}
