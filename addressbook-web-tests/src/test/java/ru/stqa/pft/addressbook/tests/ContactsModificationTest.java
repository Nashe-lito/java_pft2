package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class ContactsModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goToDelitionPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("First name").withLastName("Last name").withNickName("test1")
                    .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
                    .withPhone2( "0989999999").withGroup("test1"));
        }
    }


    @Test (enabled = false)
    public void testContactsModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact= before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("First name").withLastName("Last name").withNickName("test1")
                .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
                .withPhone2( "0989999999");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
    }

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
