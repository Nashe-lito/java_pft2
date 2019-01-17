package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactsDeletionTest extends TestBase {


    // @Test
    // public void testContactsDeletion() throws Exception {
    //  app.getContactHelper().goToDelitionPage();
    //  app.getContactHelper().selectedContact();
    //  app.getContactHelper().deleteContact();
    //  app.getContactHelper().backAfterDeletionContact();
    // }


    @Test (enabled = false)
    public void testContactsDeletion() throws Exception {
        app.getContactHelper().goToDelitionPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("First name", "Last name",
                    "test1", "test2", "0999999999", "test3", "test@test.test",
                    "0989999999", "test1"));
        }
      //  List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectedContact(0);
        app.getContactHelper().deleteContact();
        app.getContactHelper().backAfterDeletionContact();
      //  List<ContactData> after = app.getContactHelper().getContactList();
       // Assert.assertEquals (after.size(), before.size() -1);

       // before.remove(before.size() - 1);
       // Assert.assertEquals(before, after);

    }
}