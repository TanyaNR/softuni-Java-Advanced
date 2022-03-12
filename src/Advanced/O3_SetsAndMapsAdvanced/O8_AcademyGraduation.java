package Advanced.O3_SetsAndMapsAdvanced;

import java.util.*;

public class O8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> student = new TreeMap<>();
        while (n-- > 0) {
            String nameStudent = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            student.putIfAbsent(nameStudent, grades);
        }
        for (Map.Entry<String, double[]> stringdoubleEntry : student.entrySet()) {
            System.out.printf("%s is graduated with %s%n", stringdoubleEntry.getKey(), getAvr(stringdoubleEntry.getValue()));
        }
    }

    private static Object getAvr(double[] value) {
        double sum = 0;
        double avr = 0;
        for (Double aDouble : value) {
            sum += aDouble;
        }
        avr = sum / value.length;
        return avr;
    }
}
