package Advanced.O3_SetsAndMapsAdvanced;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class O1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Set<String> parking = new LinkedHashSet<>();

        while ( ! inputLine.equals("END")) {
            String [] parts = inputLine.split(", ");
            String command = parts[0];
            String car = parts[1];
            if (command.equals("IN")) {
                parking.add(car);
            } else {
                parking.remove(car);
            }
            inputLine = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parking) {
                System.out.println(s);
            }
        }
    }
}
