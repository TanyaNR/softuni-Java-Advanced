package Advanced.O3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class O5_AverageStudentsGrades {
    public static <grade> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> student = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double grade = Double.parseDouble(inputData[1]);

            if (student.containsKey(name)) {
                List<Double> currentList = student.get(name);
                currentList.add(grade);
                student.put(name, currentList);
            } else {
                student.put(name, new ArrayList<Double>(Collections.singleton(grade)));
            }
        }

        student.entrySet().forEach(
                stringListEntry -> System.out.printf("%s -> %s (avg: %.2f)%n"
                        ,stringListEntry.getKey(), getStringValue(stringListEntry), getAvgValue(stringListEntry)));
    }

    private static Object getAvgValue(Map.Entry<String, List<Double>> stringListEntry) {
        List<Double> current = stringListEntry.getValue();
        double adg = 0;
        for (int i = 0; i < current.size(); i++) {
            adg = adg + current.get(i);
        }
        adg = adg / current.size();
        return adg;
    }

    private static Object getStringValue(Map.Entry<String, List<Double>> stringListEntry) {
        List<Double> current = stringListEntry.getValue();
        String value = current.stream().map(n -> String.format("%.2f", n)).collect(Collectors.joining(" "));
        return value;
    }
}
