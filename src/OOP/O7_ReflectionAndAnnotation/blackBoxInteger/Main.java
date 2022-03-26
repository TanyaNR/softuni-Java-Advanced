package OOP.O7_ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        String input = scanner.nextLine();
        while( !input.equals("END")) {
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            switch (command) {
                case "add":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
                case "subtract":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
                case"multiply":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
                case"divide":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
                case"leftShift":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
                case"rightShift":
                    executedCommand(clazz, methods, innerValue, blackBoxInt, command, value);
                    break;
            }



            input = scanner.nextLine();
        }

        System.out.println();
    }

    private static void executedCommand(Class<BlackBoxInt> clazz, Method[] methods, Field innerValue, BlackBoxInt blackBoxInt, String command, int value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt, value);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
