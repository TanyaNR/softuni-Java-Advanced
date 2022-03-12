package Advanced.O4_StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E6_WordCount {
    public static void main(String[] args) throws IOException, IOException {
        //words.txt -> думи, които ще броим в друг файл
        String pathWords = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        //дума -> бр. срещанията
        Map<String, Integer> countWords = new HashMap<>();

        //1. прочетем всички думи от файла и всяка една дума я съхраним в мап
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        for (String lineWithWords : allLinesWithWords) {
            //lineWithWords = "of which The".split("\\s+") -> ["of", "which", "The"]
            Arrays.stream(lineWithWords.split("\\s+")).forEach(
                    word -> {
                        countWords.put(word, 0);
                    }
            );
        }

        //countWords -> кои са думите, които ще търсим

        //2. прочитаме файла, в който ще търсим
        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        //обхождаме всеки един ред -> взимаме всички думи на всеки ред -> проверяваме дали думата трябва да я преброим (само буквите, които са в мапа)
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            //line = "There are many variations".split("\\s+") -> []
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                        if (countWords.containsKey(word)) {
                            int currentCount = countWords.get(word);
                            countWords.put(word, currentCount + 1);
                        }
                    }
            );

        }

        //знаем коя буква колко пъти се среща
        //3. принтираме резултата
        //сортираме по value
        //запис: ключ(дума) -> value(бр. срещанията)
        PrintWriter writer = new PrintWriter("results.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
        //compareTo -> 0 (първото == второто), 1 (първото > второто), -1 (второто > първото)
        //sorted -> 0 (не разменя местата на записите), 1 (разменя местата на първото и второто), -1 (не разменя местата на записите)

    }
}
