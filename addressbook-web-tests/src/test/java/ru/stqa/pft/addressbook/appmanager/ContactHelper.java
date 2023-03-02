package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactIDataInfoContact;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillDownloadJpg() {
        type1 (By.name("photo"),"H:\\GIT\\123.jpg");
    }

    public void submitContactCreated() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillInfoContact(ContactIDataInfoContact сontactInfoContact) {
        type(By.name("firstname"),сontactInfoContact.getFirstName());
        type(By.name("middlename"),сontactInfoContact.getMiddleName());
        type(By.name("lastname"),сontactInfoContact.getLastName());
        type(By.name("nickname"),сontactInfoContact.getNickName());

        type(By.name("title"),сontactInfoContact.getTitle());
        type(By.name("company"),сontactInfoContact.getCompany());
        type(By.name("address"),сontactInfoContact.getAddress());

        type(By.name("home"),сontactInfoContact.getHomeTelephone());
        type(By.name("mobile"),сontactInfoContact.getMobileTelephone());
        type(By.name("work"),сontactInfoContact.getWorkTelephone());
        type(By.name("fax"),сontactInfoContact.getFaxTelephone());

        type(By.name("email"),сontactInfoContact.getEmail1());
        type(By.name("email2"),сontactInfoContact.getEmail2());
        type(By.name("email3"),сontactInfoContact.getEmail3());

        selectByVisible(By.name("bday"),сontactInfoContact.getBday());
        selectByVisible(By.name("bmonth"),сontactInfoContact.getBmonth());

        type(By.name("byear"),сontactInfoContact.getByear());

        selectByVisible(By.name("aday"),сontactInfoContact.getAday());
        selectByVisible(By.name("amonth"),сontactInfoContact.getAmonth());

        type(By.name("ayear"),сontactInfoContact.getAyear());

        type(By.name("homepage"),сontactInfoContact.getHomepage());

        if(сontactInfoContact.getNewGroup() != null)
       // var test = wd.findElement(By.name("new_group")).isDisplayed();
        // if(wd.findElement(By.name("new_group")).isDisplayed())
                selectByVisible(By.name("new_group"),сontactInfoContact.getNewGroup());


        type(By.name("address2"),сontactInfoContact.getAddress2());
        type(By.name("phone2"),сontactInfoContact.getPhone2());
        type(By.name("notes"),сontactInfoContact.getNotes());
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void editContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }
    public void updateContact(){
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContact() {
        click(By.xpath("//td/input"));
    }

    public void submitDeleted() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void okAlert() {
        Alert();
    }

    public void gotoHome() {
        click(By.linkText("home"));
    }
}
