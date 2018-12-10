package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ContactsDeletionTest {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactsDeletion() throws Exception {
    driver.get("http://localhost/addressbook/index.php");
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.id("content")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    goToDelitionPage();
    selectedContact();
    deleteContact();
    backAfterDeletionContact();
  }

  private void backAfterDeletionContact() {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
  }

  private void deleteContact() {
    acceptNextAlert = true;
  }

  private void selectedContact() {
    driver.findElement(By.name("selected[]")).click();
  }

  private void goToDelitionPage() {
    driver.findElement(By.linkText("home")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}