package marina.edu.test.tests;

import marina.edu.test.appmanager.marina.edu.ApplicationManager2;
import marina.edu.test.appmanager.marina.edu.GroupHelper2;
import marina.edu.test.model.GroupData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests2 extends ApplicationManager2 {


    /**  @DataProvider
    public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>(); СПисок массивов
    list.add(new Object[] {"test1", "header 1", "footer 1"});
    list.add(new Object[] {"test2", "header 2", "footer 2"});
    list.add(new Object[] {"test3", "header 3", "footer 3"});
    return list.iterator();
    }
    Реализация дата провайдера
     **/


    @Test (enabled = false)
    public void testGroupCreationTests2() throws Exception {


        GroupHelper2.goToGroupPage("groups");
        List<GroupData> before = GroupHelper2.getGroupList();
        GroupHelper2.formFilling();
        /** GroupData group = new GroupData("test1", null, null);**/
        GroupHelper2.returnToGroupPage();
        List<GroupData> after = GroupHelper2.getGroupList();
        assertThat(after.size(), equalTo(before.size() + 1) );
        GroupData group = new GroupData("test2", null, null);
        before.add(group);
        /**int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
         старый споооб вычисления максимального id
        **/
      int max1 = after.stream().max((Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(max1);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);

       // assertThat( new HashSet<Object>(after), equalTo(new HashSet<Object>(before)));
        assertThat( new HashSet<Object>(after), equalTo(new HashSet<Object>(before)));

    }


}
