package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class O2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guestList = scanner.nextLine();
        Set<String> guest = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while ( ! guestList.equals("PARTY")) {
            char first = guestList.charAt(0);
            if (Character.isDigit(first)) {
                guest.add(guestList);
            } else {
                regular.add(guestList);
            }
            guestList = scanner.nextLine();
        }

        String comeGuest = scanner.nextLine();
        while ( ! comeGuest.equals("END")) {
            char first = comeGuest.charAt(0);
            if (Character.isDigit(first)) {
                guest.remove(comeGuest);
            } else {
                regular.remove(comeGuest);
            }
            comeGuest = scanner.nextLine();
        }

        int countGuest = guest.size() + regular.size();
        System.out.println(countGuest);
        for (String s : guest) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }

    }
}
