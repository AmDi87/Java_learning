package ru.stqa.pft.addressbook.model;

public class ContactDataFioNick {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;

    public ContactDataFioNick(String firstName, String middleName, String lastName, String nickName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
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
    public String getNickName() {
        return nickName;
    }

}
