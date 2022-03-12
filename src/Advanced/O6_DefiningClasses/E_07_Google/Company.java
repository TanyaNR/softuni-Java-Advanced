package Advanced.O6_DefiningClasses.E_07_Google;

public class Company {

    //company {companyName} {department} {salary}
    private String companyName;
    private String department;
    private double salary;


    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return companyName + " " + department + " " + String.format("%.2f", salary);
    }
}
