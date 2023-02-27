package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        gotoContactNew();
        fillBlockFio(new ContactDataFio("John", "Vlad", "Doe"));
        fillBlockNick("Test");
        fillBlockTitleCompanyAddress(new ContactDataTitleCompanyAddress("title", "Company", "address"));
        fillBlockTelephone(new ContactDataTelephone("89002000600", "88002000600", "87002000600", "86002000600"));
        fillBlockEmail(new ContactDataEmail("email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru"));
        fillHomepage("homepage");
        fillBirthday(new ContactDataBirthday("28", "August", "1991"));
        fillAnniversary(new ContactDataAnniversary("30", "January", "1990"));
        fillSecondary(new ContactDataSecondary("test", "addressSecondary", "homeSecondary", "notesSecondary"));
        fillDownloadJpg();
        submitContactCreated();
        returnToHomePage();
        logoutAccount();
    }
}
