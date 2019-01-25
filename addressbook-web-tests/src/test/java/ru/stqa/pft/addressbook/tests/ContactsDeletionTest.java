package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goToDelitionPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("First name").withLastName("Last name").withNickName("test1")
                    .withTitle("test2").withMobile("0999999999").withWork("test3").withEmail("test@test.test")
                    .withPhone2("0989999999").withGroup("test1"));
        }
    }



  //  @Test (enabled = false)
  //  public void testContactsDeletion() throws Exception {
  //      Contacts before = app.contact().all();
    //      ContactData deletedContact = before.iterator().next();
  //      app.contact().delete(deletedContact);
    //      Contacts after = app.contact().all();
  //      Assert.assertEquals(after.size(), before.size() - 1);
    //      assertThat(after, equalTo(before.without(deletedContact)));
    //   }

    // before.remove(deletedContact);
       // Assert.assertEquals(before, after);

//  }


 @Test
 public void testContactsDeletion() throws Exception {
  app.contact().goToDelitionPage();
  app.contact().selectedContact();
  app.contact().deleteContact();
  app.contact().backAfterDeletionContact();
 }
}