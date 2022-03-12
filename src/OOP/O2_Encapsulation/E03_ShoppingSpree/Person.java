package OOP.O2_Encapsulation.E03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //fields
    private String name;
    private double money;
    private List<Product> products;

    //methods
    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            //isEmpty
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }

    public void buyProduct(Product product) {
        //проверка имам ли пари да купя продукта
        if (this.money >= product.getCost()) {
            //1. ако имам пари -> купуваме -> добавяме продукта в списъка с продукти
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            //2. ако нямаме пари -> не го купуваме -> exception: "{OOP.О4_InterfacesАndAbstraction.O3_4_Hello.OOP.О4_InterfacesАndAbstraction.E01_DefineAnInterfacePerson.OOP.О4_InterfacesАndAbstraction.E04_Food.Person name} can't afford {Product name}"
            String message = this.name + " can't afford " + product.getName();
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }
}
