package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreatedTest extends TestBase {

    @Test
    public void testGroupCreated() throws Exception  {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreated();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", null, "test f"));
        app.getGroupHelper().submitGroupCreated();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before +  1);
        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logoutAccount();
    }

}
