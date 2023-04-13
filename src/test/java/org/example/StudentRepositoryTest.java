package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentRepositoryTest {

    @Test
    void addOneStudentWithInvalidName() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("", "Mihai", "12/3/2000", "M", "0591805131423");

        assertThrows(InputException.class, () -> studentRepository.addStudent(student));
    }

    @Test
    void addOneStudentWithInvalidDateOfBirth() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Daniel", "Mihai", "53", "M", "0591805131423");

        assertThrows(InputException.class, () -> studentRepository.addStudent(student));
    }

    @Test
    void addOneStudentWithInvalidCNP() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Daniel", "Mihai", "12/3/2000", "M", "059");

        assertThrows(InputException.class, () -> studentRepository.addStudent(student));
    }

    @Test
    void addTwoStudentsToSort() throws InputException {
        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Daniel", "Mihai", "1/10/2001", "M", "0591805131423");
        Student student2 = new Student("Razvan", "Gradinaru", "18/2/2003", "M", "9328375849383");
        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.sortStudentsByAge();

        List<Student> studentListTest = new ArrayList<>();
        studentListTest.add(0, student1);
        studentListTest.add(1, student2);

        assertEquals(studentListTest.get(0), studentRepository.studentList.get(0));
    }

}