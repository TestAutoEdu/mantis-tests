package marina.edu.test.tests;

import marina.edu.test.appmanager.marina.edu.ApplicationManager2;
import marina.edu.test.appmanager.marina.edu.GroupHelper2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests2 extends ApplicationManager2 {


    @Test
    public void testGroupCreationTests2() throws Exception {
        if (GroupHelper2.getGroupList().size() == 0) //Проверяем есть ли группы для удаления
        {
            GroupHelper2.formFilling();
            GroupHelper2.returnToGroupPage();
        }
        GroupHelper2.goToGroupPage("groups");
        GroupHelper2.selectGroup("(//input[@name='selected[]'])[3]");
        GroupHelper2.deleteGroup();
    }




}
