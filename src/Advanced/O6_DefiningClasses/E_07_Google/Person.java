package Advanced.O6_DefiningClasses.E_07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parents> parents;
    private List<Children> children;

    public Person () {
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

   public List<Pokemon> getPokemons() {
        return this.pokemon;
   }

   public List<Children> getChildren() {
        return this.children;
   }

   public List<Parents> getParents() {
        return this.parents;
   }

   //JohnJohnson
   //Company:
   //OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.Car:
   //Trabant 30
   //Pokemon:
   //Electrode Electricity
   //Parents:
   //Children:


   @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
       builder.append("Company:").append("\n");
       if (company != null) {
           builder.append(company).append("\n");
       }
       builder.append("OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.Car:").append("\n");
       if (car != null) {
           builder.append(car).append("\n");
       }
       builder.append("Pokemon:").append("\n");
       for (Pokemon pokemon1 : pokemon) {
           builder.append(pokemon1).append("\n");
       }
       builder.append("Parents:").append("\n");
       for (Parents parent : parents) {
           builder.append(parent).append("\n");
       }
       builder.append("Children:").append("\n");
       for (Children child : children) {
           builder.append(child).append("\n");
       }
       return builder.toString();
   }

}
