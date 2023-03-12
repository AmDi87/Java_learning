package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactIData;

public class ContactModifyTest extends TestBase {
    @Test
    public void TestModifyContact() throws Exception {
        app.getContactHelper().editContact();
        app.getContactHelper().fillInfoContact(new ContactIData(
                "John Modify", "Vlad Modify", "Doe Modify", "Nick Modify",
                "title", "Company", "address",
                "890020006009", "880020006008", "870020006007", "860020006006",
                "1email1.test@mail.ru", "2email2@mail.ru", "3email3@mail.ru",
                "28", "August", "1992",
                "30", "January", "1991",
                "homepage1",
                null,
                "addressSecondary1", "homeSecondary1", "notesSecondary1"), false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
        app.getSessionHelper().logoutAccount();
    }
}
