package Advanced.O7_Generics.O1_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(8);
        jar.add(78);
        jar.add(548);
        jar.add(253);

        System.out.println(jar.remove());
        System.out.println(jar.peek());
    }
}
