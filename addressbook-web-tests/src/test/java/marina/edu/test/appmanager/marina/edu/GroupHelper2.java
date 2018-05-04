package marina.edu.test.appmanager.marina.edu;

import marina.edu.test.model.GroupData;
import marina.edu.test.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper2 {


    public static void autorization(String user, String admin, String pass, String secret, By xpath) {

        ApplicationManager2.driver.findElement(By.name(user)).click();
        ApplicationManager2.driver.findElement(By.name(user)).sendKeys(admin);
        ApplicationManager2.driver.findElement(By.name(pass)).click();
        ApplicationManager2.driver.findElement(By.name(pass)).sendKeys(secret);
        ApplicationManager2.driver.findElement(xpath).click();
    }

    public static void goToGroupPage(String groups) {
        ApplicationManager2.driver.findElement(By.linkText(groups)).click();
    }

    public static void formFilling() {
        ApplicationManager2.driver.findElement(By.xpath("(//input[@name='new'])[2]")).click();
        ApplicationManager2.driver.findElement(By.name("group_name")).click();
        ApplicationManager2.driver.findElement(By.name("group_name")).sendKeys("NameKakashka");
        ApplicationManager2.driver.findElement(By.name("group_header")).click();
        ApplicationManager2.driver.findElement(By.name("group_header")).sendKeys("Header");
        ApplicationManager2.driver.findElement(By.name("group_footer")).click();
        ApplicationManager2.driver.findElement(By.name("group_footer")).sendKeys("Footer");
        ApplicationManager2.driver.findElement(By.name("submit")).click();
    }

    public static void deleteGroup() {
        ApplicationManager2.driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    public static void editGroup(GroupData group) {
        ApplicationManager2.driver.findElement(By.name("edit")).click();
        ApplicationManager2.driver.findElement(By.name("group_name")).click();
        ApplicationManager2.driver.findElement(By.name("group_name")).clear();
        ApplicationManager2.driver.findElement(By.name("group_name")).sendKeys("GroupNameModificated");
        ApplicationManager2.driver.findElement(By.name("group_header")).click();
        ApplicationManager2.driver.findElement(By.name("group_header")).clear();
        ApplicationManager2.driver.findElement(By.name("group_header")).sendKeys("GroupHeaderModificated");
        ApplicationManager2.driver.findElement(By.name("group_footer")).click();
        ApplicationManager2.driver.findElement(By.name("group_footer")).clear();
        ApplicationManager2.driver.findElement(By.name("group_footer")).sendKeys("GroupFooterModificated");
        ApplicationManager2.driver.findElement(By.name("update")).click();}

        public static void selectGroup (String  s){
            ApplicationManager2.driver.findElement(By.xpath(s)).click();
        }
        public static int getGroupCount () {
            return ApplicationManager2.driver.findElements(By.name("selected[]")).size();

        }
        public static List<GroupData> getGroupList () {
            List<GroupData> groups = new ArrayList<GroupData>();
            List<WebElement> elements = ApplicationManager2.driver.findElements(By.cssSelector("span.group"));
            for (WebElement element : elements) {
                String name = element.getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                GroupData group = new GroupData(id, name, null, null);
                groups.add(group);
            }
            return groups;

        }
    public static GroupData modifyGroup(List<GroupData> before, int index) {
        GroupHelper2.selectGroup("(//input[@name='selected[]'])[last()]");
        GroupData group = new GroupData(before.get(index).getId(), "GroupNameModificated", "GroupHeaderModificated", "GroupFooterModificated");
        GroupHelper2.editGroup(group);
        GroupHelper2.goToGroupPage("groups");
        GroupHelper2.getGroupList();
        return group;
    }
    public static void returnToGroupPage() {
        ApplicationManager2.driver.findElement(By.linkText("group page")).click();
    }

  /**  private Groups groupCache = null;
    if (groupCache != null) {
        return new Groups(groupCache);

    }
    groupCache = new Groups(); **/

    public static Set<GroupData> all () {
        Set<GroupData> groups = new HashSet<GroupData>();//Реализация множества
        List<WebElement> elements = ApplicationManager2.driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;


    }
    public static void goToHomepage() {
        ApplicationManager2.driver.get("http://localhost/addressbook/");
    }

}


