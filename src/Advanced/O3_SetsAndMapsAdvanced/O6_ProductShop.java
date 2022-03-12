package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class O6_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shopInfo = scanner.nextLine();
        Map<String, Map<String, Double>> shop = new TreeMap<>();

        while ( ! shopInfo.equals("Revision")) {
            String shopName = shopInfo.split(", ")[0];
            Map <String, Double> productInShop = new LinkedHashMap<>();
            String product = shopInfo.split(", ")[1];
            Double price = Double.parseDouble(shopInfo.split(", ")[2]);

            if (shop.containsKey(shopName)) {
                Map<String, Double> currentShop = shop.get(shopName);
                currentShop.put(product, price);
                shop.put(shopName, currentShop);
            } else {
                productInShop.put(product, price);
                shop.put(shopName, productInShop);
            }

            shopInfo = scanner.nextLine();
        }

        for (String s : shop.keySet()) {
            System.out.printf("%s->%n", s);
            Map<String, Double> current = shop.get(s);
            for (String s1 : current.keySet()) {
                double currentPrice = current.get(s1);
                System.out.printf("Product: %s, Price: %.1f%n", s1, currentPrice);
            }
        }
    }
}
