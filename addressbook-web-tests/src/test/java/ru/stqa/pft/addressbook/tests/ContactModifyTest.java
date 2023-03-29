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
        List<ContactData> before = app.contact().list();

        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
                .withFirstName("John Modify").withMiddleName ("Vlad Modify").withLastName("Doe Modify").withNickName("Nick Modify")
                .withTitle("title").withCompany("Company").withAddress("address")
                .withHomeTelephone("79002000600").withMobileTelephone("78002000600").withWorkTelephone("77002000600").withFaxTelephone("76002000600")
                .withEmail1("email1.test1@mail.ru").withEmail2("1email2@mail.ru").withEmail3("1email3@mail.ru")
                .withBday("28").withBmonth("August").withByear("1991")
                .withAday("30").withAmonth("January").withAyear("1990")
                .withHomepage("homepage1")
                .withGroup("[none]")
                .withAddress2("addressSecondary1").withPhone2("homeSecondary1").withNotes("notesSecondary1");

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