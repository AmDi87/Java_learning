package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class TestModifyTest extends TestBase{
    @Test
    public void TestModifyTest() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1 Modify", "test h Modify", "test f Modify"));
        app.getGroupHelper().submitUpdate();
        app.getGroupHelper().returnToGroupPage();
        app.getSessionHelper().logoutAccount();
    }
}
