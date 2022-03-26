import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;

        System.out.println(reflection);

        System.out.println(reflection.getSuperclass());

        Class[] reflectionInterfaces = reflection.getInterfaces();
        for (Class reflectionInterface : reflectionInterfaces) {
            System.out.println(reflectionInterface);
        }

        Object newInstance = reflection.getDeclaredConstructor().newInstance();
        System.out.println(newInstance);
    }
}
