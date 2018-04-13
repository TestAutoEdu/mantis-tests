package marina.edu.test.tests;

import marina.edu.test.appmanager.marina.edu.ApplicationManager2;
import marina.edu.test.appmanager.marina.edu.GroupHelper2;
import marina.edu.test.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests2 extends ApplicationManager2 {

    @Test
    public void testGroupModificationTests2() throws Exception {
        GroupHelper2.goToGroupPage("groups");
        GroupHelper2.selectGroup("(//input[@name='selected[]'])[last()]");
        List<GroupData> before = GroupHelper2.getGroupList();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "GroupNameModificated", "GroupHeaderModificated", "GroupFooterModificated");
        GroupHelper2.editGroup(group);
        GroupHelper2.goToGroupPage("groups");
        GroupHelper2.getGroupList();
        List<GroupData> after = GroupHelper2.getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}



