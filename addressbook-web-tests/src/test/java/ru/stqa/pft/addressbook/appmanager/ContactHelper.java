package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillDownloadJpg() {
        type1(By.name("photo"), "H:\\GIT\\123.jpg");
    }

    public void submitContactCreated() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillInfoContact(ContactData сontactInfoContact, boolean creation) {
        type(By.name("firstname"), сontactInfoContact.getFirstName());
        type(By.name("middlename"), сontactInfoContact.getMiddleName());
        type(By.name("lastname"), сontactInfoContact.getLastName());
        type(By.name("nickname"), сontactInfoContact.getNickName());

        type(By.name("title"), сontactInfoContact.getTitle());
        type(By.name("company"), сontactInfoContact.getCompany());
        type(By.name("address"), сontactInfoContact.getAddress());

        type(By.name("home"), сontactInfoContact.getHomeTelephone());
        type(By.name("mobile"), сontactInfoContact.getMobileTelephone());
        type(By.name("work"), сontactInfoContact.getWorkTelephone());
        type(By.name("fax"), сontactInfoContact.getFaxTelephone());

        type(By.name("email"), сontactInfoContact.getEmail1());
        type(By.name("email2"), сontactInfoContact.getEmail2());
        type(By.name("email3"), сontactInfoContact.getEmail3());

        selectByVisible(By.name("bday"), сontactInfoContact.getBday());
        selectByVisible(By.name("bmonth"), сontactInfoContact.getBmonth());

        type(By.name("byear"), сontactInfoContact.getByear());

        selectByVisible(By.name("aday"), сontactInfoContact.getAday());
        selectByVisible(By.name("amonth"), сontactInfoContact.getAmonth());

        type(By.name("ayear"), сontactInfoContact.getAyear());

        type(By.name("homepage"), сontactInfoContact.getHomepage());

        if (creation) {
            selectByVisible(By.name("new_group"), сontactInfoContact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        type(By.name("address2"), сontactInfoContact.getAddress2());
        type(By.name("phone2"), сontactInfoContact.getPhone2());
        type(By.name("notes"), сontactInfoContact.getNotes());
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void editContact(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void updateContact() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContact(int index1) {
        wd.findElements(By.xpath("//td/input")).get(index1).click();
    }

    public void submitDeleted() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void okAlert() {
        Alert();
    }

    public void gotoContactNew() {

        click(By.linkText("add new"));
    }

    public void createContact(ContactData contact) {
        gotoContactNew();
        fillInfoContact(contact, true);
        fillDownloadJpg();
        submitContactCreated();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//td/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//td/input")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String lastName = element.getText();
            String firstName = element.getText();
            String address = element.getText();
            ContactData contact = new ContactData(firstName,
                    null, lastName, null,
                    null, null, address,
                    null, null,
                    null, null,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    null, null,
                    null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
