package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreatedTest extends TestBase {

    @Test
    public void testGroupCreated() throws Exception  {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupCreated();
        GroupData group = new GroupData ("Test1", null, "test f");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreated();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() +  1);


     /*   int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/

       /* group.setId(after.stream().max((o1,o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);

        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logoutAccount();
    }

}
