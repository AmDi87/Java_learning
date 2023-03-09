package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreatedTest extends TestBase {

    @Test
    public void testGroupCreated() throws Exception  {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreated();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", null, "test f"));
        app.getGroupHelper().submitGroupCreated();
        app.getGroupHelper().returnToGroupPage();
        app.getSessionHelper().logoutAccount();
    }

}
