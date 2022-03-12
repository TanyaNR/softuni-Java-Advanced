package OOP.O4_InterfaceAndAbstraction.E04_Food;

public class Rebel implements Person, Buyer {
    private final String name;
    private final int age;
    private String group;
    private int food = 0;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    public String getGroup() {
        return this.group = group;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
