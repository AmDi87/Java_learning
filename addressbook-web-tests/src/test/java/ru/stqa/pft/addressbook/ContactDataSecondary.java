package ru.stqa.pft.addressbook;

public class ContactDataSecondary {
    private final String newGroup;
    private final String address2;
    private final String phone2;
    private final String notes;

    public ContactDataSecondary(String newGroup, String address2, String phone2, String notes) {
        this.newGroup = newGroup;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public String getNewGroup() {
        return newGroup;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }
}
