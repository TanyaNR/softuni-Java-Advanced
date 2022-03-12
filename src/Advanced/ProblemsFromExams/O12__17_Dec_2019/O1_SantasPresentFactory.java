package Advanced.ProblemsFromExams.O12__17_Dec_2019;

import java.util.*;

public class O1_SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        String[] secondLine = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(firstLine)
                .map(Integer::parseInt).forEach(materialsStack::push);

        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(secondLine)
                .map(Integer::parseInt).forEach(magicLevelQueue::offer);

        Map<String, Integer> craftToys = new TreeMap<>();

        int countDoll = 0;
        int countWoodenTrain = 0;
        int countTeddyBear = 0;
        int countBicycle = 0;

        while ( !materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int materialsValue = materialsStack.peek();
            int magicLevelValue = magicLevelQueue.peek();
            int neededMagic = materialsValue * magicLevelValue;
            String toy = "";

            switch (neededMagic) {
                case 150:
                    toy = "Doll";
                    countDoll++;
                    addCraftToys(craftToys, materialsStack, magicLevelQueue, toy);
                    break;
                case 250:
                    toy = "Wooden train";
                    countWoodenTrain++;
                    addCraftToys(craftToys, materialsStack, magicLevelQueue, toy);
                    break;
                case 300:
                    toy = "Teddy bear";
                    countTeddyBear++;
                    addCraftToys(craftToys, materialsStack, magicLevelQueue, toy);
                    break;
                case 400:
                    toy = "Bicycle";
                    countBicycle++;
                    addCraftToys(craftToys, materialsStack, magicLevelQueue, toy);
                    break;
            }

            if (neededMagic < 0) {
                materialsStack.pop();
                magicLevelQueue.poll();
                materialsStack.push(materialsValue + magicLevelValue);
            }

            if (neededMagic > 0 && neededMagic != 150 && neededMagic != 250 && neededMagic != 300 && neededMagic != 400) {
                magicLevelQueue.poll();
                materialsStack.pop();
                materialsStack.push(materialsValue + 15);
            }

            if (magicLevelValue == 0) {
                magicLevelQueue.poll();
            }

            if (materialsValue == 0) {
                materialsStack.pop();
            }
        }

        if ((countWoodenTrain != 0 && countDoll != 0) || (countBicycle != 0 && countTeddyBear != 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if ( !materialsStack.isEmpty()) {
            getMaterialLeft(materialsStack);
        }

        if ( !magicLevelQueue.isEmpty()) {
            getMagicLeft(materialsStack, magicLevelQueue);
        }

        if (craftToys.size() != 0) {
            printCraftToy(craftToys);
        }
    }




    private static void printCraftToy(Map<String, Integer> craftToys) {
        for (Map.Entry<String, Integer> stringIntegerEntry : craftToys.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
    }

    private static void getMagicLeft(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicLevelQueue) {
        int firstMagic = materialsStack.pop();
        System.out.print("Magic left: " + firstMagic);
        for (Integer integer : magicLevelQueue) {
            System.out.print(", " + integer);
        }
        System.out.println();
    }

    private static void getMaterialLeft(ArrayDeque<Integer> materialsStack) {
        int firstMaterial = materialsStack.pop();
        System.out.print("Materials left: " + firstMaterial);
        for (Integer integer : materialsStack) {
            System.out.print(", " + integer);
        }
        System.out.println();
    }

    private static void addCraftToys(Map<String, Integer> craftToys, ArrayDeque<Integer> firstStack,
                                     ArrayDeque<Integer> secondStack, String toy) {
        int countToy = 1;
        if (craftToys.containsKey(toy)) {
            int cutrrentCount = craftToys.get(toy);
            cutrrentCount++;
            craftToys.put(toy, cutrrentCount);
        } else {
            craftToys.putIfAbsent(toy, countToy);
        }
        firstStack.pop();
        secondStack.pop();
    }
}
