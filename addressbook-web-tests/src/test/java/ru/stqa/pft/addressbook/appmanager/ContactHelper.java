package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public boolean acceptNextAlert = true;


    public void backToHomePageCC() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactCreation(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("email"), contactData.getEmail());
        type(By.name("phone2"), contactData.getPhone2());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            isElementPresent(By.name("new_group"));
        }
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void backAfterDeletionContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
    }

    public void deleteContact() {
        acceptNextAlert = true;
    }

    public void selectedContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void goToDelitionPage() {
        click(By.linkText("home"));
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            deleteContact();
        }
    }

    //public void initContactModification() {
    //    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test50999999999test30989999999'])[1]/following::img[2]"));
    //    //click(By.linkText("edit")){
    // }

    public void initContactModification(int index) {
        driver.findElements(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));

    }

    public void createContact(ContactData contact) {
        addNewContact();
        fillContactCreation(new ContactData("First name", "Last name",
                "test1", "test2", "0999999999", "test3", "test@test.test",
                "0989999999", "test1"), true);
        submitContactCreation();
        backToHomePageCC();

    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

 //   public List<ContactData> getContactList() {
 //       List<ContactData> contacts = new ArrayList<ContactData>();
    //       List<WebElement> elements = driver.findElements(By.cssSelector("tr"));
 //   for (WebElement element : elements) {
 //         String firstname = element.getText();
 //         String lastname = element.getText();
 //         // String id = element.findElement(By.tagName("input")).getAttribute("value");
 //         int id = Integer.parseInt(element.findElement(By.xpath("input")).getAttribute("value"));
    //         ContactData contact = new ContactData(id, firstname, lastname, null, null, null, null, null,
    //              null, null);
    //        contacts.add(contact);
    //  }

    //  return contacts;
    // }


}
