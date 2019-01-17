package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTest2 extends TestBase{

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData2> before = app.group().list();
        GroupData2 group = new GroupData2("test1", null, null);
        app.group().create(group);
        List<GroupData2> after = app.group().list();
        Assert.assertEquals (after.size(), before.size() + 1);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
