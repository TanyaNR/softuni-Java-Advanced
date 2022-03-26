package OOP.O7_ReflectionAndAnnotation.O2_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("get") && e.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Method[] setters = Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("set") && e.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(e -> System.out.printf("%s will return class %s%n", e.getName(), e.getReturnType().getName()));

        Arrays.stream(setters).forEach(e -> System.out.printf("%s and will set field of class %s%n", e.getName(), e.getParameterTypes()[0].getName()));

    }
}
