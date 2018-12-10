package ru.stqa.pft.addressbook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactsCreationTest {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactsCreation() throws Exception {
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
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("First name");
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys("Middle name");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Last name");
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys("test1");
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys("test2");
    driver.findElement(By.name("company")).click();
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys("test3");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("test4");
    driver.findElement(By.name("theform")).click();
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("test5");
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("test6");
    driver.findElement(By.name("work")).click();
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("test7");
    driver.findElement(By.name("fax")).click();
    driver.findElement(By.name("fax")).clear();
    driver.findElement(By.name("fax")).sendKeys("test8");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@test.test");
    driver.findElement(By.name("email2")).click();
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("test1@test.test");
    driver.findElement(By.name("email3")).click();
    driver.findElement(By.name("email3")).clear();
    driver.findElement(By.name("email3")).sendKeys("test2@test.test");
    driver.findElement(By.name("homepage")).click();
    driver.findElement(By.name("homepage")).clear();
    driver.findElement(By.name("homepage")).sendKeys("qwertyu");
    driver.findElement(By.name("address2")).click();
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("test9");
    driver.findElement(By.name("phone2")).click();
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("test10");
    driver.findElement(By.name("notes")).click();
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("test11");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("home page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
      acceptNextAlert = true;
    }
  }
}