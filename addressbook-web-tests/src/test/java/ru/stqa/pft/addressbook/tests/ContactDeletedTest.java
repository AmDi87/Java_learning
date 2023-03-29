package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("John", "Vlad", "Doe", "Nick",
                    "title", "Company", "address",
                    "89002000600", "88002000600", "87002000600", "86002000600",
                    "email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru",
                    "28", "August", "1991",
                    "30", "January", "1990",
                    "homepage",
                    "[none]",
                    "addressSecondary", "homeSecondary", "notesSecondary"));
        }
    }

    @Test
    public void TestModifyContact() throws Exception {

            List<ContactData> before = app.getContactHelper().getContactList();
            int index = before.size() - 1;
            app.getContactHelper().selectContact(index);
            app.getContactHelper().submitDeleted();
            app.getContactHelper().okAlert();
            app.getNavigationHelper().gotoHomePage();

            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), index);

            before.remove(index);
            Assert.assertEquals(after, before);
    }
}
