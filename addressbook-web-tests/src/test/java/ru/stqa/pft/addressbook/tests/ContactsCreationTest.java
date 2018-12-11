package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactsCreationTest extends TestBase {


  @Test
  public void testContactsCreation() throws Exception {
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name", "test1", "test2", "0999999999", "test3", "test@test.test", "0989999999"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().backToHomePageCC();
  }


}