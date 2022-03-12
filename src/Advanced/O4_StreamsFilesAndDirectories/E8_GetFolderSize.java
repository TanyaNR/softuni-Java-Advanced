package Advanced.O4_StreamsFilesAndDirectories;

import java.io.File;

public class E8_GetFolderSize {
    public static void main(String[] args) {
        //1. достъп до папката -> път
        //2. обхождаме всички файлове в папката -> всеки файл взимаме размера -> сумираме
        //3. печатаме общия размер на папката
        String path = "D:\\Work\\Tanja\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0; //размер на папката
        for (File file : allFiles) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
