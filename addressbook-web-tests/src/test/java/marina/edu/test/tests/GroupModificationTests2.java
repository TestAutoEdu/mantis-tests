package marina.edu.test.tests;

import marina.edu.test.appmanager.marina.edu.ApplicationManager2;
import marina.edu.test.appmanager.marina.edu.GroupHelper2;
import marina.edu.test.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests2 extends ApplicationManager2 {

    @Test
    public void testGroupModificationTests2() throws Exception {
        GroupHelper2.goToGroupPage("groups");
        if (GroupHelper2.getGroupList().size() == 0)
        {
            GroupHelper2.formFilling();
            GroupHelper2.returnToGroupPage();
        }
        List<GroupData> before = GroupHelper2.getGroupList();

       int index = before.size() - 1;
        GroupData group = GroupHelper2.modifyGroup(before, index);
        List<GroupData> after = GroupHelper2.getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}



