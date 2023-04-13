package org.example;

import java.util.Comparator;

public class StudentComparatorByAge implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        StudentRepository studentRepository = new StudentRepository();
        o1 = (Student) o1;
        o2 = (Student) o2;

        try {
            if(studentRepository.calculateStudentAge(o1) > studentRepository.calculateStudentAge(o2)) {
                return 1;
            }
        } catch (InputException e) {
            throw new RuntimeException("Unable to sort the list");
        }
        return 0;
    }

}
