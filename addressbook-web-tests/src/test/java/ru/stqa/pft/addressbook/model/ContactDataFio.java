package ru.stqa.pft.addressbook.model;

public class ContactDataFio {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public ContactDataFio(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

}
