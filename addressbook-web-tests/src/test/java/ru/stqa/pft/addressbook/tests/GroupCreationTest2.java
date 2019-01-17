package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTest2 extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData2> before = app.group().list();
        GroupData2 group = new GroupData2().withName("test2");
        app.group().create(group);
        List<GroupData2> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    //  @Test
    // public void testGroupCreation() {
    //      app.goTo().groupPage();
    //      List<GroupData2> before = app.group().list();
    //      GroupData2 group = new GroupData2().withName("test1");
    //      app.group().create(group);
    //     List<GroupData2> after = app.group().list();
    //     Assert.assertEquals (after.size(), before.size() + 1);
//
    //      before.add(group);
    //     Comparator<? super GroupData2> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //      before.sort(byId);
    //      after.sort(byId);
    //     Assert.assertEquals(before, after);
    //  }
}
