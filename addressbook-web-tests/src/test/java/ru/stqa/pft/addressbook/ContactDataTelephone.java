package ru.stqa.pft.addressbook;

public class ContactDataTelephone {
    private final String homeTelephone;
    private final String mobileTelephone;
    private final String workTelephone;
    private final String faxTelephone;

    public ContactDataTelephone(String homeTelephone, String mobileTelephone, String workTelephone, String faxTelephone) {
        this.homeTelephone = homeTelephone;
        this.mobileTelephone = mobileTelephone;
        this.workTelephone = workTelephone;
        this.faxTelephone = faxTelephone;
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
}
