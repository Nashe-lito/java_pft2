package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeletionTest extends TestBase {


  @Test
  public void testContactsDeletion() throws Exception {
    app.getContactHelper().goToDelitionPage();
    app.getContactHelper().selectedContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().backAfterDeletionContact();
  }

}
