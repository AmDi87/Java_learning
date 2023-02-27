package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletedTest extends TestBase {

    @Test
    public void testGroupDeleted() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupPage();
    }

}
