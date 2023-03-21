package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModifyTest extends TestBase{
    @Test
    public void TestModifyGroup() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("Test1 Modify", null, "test f"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().editGroup();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"Test1 Modify", "test h", "test f Modify");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitUpdate();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logoutAccount();
    }
}
