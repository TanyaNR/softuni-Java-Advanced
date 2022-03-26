package OOP.O7_ReflectionAndAnnotation.O3_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Field[] fields = Reflection.class.getDeclaredFields();
        Field[] checkedFields = Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);
        Arrays.stream(checkedFields).forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] getters = Reflection.class.getDeclaredMethods();
        Method[] checkedGetters = Arrays.stream(getters)
                .filter(getter -> getter.getName().startsWith("get") && getter.getParameterCount() == 0)
                .filter(getter -> !Modifier.isPublic(getter.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(checkedGetters).forEach(getter -> System.out.printf("%s have to be public!%n", getter.getName()));

        Method[] setters = Reflection.class.getDeclaredMethods();
        Method[]checkedSetter = Arrays.stream(setters)
                .filter(setter -> setter.getName().startsWith("set") && setter.getParameterCount() == 1)
                .filter(setter -> !Modifier.isPrivate(setter.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(checkedSetter).forEach(setter -> System.out.printf("%s have to be private!%n", setter.getName()));

    }
}
