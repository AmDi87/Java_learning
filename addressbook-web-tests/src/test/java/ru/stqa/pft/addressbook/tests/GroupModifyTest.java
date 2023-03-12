package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModifyTest extends TestBase{
    @Test
    public void TestModifyGroup() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("Test1", null, "test f"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1 Modify", "test h", "test f Modify"));
        app.getGroupHelper().submitUpdate();
        app.getGroupHelper().returnToGroupPage();
        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logoutAccount();
    }
}
