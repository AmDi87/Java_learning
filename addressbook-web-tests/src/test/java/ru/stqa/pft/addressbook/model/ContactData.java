package ru.stqa.pft.addressbook.model;

public class ContactData {

    private int id;

    private static String group;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;

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

    private final String aday;
    private final String amonth;
    private final String ayear;

    private final String bday;
    private final String bmonth;
    private final String byear;

    private final String address2;
    private final String phone2;
    private final String notes;

    public ContactData(String firstName, String middleName, String lastName, String nickName,
                       String title, String company, String address,
                       String homeTelephone, String mobileTelephone, String workTelephone, String faxTelephone,
                       String email1, String email2, String email3,
                       String bday, String bmonth, String byear, String aday, String amonth, String ayear,
                       String homepage,
                       String group,
                       String address2, String phone2, String notes) {

        this.id = 0;

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;

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

        this.group = group;

        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;

        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;

        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public ContactData(int id, String firstName, String middleName, String lastName, String nickName,
                       String title, String company, String address,
                       String homeTelephone, String mobileTelephone, String workTelephone, String faxTelephone,
                       String email1, String email2, String email3,
                       String bday, String bmonth, String byear, String aday, String amonth, String ayear,
                       String homepage,
                       String group,
                       String address2, String phone2, String notes) {

        this.id = id;

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;

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

        this.group = group;

        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;

        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;

        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
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

    public String getMobileTelephone() {return mobileTelephone;
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

    public String getAday() {
        return aday;
    }
    public String getAmonth() {
        return amonth;
    }
    public String getAyear() {
        return ayear;
    }

    public String getBday() {
        return bday;
    }
    public String getBmonth() {
        return bmonth;
    }
    public String getByear() {
        return byear;
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

    public static String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}

