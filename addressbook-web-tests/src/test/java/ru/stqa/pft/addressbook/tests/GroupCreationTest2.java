package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;
import java.util.Set;


public class GroupCreationTest2 extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData2> before = app.group().all();
        GroupData2 group = new GroupData2().withName("test2");
        app.group().create(group);
        Set<GroupData2> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
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
