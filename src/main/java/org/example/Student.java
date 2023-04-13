package org.example;

public class Student {

    private String firstName;
    private String lastName;
    private final String dateOfBirth;
    private final String gender;
    private final String CNP;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CNP = CNP;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCNP() {
        return CNP;
    }

}
