package OOP.O3_Inheritance.E02_zoo;

public class Main {
    public static void main(String[] args) {

        String name = "Family Animals";

        Reptile reptile = new Reptile(name);
        Lizard lizard = new Lizard(name);
        Snake snake = new Snake(name);
        Mammal mammal = new Mammal(name);
        Gorilla gorilla = new Gorilla(name);
        Bear bear = new Bear(name);

        System.out.println(reptile.getName());
        System.out.println(lizard.getName());
        System.out.println(snake.getName());
        System.out.println(mammal.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());
    }
}
