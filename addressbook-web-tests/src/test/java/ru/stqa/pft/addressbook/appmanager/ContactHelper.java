package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper{
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver=driver;
    }

    protected boolean acceptNextAlert = true;


    public void backToHomePageCC() {
      driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
      driver.findElement(By.name("submit")).click();
    }

    public void fillContactCreation(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).clear();
      driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).clear();
      driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).clear();
      driver.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      driver.findElement(By.name("title")).click();
      driver.findElement(By.name("title")).clear();
      driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).clear();
      driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("work")).clear();
      driver.findElement(By.name("work")).sendKeys(contactData.getWork());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).clear();
      driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
      driver.findElement(By.name("phone2")).click();
      driver.findElement(By.name("phone2")).clear();
      driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
    }

    public void addNewContact() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void backAfterDeletionContact() {
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
    }

    public void deleteContact() {
      acceptNextAlert = true;
    }

    public void selectedContact() {
      driver.findElement(By.name("selected[]")).click();
    }

    public void goToDelitionPage() {
      driver.findElement(By.linkText("home")).click();
    }
}
