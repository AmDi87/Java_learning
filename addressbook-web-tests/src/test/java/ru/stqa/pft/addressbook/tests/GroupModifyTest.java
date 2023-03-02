package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModifyTest extends TestBase{
    @Test
    public void TestModifyGroup() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1 Modify", "test h Modify", "test f Modify"));
        app.getGroupHelper().submitUpdate();
        app.getGroupHelper().returnToGroupPage();
        app.getSessionHelper().logoutAccount();
    }
}