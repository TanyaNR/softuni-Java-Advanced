package Advanced.hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
// "OOP.О4_InterfacesАndAbstraction.O3_4_Hello.OOP.О4_InterfacesАndAbstraction.E01_DefineAnInterfacePerson.OOP.О4_InterfacesАndAbstraction.E04_Food.Person {name}: {id}, Age: {age}, Hometown: {hometown}"
        return String.format("OOP.О4_InterfacesАndAbstraction.O3_4_Hello.OOP.О4_InterfacesАndAbstraction.E01_DefineAnInterfacePerson.OOP.О4_InterfacesАndAbstraction.E04_Food.Person %s: %d, Age: %d, Hometown: %s", getName(), getId(), getAge(), getHometown());
    }
}
