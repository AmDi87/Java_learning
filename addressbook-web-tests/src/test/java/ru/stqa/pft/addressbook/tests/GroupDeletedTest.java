package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletedTest extends TestBase {

    @Test
    public void testGroupDeleted() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        app.getSessionHelper().logoutAccount();
    }

}
