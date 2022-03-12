package OOP.O4_InterfaceAndAbstraction.O3_4_Hello;

public class European extends BasePerson{

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
