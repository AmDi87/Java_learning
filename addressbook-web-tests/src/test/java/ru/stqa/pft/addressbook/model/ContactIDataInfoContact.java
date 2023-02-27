package ru.stqa.pft.addressbook.model;

public class ContactIDataInfoContact {
    private final String title;
    private final String company;
    private final String address;

    private final String homeTelephone;
    private final String mobileTelephone;
    private final String workTelephone;
    private final String faxTelephone;

    private final String email1;
    private final String email2;
    private final String email3;

    private final String homepage;

    private final String newGroup;

    public ContactIDataInfoContact(String title, String company, String address,
                                   String homeTelephone, String mobileTelephone, String workTelephone, String faxTelephone,
                                   String email1, String email2, String email3,
                                   String homepage,
                                   String newGroup ) {



        this.title = title;
        this.company = company;
        this.address = address;

        this.homeTelephone = homeTelephone;
        this.mobileTelephone = mobileTelephone;
        this.workTelephone = workTelephone;
        this.faxTelephone = faxTelephone;

        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;

        this.homepage = homepage;

        this.newGroup = newGroup;
    }

    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getAddress() {
        return address;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }
    public String getMobileTelephone() {
        return mobileTelephone;
    }
    public String getWorkTelephone() {
        return workTelephone;
    }
    public String getFaxTelephone() {
        return faxTelephone;
    }

    public String getEmail1() {
        return email1;
    }
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() { return email3; }

    public String getHomepage() {
        return homepage;
    }

    public String getNewGroup() {
        return newGroup;
    }
}

