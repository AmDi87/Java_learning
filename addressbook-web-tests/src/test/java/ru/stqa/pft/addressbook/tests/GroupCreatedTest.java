package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreatedTest extends TestBase {

    @Test
    public void testGroupCreated() throws Exception  {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test1").withFooter("test f");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() +  1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before
                .withAdd(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

        app.goTo().gotoHomePage();
    }

    @Test
    public void testBadGroupCreated() throws Exception  {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test1'").withFooter("test f");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));

        app.goTo().gotoHomePage();
    }

}
