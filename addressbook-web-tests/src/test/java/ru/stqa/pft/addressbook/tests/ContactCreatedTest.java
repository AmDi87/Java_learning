package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreatedTest extends TestBase {

    @Test
    public void testContactCreated() throws Exception {
        Contacts before = app.contact().all();
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
        Contacts after = app.contact().all();
        assertThat(after.size(),equalTo (before.size() +  1));
        assertThat(after, equalTo(
                before.withAdd(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

        app.goTo().gotoHomePage();
    }
}
