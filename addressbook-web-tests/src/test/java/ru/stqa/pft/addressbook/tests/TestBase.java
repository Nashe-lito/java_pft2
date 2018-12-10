package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.ContactData;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    protected void deleteSelectionContacts() {
        driver.switchTo().alert().accept(); //acceptNextAlert = true;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
    }

    protected void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    protected void goToHome() {
        driver.findElement(By.linkText("home")).click();
    }

    protected void returnToHomePage() {
      driver.findElement(By.linkText("home page")).click();
    }

    protected void submitContactCreation() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillContactForm(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).clear();
      driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).clear();
      driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).clear();
      driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).clear();
      driver.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      driver.findElement(By.name("title")).click();
      driver.findElement(By.name("title")).clear();
      driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
      driver.findElement(By.name("company")).click();
      driver.findElement(By.name("company")).clear();
      driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).clear();
      driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
    }

    protected void goToFormPage() {
      driver.findElement(By.linkText("add new")).click();
    }
}
