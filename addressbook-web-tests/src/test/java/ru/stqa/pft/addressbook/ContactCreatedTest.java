package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreatedTest {

    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(130, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testContactCreated() throws Exception {
        gotoContactNew();
        fillBlockFio(new ContactDataFio("John", "Vlad", "Doe"));
        fillBlockNick("Test");
        fillBlockTitleCompanyAddress(new ContactDataTitleCompanyAddress("title", "Company", "address"));
        fillBlockTelephone(new ContactDataTelephone("89002000600", "88002000600", "87002000600", "86002000600"));
        fillBlockEmail(new ContactDataEmail("email1.test@mail.ru", "email2@mail.ru", "email3@mail.ru"));
        fillHomepage("homepage");
        fillBirthday(new ContactDataBirthday("28", "August", "1991"));
        fillAnniversary(new ContactDataAnniversary("30", "January", "1990"));
        fillSecondary(new ContactDataSecondary("test", "addressSecondary", "homeSecondary", "notesSecondary"));
        fillDownloadJpg();
        submitContactCreated();
        returnToGroupPage();
        logoutAccount();
    }

    private void fillDownloadJpg() {
        wd.findElement(By.name("photo")).sendKeys("H:\\GIT\\123.jpg");
    }

    private void fillSecondary(ContactDataSecondary contactDataSecondary) {
        wd.findElement(By.name("new_group")).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDataSecondary.getNewGroup());
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactDataSecondary.getAddress2());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactDataSecondary.getPhone2());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactDataSecondary.getNotes());
    }

    private void submitContactCreated() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void logoutAccount() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void returnToGroupPage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void fillAnniversary(ContactDataAnniversary contactDataAnniversary) {
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactDataAnniversary.getAday());
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactDataAnniversary.getAmonth());
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(contactDataAnniversary.getAyear());
    }

    private void fillHomepage(String homepage) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepage);
    }

    private void fillBirthday(ContactDataBirthday contactDataBirthday) {
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactDataBirthday.getBday());
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactDataBirthday.getBmonth());
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactDataBirthday.getByear());
    }

    private void fillBlockEmail(ContactDataEmail contactDataEmail) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactDataEmail.getEmail1());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(contactDataEmail.getEmail2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(contactDataEmail.getEmail3());
    }

    private void fillBlockTelephone(ContactDataTelephone contactDataTelephone) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactDataTelephone.getHomeTelephone());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactDataTelephone.getMobileTelephone());
        wd.findElement(By.name("mobile")).sendKeys(Keys.DOWN);
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactDataTelephone.getMobileTelephone());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(contactDataTelephone.getWorkTelephone());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(contactDataTelephone.getFaxTelephone());
    }

    private void fillBlockTitleCompanyAddress(ContactDataTitleCompanyAddress contactDataTitleCompanyAddress) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(contactDataTitleCompanyAddress.getTitle());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactDataTitleCompanyAddress.getCompany());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactDataTitleCompanyAddress.getAddress());
    }

    private void fillBlockNick(String nickName){
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickName);
    }

    private void fillBlockFio(ContactDataFio contactDataFio) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactDataFio.getFirstName());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactDataFio.getMiddleName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactDataFio.getLastName());
    }

    private void gotoContactNew() {
        wd.findElement(By.linkText("add new")).click();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
