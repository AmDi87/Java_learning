package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        app.gotoContactNew();
        app.fillBlockFio(new ContactDataFio("John", "Vlad", "Doe"));
        app.fillBlockNick("Test");
        app.fillBlockTitleCompanyAddress(new ContactDataTitleCompanyAddress("title", "Company", "address"));
        app.fillBlockTelephone(new ContactDataTelephone("89002000600", "88002000600", "87002000600", "86002000600"));
        app.fillBlockEmail(new ContactDataEmail("email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru"));
        app.fillHomepage("homepage");
        app.fillBirthday(new ContactDataBirthday("28", "August", "1991"));
        app.fillAnniversary(new ContactDataAnniversary("30", "January", "1990"));
        app.fillSecondary(new ContactDataSecondary("Test1", "addressSecondary", "homeSecondary", "notesSecondary"));
        app.fillDownloadJpg();
        app.submitContactCreated();
        app.returnToHomePage();
        app.logoutAccount();
    }
}
