package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreated() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initGroupCreated() {
        click(By.name("new"));
    }
    
    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void editGroup() {
        click(By.name("edit"));
    }

    public void submitUpdate() {
        click(By.name("update"));
    }

    public void create(GroupData group) {

        initGroupCreated();
        fillGroupForm(group);
        submitGroupCreated();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        editGroup();
        fillGroupForm(group);
        submitUpdate();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.cssSelector("span[class='group']")).size();
    }

    private Groups groupCache = null;

    public Groups all() {

        if (groupCache != null){
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }
}
