package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactsCreationTest extends TestBase {

    @Test (enabled = false)
    public void testContactsCreation() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("First name", "Last name",
                "test1", "test2", "0999999999", "test3", "test@test.test",
                "0989999999", "test1"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);

    }
}


// @Test
//  public void testContactsCreation() throws Exception {
//   app.getContactHelper().addNewContact();
//  app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name",
//          "test1", "test2", "0999999999", "test3", "test@test.test",
//         "0989999999", "test1"), true);
//  app.getContactHelper().submitContactCreation();
//  app.getContactHelper().backToHomePageCC();
//  }


//  @Test
//  public void testContactsCreation() throws Exception {
//      List<ContactData> before = app.getContactHelper().getContactList();
//      app.getContactHelper().createContact(new ContactData("First name", "Last name",
//           "test1", "test2", "0999999999", "test3", "test@test.test",
//         "0989999999", "test1"));
//     List<ContactData> after = app.getContactHelper().getContactList();
//     Assert.assertEquals (after.size(), before.size() +1);
//  }

