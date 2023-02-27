package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletedTest extends TestBase {

    @Test
    public void testGroupDeleted() throws Exception {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupPage();
    }

}
