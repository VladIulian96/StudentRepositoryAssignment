package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    public Map<String, Student> studentMap = new HashMap<>();
    public List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) throws InputException {
        if(student.getFirstName().isEmpty()) {
            throw new InputException("First name is empty!");
        }
        if(student.getLastName().isEmpty()) {
            throw new InputException("Last name is empty!");
        }

        if(student.getCNP().length() != 13) {
            throw new InputException("Invalid CNP!");
        }

        if(studentMap.containsKey(student.getCNP())) {
            throw new InputException("Student " + student.getFirstName() + " " + student.getLastName() +  " is already in the list!");
        }

        if(!(student.getGender().equalsIgnoreCase("male") || student.getGender().equalsIgnoreCase("m") ||
             student.getGender().equalsIgnoreCase("female") || student.getGender().equalsIgnoreCase("f"))) {
            throw new InputException("Gender is not valid!");
        }
        if(calculateStudentAge(student) < 18) {
            throw new InputException("That person is not a student!");
        }

        studentMap.put(student.getCNP(), student);
        studentList.add(student);
    }

    public void deleteStudentByCNP(String cnp) {
        if(studentMap.containsKey(cnp)) {
            studentList.remove(studentMap.get(cnp));
            studentMap.remove(cnp);
            System.out.println("Deleted student with ID:" + cnp);
        } else if(cnp.isEmpty()){
            throw new RuntimeException("CNP is empty!");
        } else {
            throw new RuntimeException("Student does not exist!");
        }
    }

    public void getAllStudentsByAge(int age) throws InputException {
        int studentsFound = 0;
        System.out.println("Students found with the age of " + age + ":");
        for(Map.Entry<String, Student> studentEntry : studentMap.entrySet()) {
            if(calculateStudentAge(studentEntry.getValue()) <= 0) {
                throw new InputException("Age is negative!");
            }

            if(calculateStudentAge(studentEntry.getValue()) == age) {
                System.out.println("firstName:" + studentEntry.getValue().getFirstName() + " lastName:" + studentEntry.getValue().getLastName() + " age:" + calculateStudentAge(studentEntry.getValue()));
                studentsFound++;
            }
        }
        if(studentsFound == 0) {
            System.out.println("None");
        }
    }

    public void listStudents() throws InputException {
        if(studentMap.isEmpty() || studentList.isEmpty()) {
            throw new RuntimeException("List is empty!");
        }

        for(Student student : studentList) {
            System.out.println("FirstName:" + student.getFirstName() + " LastName:" + student.getLastName() + " Age:" + calculateStudentAge(student));
        }
    }

    public void sortStudentsByAge() {
        studentList.sort(new StudentComparatorByAge());
    }

    public int calculateStudentAge(Student student) throws InputException {
        int slashCount = 0;
        char[] dateOfBirthCharacters = student.getDateOfBirth().toCharArray();
        for(char character : dateOfBirthCharacters) {
            if(character == '/') {
                slashCount++;
            }
        }

        if(slashCount != 2) {
            throw new InputException("Invalid date format for student " + student.getFirstName() + " " + student.getLastName());
        }

        String[] dateOfBirth = student.getDateOfBirth().split("/");
        int birthYear = Integer.parseInt(dateOfBirth[2]);
        int currentYear = LocalDate.now().getYear();
        int studentAge = currentYear - birthYear;

        return studentAge;
    }



}
