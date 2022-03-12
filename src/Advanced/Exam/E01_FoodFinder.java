package Advanced.Exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vowels = (scanner.nextLine().split("\\s+"));
        String[] consonants = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vowelQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        addStack(consonants,consonantsStack);
        addQueue(vowels,vowelQueue);

        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";

        int pearCount = pear.length();
        int flourCount = flour.length();
        int porkCount = pork.length();
        int oliveCount = olive.length();

        int totalWordsFound = 0;
        List<String> wordsFound = new ArrayList<>();

        while (!consonantsStack.isEmpty()) {
            String currentVowel = vowelQueue.poll();
            String currentConsonant = consonantsStack.pop();
            vowelQueue.offerLast(currentVowel);

            if (pear.contains(currentVowel)) {
                pear = pear.replace(currentVowel, "");
                pearCount--;
            }
            if (flour.contains(currentVowel)) {
                flour = flour.replace(currentVowel, "");
                flourCount--;
            }
            if (pork.contains(currentVowel)) {
                pork = pork.replace(currentVowel, "");
                porkCount--;
            }
            if (olive.contains(currentVowel)) {
                olive = olive.replace(currentVowel, "");
                oliveCount--;
            }


            if (pear.contains(currentConsonant)) {
                pear = pear.replace(currentConsonant, "");
                pearCount--;
            }
            if (flour.contains(currentConsonant)) {
                flour = flour.replace(currentConsonant, "");
                flourCount--;
            }
            if (pork.contains(currentConsonant)) {
                pork = pork.replace(currentConsonant, "");
                porkCount--;
            }
            if (olive.contains(currentConsonant)) {
                olive = olive.replace(currentConsonant, "");
                oliveCount--;
            }


        }


        if(pearCount==0){
            totalWordsFound++;
            wordsFound.add("pear");
        }

        if(flourCount==0){
            totalWordsFound++;
            wordsFound.add("flour");
        }
        if(porkCount==0){
            totalWordsFound++;
            wordsFound.add("pork");
        }
        if(oliveCount==0){
            totalWordsFound++;
            wordsFound.add("olive");
        }
        System.out.printf("Words found: %d%n",totalWordsFound);
        for (String word : wordsFound) {
            System.out.println(word);
        }
    }


    public static void addStack(String[] arr, ArrayDeque<String> stack) {
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
    }

    public static void addQueue(String[] arr, ArrayDeque<String> queue) {
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
    }
}
