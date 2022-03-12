package Advanced.O6_DefiningClasses.E_02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departmentsWithEmployee = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            //name, salary, position, department, email, and age
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];
            Employee employee = null;

            if (inputData.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (inputData.length == 5) {
                String fiftyElement = inputData[4];
                if (fiftyElement.contains("@")) {
                    String email = fiftyElement;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(fiftyElement);
                    employee = new Employee(name, salary, position, department, age);
                }
            }

            if ( !departmentsWithEmployee.containsKey(department)) {
                departmentsWithEmployee.put(department, new ArrayList<>());
                departmentsWithEmployee.get(department).add(employee);
            } else {
                departmentsWithEmployee.get(department).add(employee);
            }
        }

        String departmentWithMaxAvrSalary = departmentsWithEmployee.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> getAvrSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", departmentWithMaxAvrSalary);

        List<Employee> employeeList = departmentsWithEmployee.get(departmentWithMaxAvrSalary);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public static double getAvrSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
