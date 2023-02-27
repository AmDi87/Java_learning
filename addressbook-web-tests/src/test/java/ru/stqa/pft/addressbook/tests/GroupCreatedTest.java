package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreatedTest extends TestBase {

    @Test
    public void testGroupCreated() throws Exception  {
        app.gotoGroupPage();
        app.initGroupCreated();
        app.fillGroupForm(new GroupData("Test1", "test h", "test f"));
        app.submitGroupCreated();
        app.returnToGroupPage();
        app.logoutAccount();
    }

}
