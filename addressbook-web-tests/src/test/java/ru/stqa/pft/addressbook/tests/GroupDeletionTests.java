package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData2().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData2> before = app.group().all();
        GroupData2 deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData2> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
            Assert.assertEquals(before, after);
    }
}
