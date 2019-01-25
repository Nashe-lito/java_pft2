package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            isElementPresent(By.name("new_group"));
        }
    }

   // public void type(By locator, String text) {
    //      click(locator);
    //      driver.findElement(locator).clear();
    //      driver.findElement(locator).sendKeys(text);
    //  }



    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void backAfterDeletionContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
    }

    public void deleteContact() {
        acceptNextAlert = true;
    }

   // public void selectedContact(int index) {
    //      driver.findElements(By.name("selected[]")).get(index).click();
    //  }

    public void selectedContact() {
        click(By.name("selected[]"));
    }

    public void selectedContactById(int id) {
        driver.findElement(By.cssSelector("input[value = '"+ id +"']")).click();
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



    public void submitContactModification() { click(By.name("update")); }

    public void create(ContactData contact) {
        addNewContact();
        fillContactCreation(new ContactData().withFirstName("First name").withLastName("Last name").withNickName("test1")
                .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
                .withPhone2( "0989999999").withGroup("test1"), true);
        submitContactCreation();
        contactCache = null;
        backToHomePageCC();

    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactCreation((contact), false);
        submitContactModification();
        contactCache = null;
        backToHomePageCC();
    }

    public void delete(ContactData contact) {
        selectedContactById(contact.getId());
        deleteContact();
        contactCache = null;
        backAfterDeletionContact();

    }
    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;


    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

public ContactData infoFromEditForm (ContactData contact){
        initContactModificationById(contact.getId());
    String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String nickname = driver.findElement(By.name("nickname")).getAttribute("value");
    String title = driver.findElement(By.name("title")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");
    String email = driver.findElement(By.name("email")).getAttribute("value");
    String phone2 = driver.findElement(By.name("phone2")).getAttribute("value");
    driver.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withNickName(nickname).withTitle(title).withMobile(mobile).withWork(work).withEmail(email).withPhone2(phone2);
}

public void initContactModificationById (int id){
    driver.findElements(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a")).get(id).click();
    // driver.findElements(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    // driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    //     WebElement checkbox = driver.findElement(By.cssSelector("input[value = '"+ id +"']"));
    //     WebElement row = checkbox.findElement(By.xpath("./../.."));
    //    List <WebElement> cells = row.findElements(By.tagName("td"));
    //    cells.get(7).findElement(By.tagName("a")).click();
    //  driver.findElements(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a")).get(index).click();
}


//    public List<ContactData> getContactList() {
//        List<ContactData> contacts = new ArrayList<ContactData>();
    //        List<WebElement> rows = driver.findElements(By.name("entry"));
//        for (WebElement row : rows) {
//             List<WebElement> cells = row.findElements(By.tagName("td"));
    //            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
    //           String lastname = cells.get(1).getText();
    //            String firstname = cells.get(2).getText();
    //            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    //        }
//        return contacts;
    }

