package Advanced.O4_StreamsFilesAndDirectories;

import java.io.File;

public class O7_ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Tanija\\IdeaProjects\\Advanced\\src\\O4_StreamsFilesAndDirectories\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (!file1.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file1.getName(), file1.length());
                    }
                }
            }
        }

    }
}
