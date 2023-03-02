package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletedTest extends TestBase{

    @Test
    public void TestModifyContact() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().submitDeleted();
        app.getContactHelper().okAlert();
        app.getContactHelper().gotoHome();
        app.getSessionHelper().logoutAccount();
    }
}
