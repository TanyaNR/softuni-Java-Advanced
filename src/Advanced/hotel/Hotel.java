package Advanced.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public List<Person> getHotel() {
        return roster;
    }

    public void setHotel(List<Person> hotel) {
        this.roster = hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add (Person person) {
        boolean isThereSamePerson = false;
        for (Person person1 : this.roster) {
            if (person1.getName().equals(person.getName())) {
                isThereSamePerson = true;
            }
        }
        if ( !isThereSamePerson && getHotel().size() < getCapacity()) {
            this.roster.add(person);
        }
    }

    public boolean remove (String name) {
        Person removedPerson = null;
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                removedPerson = person;
            }
        }

        if (removedPerson == null) {
            return false;
        } else {
            this.roster.remove(removedPerson);
            return true;
        }
    }

    public Person getPerson (String name, String hometown) {
        Person getPerson = null;
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                getPerson = person;
                if (getPerson.getHometown().equals(hometown)) {
                    return getPerson;
                }
            }
        }
        return getPerson;
    }

    public int getCount() {
        return this.roster.size();
    }

    //o	"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:", getName())).append(System.lineSeparator());
        for (Person person : roster) {
            sb.append(person).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
