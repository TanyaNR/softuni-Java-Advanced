package OOP.O1_Abstract.O3_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void executeCommand(String[] input) {
        String command = input[0];
        String name = input[1];
        switch (command) {
            case "Create":
                createStudent(input, name);
                break;
            case "Show":
                showStudent(name);
                break;
        }
    }


    private void showStudent(String name) {
        if (repository.containsKey(name)) {
            Student currentStudent = repository.get(name);
            StringBuilder builder = new StringBuilder(currentStudent.toString());
            if (currentStudent.getGrade() >= 5.00) {
                builder.append(" Excellent student.");
            } else if (currentStudent.getGrade() < 5.00 && currentStudent.getGrade() >= 3.50) {
                builder.append(" Average student.");
            } else {
                builder.append(" Very nice person.");
            }

            System.out.println(builder.toString());
        }
    }

    private void createStudent(String[] input, String name) {
        int age = Integer.parseInt(input[2]);
        double grade = Double.parseDouble(input[3]);
        Student student = new Student(name, age, grade);
        repository.putIfAbsent(name, student);
    }
}
