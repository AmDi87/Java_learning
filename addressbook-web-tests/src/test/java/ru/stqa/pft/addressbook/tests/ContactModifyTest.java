package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModifyTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().list().size() ==0) {
            app.contact().create(new ContactData("John", "Vlad", "Doe", "Nick",
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
        List<ContactData> before = app.contact().list();

        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(),"John Modify", "Vlad Modify", "Doe Modify", "Nick Modify",
                "title", "Company", "address",
                "890020006009", "880020006008", "870020006007", "860020006006",
                "1email1.test@mail.ru", "2email2@mail.ru", "3email3@mail.ru",
                "28", "August", "1992",
                "30", "January", "1991",
                "homepage1",
                null,
                "addressSecondary1", "homeSecondary1", "notesSecondary1");
        app.contact().modify(index, contact);

        List<ContactData> after = app.contact().list();
            Assert.assertEquals(after.size(), before.size());

            before.remove(index);
            before.add(contact);

            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before,after);
    }
}