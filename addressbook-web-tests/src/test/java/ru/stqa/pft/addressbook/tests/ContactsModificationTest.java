package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactsModificationTest extends TestBase{

    @Test
    public void testContactsModification() {
        app.getContactHelper().goToDelitionPage();
        app.getContactHelper().initContactModification(); //подумать можно ли заменить данный метод
        app.getContactHelper().fillContactCreation(new ContactData("First name", "Last name", "test1", "test2", "0999999999", "test3", "test@test.test", "0989999999"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().backToHomePageCC();


    }
}
