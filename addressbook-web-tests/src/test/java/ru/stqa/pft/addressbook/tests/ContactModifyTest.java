package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModifyTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().list().size() ==0) {
            app.contact().create(new ContactData()
                    .withFirstName("John").withMiddleName ("Vlad").withLastName("Doe").withNickName("Nick")
                    .withTitle("title").withCompany("Company").withAddress("address")
                    .withHomeTelephone("89002000600").withMobileTelephone("88002000600").withWorkTelephone("87002000600").withFaxTelephone("86002000600")
                    .withEmail1("email1.test@mail.ru").withEmail2("email2@mail.ru").withEmail3("email3@mail.ru")
                    .withBday("28").withBmonth("August").withByear("1991")
                    .withAday("30").withAmonth("January").withAyear("1990")
                    .withHomepage("homepage")
                    .withGroup("[none]")
                    .withAddress2("addressSecondary").withPhone2("homeSecondary").withNotes("notesSecondary"));
        }
    }
    @Test
    public void TestModifyContact() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("John Modify").withMiddleName ("Vlad Modify").withLastName("Doe Modify").withNickName("Nick Modify")
                .withTitle("title").withCompany("Company").withAddress("address")
                .withHomeTelephone("79002000600").withMobileTelephone("78002000600").withWorkTelephone("77002000600").withFaxTelephone("76002000600")
                .withEmail1("email1.test1@mail.ru").withEmail2("1email2@mail.ru").withEmail3("1email3@mail.ru")
                .withBday("28").withBmonth("August").withByear("1991")
                .withAday("30").withAmonth("January").withAyear("1990")
                .withHomepage("homepage1")
                .withGroup("[none]")
                .withAddress2("addressSecondary1").withPhone2("homeSecondary1").withNotes("notesSecondary1");

        app.contact().modify(contact);

        Set<ContactData> after = app.contact().all();
            Assert.assertEquals(after.size(), before.size());

            before.remove(modifiedContact);
            before.add(contact);

            Assert.assertEquals(before,after);
    }
}