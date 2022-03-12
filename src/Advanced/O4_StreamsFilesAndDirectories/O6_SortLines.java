package Advanced.O4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class O6_SortLines {
    public static void main(String[] args) throws IOException {

        String pathIn = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\input.txt";
        String pathOut = "C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\06.SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);


    }
}
