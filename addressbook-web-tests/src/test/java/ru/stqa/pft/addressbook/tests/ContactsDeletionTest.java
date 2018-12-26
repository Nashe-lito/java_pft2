package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactsDeletionTest extends TestBase {


    // @Test
    // public void testContactsDeletion() throws Exception {
    //  app.getContactHelper().goToDelitionPage();
    //  app.getContactHelper().selectedContact();
    //  app.getContactHelper().deleteContact();
    //  app.getContactHelper().backAfterDeletionContact();
    // }


    @Test
    public void testContactsDeletion() throws Exception {
        app.getContactHelper().goToDelitionPage();
        //    int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("First name", "Last name",
                    "test1", "test2", "0999999999", "test3", "test@test.test",
                    "0989999999", "test1"));
        }
        app.getContactHelper().selectedContact(0);
        app.getContactHelper().deleteContact();
        app.getContactHelper().backAfterDeletionContact();
        //  int after = app.getContactHelper().getContactCount();
       //  Assert.assertEquals (after, before - 1); должно быть
    }
}