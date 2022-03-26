package OOP.O4_InterfaceAndAbstraction.E05_SmartPhone;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : this.urls) {
            if (isBrowserValid(url)) {
                stringBuilder.append("Browsing: " + url + "!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : this.numbers) {
            if (isNumberValid(number)) {
                stringBuilder.append("Calling... " + number).append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isBrowserValid(String url) {
        for (int i = 0; i < url.length(); i++) {
            char currentChar = url.charAt(i);
            if (Character.isDigit(currentChar)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumberValid(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char currentChar = numbers.charAt(i);
            if (Character.isLetter(currentChar)) {
                return false;
            }
        }
        return true;
    }
}
