package Advanced.cafe;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee remvedEmployee = null;
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                remvedEmployee = employee;
            }
        }
        if (remvedEmployee == null) {
            return false;
        } else {
            this.employees.remove(remvedEmployee);
            return true;
        }
    }

    public Employee getOldestEmployee() {
        int oldestEmployeeAge = MIN_VALUE;
        Employee oldestEmployee = null;
        for (Employee employee : employees) {
            if (employee.getAge() > oldestEmployeeAge){
                oldestEmployeeAge = employee.getAge();
            }
        }
        for (Employee employee : employees) {
            if (employee.getAge() == oldestEmployeeAge) {
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        Employee searchedEmployee = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                searchedEmployee = employee;
            }
        }
        return searchedEmployee;
    }

    public int getCount() {
        return employees.size();
    }

    //•	report() – returns a string in the following format:
    //o	"Employees working at Cafe {cafeName}:
    //{Employee1}
    //{Employee2}
    //(…)"
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Cafe %s:", getName())).append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
