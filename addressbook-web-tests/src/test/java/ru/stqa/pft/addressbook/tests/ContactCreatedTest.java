package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData (
                "John", "Vlad", "Doe", "Nick",
                "title", "Company", "address",
                "89002000600", "88002000600", "87002000600", "86002000600",
                "email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru",
                "28", "August", "1991",
                "30", "January", "1990",
                "homepage",
                "[none]",
                "addressSecondary", "homeSecondary", "notesSecondary");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() +  1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

        app.goTo().gotoHomePage();
    }
}
