package Advanced.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            if ( ! this.students.contains(student)) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return String.format("Student is already in the university");
            }
        } else {
            return String.format("No seats in the university");
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return String.format("Student not found");
        }
    }

    public Student getStudent(String firstName, String lastName) {
        Student searchedStudent = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
              searchedStudent = student;
            }
        }
        return searchedStudent;
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

}
