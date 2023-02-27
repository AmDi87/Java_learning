package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreatedTest extends TestBase{

    @Test
    public void testGroupCreated() throws Exception  {
        gotoGroupPage();
        initGroupCreated();
        fillGroupForm(new GroupData("Test1", "test h", "test f"));
        submitGroupCreated();
        returnToGroupPage();
        logoutAccount();
    }

}
