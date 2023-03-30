package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() +  1));

        assertThat(after, equalTo(before
                .withAdd(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

        app.goTo().gotoHomePage();
    }

}
