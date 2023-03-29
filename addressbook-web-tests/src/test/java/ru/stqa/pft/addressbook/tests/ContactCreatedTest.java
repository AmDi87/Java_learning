package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("John").withMiddleName ("Vlad").withLastName("Doe").withNickName("Nick")
                .withTitle("title").withCompany("Company").withAddress("address")
                .withHomeTelephone("89002000600").withMobileTelephone("88002000600").withWorkTelephone("87002000600").withFaxTelephone("86002000600")
                .withEmail1("email1.test@mail.ru").withEmail2("email2@mail.ru").withEmail3("email3@mail.ru")
                .withBday("28").withBmonth("August").withByear("1991")
                .withAday("30").withAmonth("January").withAyear("1990")
                .withHomepage("homepage")
                .withGroup("[none]")
                .withAddress2("addressSecondary").withPhone2("homeSecondary").withNotes("notesSecondary");

        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() +  1);

        contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);

        app.goTo().gotoHomePage();
    }
}
