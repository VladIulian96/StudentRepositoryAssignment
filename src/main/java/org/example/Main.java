package org.example;

public class Main {

    public static void main( String[] args ) throws InputException {

        StudentRepository studentRepository = new StudentRepository();

        Student albert = new Student("Albert", "Ionel", "1/5/2003", "Male", "2948356832992");
        Student daniel = new Student("Daniel", "Dan", "13/5/2003", "Male", "1937582957382");
        Student mihai = new Student("Mihai", "Razvan", "1/5/2001", "Male", "5827583928174");

        studentRepository.addStudent(albert);
        studentRepository.addStudent(daniel);
        studentRepository.addStudent(mihai);

        studentRepository.getAllStudentsByAge(20);

    }

}
