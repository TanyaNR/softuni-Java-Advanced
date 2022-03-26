package OOP.O7_ReflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();
		while ( !command.equals("HARVEST")) {
			switch (command) {
				case "private":
					getPrivate();
					break;
				case "protected":
					getProtected();
					break;
				case "public":
					getPublic();
					break;
				case "all":
					getAll();
					break;
			}


			command = scanner.nextLine();
		}
	}

	private static void getAll() {
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Arrays.stream(fields).forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
	}

	private static void getPublic() {
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Field[] publicField = Arrays.stream(fields)
				.filter(field -> Modifier.isPublic(field.getModifiers()))
				.toArray(Field[]::new);
		Arrays.stream(publicField).forEach(field -> System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName()));
	}

	private static void getProtected() {
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Field[] protectedField = Arrays.stream(fields)
				.filter(field -> Modifier.isProtected(field.getModifiers()))
				.toArray(Field[]::new);
		Arrays.stream(protectedField).forEach(field -> System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName()));
	}

	private static void getPrivate() {
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Field[] privateField = Arrays.stream(fields)
				.filter(field -> Modifier.isPrivate(field.getModifiers()))
				.toArray(Field[]::new);
		Arrays.stream(privateField).forEach(field -> System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName()));
	}


}
