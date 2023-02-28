package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        app.gotoContactNew();
        app.fillInfoContact(new ContactIDataInfoContact(
                "John", "Vlad", "Doe", "Nick",
                "title", "Company", "address",
                "89002000600", "88002000600", "87002000600", "86002000600",
                "email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru",
                "28", "August", "1991",
                "30", "January", "1990",
                "homepage",
                "[none]",
                "addressSecondary", "homeSecondary", "notesSecondary"));
        app.fillDownloadJpg();
        app.submitContactCreated();
        app.returnToHomePage();
        app.logoutAccount();
    }
}
