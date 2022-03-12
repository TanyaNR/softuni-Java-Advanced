package Advanced.O8_IteratorsAndComparators.E06_StrategyPattern;

import java.util.Locale;

public class Person  {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(getName() + " " + getAge());
    }

}
