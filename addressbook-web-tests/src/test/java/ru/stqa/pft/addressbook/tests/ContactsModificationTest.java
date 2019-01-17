package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactsModificationTest extends TestBase {

    @Test (enabled = false)
    public void testContactsModification() {
        app.getContactHelper().goToDelitionPage();
        int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
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
        Assert.assertEquals(after, before);
    }

    //  @Test
    //  public void testContactsModification() {
    //      app.getContactHelper().goToDelitionPage();
    //     if (!app.getContactHelper().isThereAContact()) {
    //        app.getContactHelper().createContact(new ContactData("First name", "Last name",
    //                "test1", "test2", "0999999999", "test3", "test@test.test",
    //             "0989999999", "test1"));
    //    }
    //    List<ContactData> before = app.getContactHelper().getContactList();
    //    app.getContactHelper().initContactModification(before.size() - 1); //подумать можно ли заменить данный метод
    //     ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "First name", "Last name",
    //           "test1", "test2", "0999999999", "test3", "test@test.test",
    //           "0989999999", null);

    //    app.getContactHelper().fillContactCreation((contact), false);
    //    app.getContactHelper().submitContactModification();
    //    app.getContactHelper().backToHomePageCC();
    //    List<ContactData> after = app.getContactHelper().getContactList();
    //    Assert.assertEquals(after.size(), before.size());
//
    //     before.remove(before.size() - 1);
    //      before.add(contact);
    //      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    //  }


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
