package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactsCreationTest extends TestBase {

    @Test
    public void testContactsCreation() throws Exception {
        app.contact().addNewContact();
        File photo = new File("src/test/resources/1280.png");
        app.contact().fillContactCreation(new ContactData().withFirstName("First name").withLastName("Last name").withNickName("test1")
                .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
                .withPhone2("0989999999").withPhoto(photo).withGroup("test1"), true);
        app.contact().submitContactCreation();
        app.contact().backToHomePageCC();
    }


    //   @Test
//    public void testContactsCreation() throws Exception {
//        int before = app.getContactHelper().getContactCount();
//        app.getContactHelper().createContact(new ContactData("First name", "Last name",
//                "test1", "test2", "0999999999", "test3", "test@test.test",
//                "0989999999", "test1"));
//        int after = app.getContactHelper().getContactCount();
    //       Assert.assertEquals(after, before + 1);

    //   }
//}


// @Test
//  public void testContactsCreation() throws Exception {
//   app.getContactHelper().addNewContact();
//  app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name",
//          "test1", "test2", "0999999999", "test3", "test@test.test",
//         "0989999999", "test1"), true);
//  app.getContactHelper().submitContactCreation();
//  app.getContactHelper().backToHomePageCC();
//  }


    //   @Test (enabled = false)
//   public void testContactsCreation() throws Exception {
    //      Contacts before = app.contact().all();
    //      ContactData contact = new ContactData().withFirstName("First name").withLastName("Last name").withNickName("test1")
    //              .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
    //             .withPhone2( "0989999999").withGroup("test1");
    //      app.contact().create(contact);
    //     assertThat(app.contact().count(), equalTo(before.size() +1));
    //      Contacts after = app.contact().all();
    //     assertThat(after, equalTo(
    //              before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    //  }

    //   @Test (enabled = false)
    //    public void testBadContactsCreation() throws Exception {
//         Contacts before = app.contact().all();
    //        app.contact().create(new ContactData().withFirstName("First name ' ").withLastName("Last name").withNickName("test1")
//                 .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
    //                .withPhone2( "0989999999").withGroup("test1"));
    //        assertThat(app.contact().count(), equalTo(before.size()));
    //       Contacts after = app.contact().all();
    //  //       assertThat(after, equalTo(before));
    //    }

}


