package Advanced.O8_IteratorsAndComparators.E06_StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = Integer.compare(person1.getName().length(), person2.getName().length());

        if (result == 0) {
            result = person1.getName().toLowerCase(Locale.ROOT).compareTo(person2.getName().toLowerCase(Locale.ROOT));
        }

        return result;
    }
}
