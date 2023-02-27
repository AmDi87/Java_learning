package ru.stqa.pft.addressbook.model;

public class ContactDataBirthdayAnniversary {

    private final String aday;
    private final String amonth;
    private final String ayear;

    private final String bday;
    private final String bmonth;
    private final String byear;

    public ContactDataBirthdayAnniversary(String bday, String bmonth, String byear, String aday, String amonth, String ayear) {
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;

        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
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
}
