package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactsModificationTest extends TestBase{

     @Test
    public void testContactsModification() {
        app.getContactHelper().goToDelitionPage();
         int before = app.getContactHelper().getContactCount();
       if ( ! app.getContactHelper().isThereAContact()) {
           app.getContactHelper().createContact(new ContactData("First name", "Last name",
                   "test1", "test2", "0999999999", "test3", "test@test.test",
                   "0989999999", "test1"));
       }
        app.getContactHelper().initContactModification(0); //подумать можно ли заменить данный метод
       app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name",
                "test1", "test2", "0999999999", "test3", "test@test.test",
               "0989999999", null), false);
       app.getContactHelper().submitContactModification();
        app.getContactHelper().backToHomePageCC();
         int after = app.getContactHelper().getContactCount();
         Assert.assertEquals (after, before);
     }

    // @Test
    // public void testContactsModification() {
    //     app.getContactHelper().goToDelitionPage();
    //    app.getContactHelper().initContactModification(); //подумать можно ли заменить данный метод
    //    app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name",
    //            "test1", "test2", "0999999999", "test3", "test@test.test",
    //            "0989999999", null), false);
    //    app.getContactHelper().submitContactModification();
    //    app.getContactHelper().backToHomePageCC();
    //}
}
