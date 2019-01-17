package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData2("test1", null, null));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData2> before = app.group().list();
        int index = before.size() -1;
        GroupData2 group = new GroupData2(index,"test1", "test2", "test3");
        app.group().modify(index, group);
        List<GroupData2> after = app.group().list();
        Assert.assertEquals (after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData2> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

    }



}
