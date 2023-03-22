package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactNew();
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
        app.getContactHelper().fillInfoContact(contact,true);
        app.getContactHelper().fillDownloadJpg();
        app.getContactHelper().submitContactCreated();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +  1);

       /* int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logoutAccount();
    }
}
