package marina.edu.test.appmanager.marina.edu;

import marina.edu.test.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        ApplicationManager2.driver.findElement(By.name("group_name")).sendKeys("GroupName");
        ApplicationManager2.driver.findElement(By.name("group_header")).click();
        ApplicationManager2.driver.findElement(By.name("group_header")).sendKeys("GroupHeader");
        ApplicationManager2.driver.findElement(By.name("group_footer")).click();
        ApplicationManager2.driver.findElement(By.name("group_footer")).sendKeys("GroupFooter");
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
                String id = element.findElement(By.tagName("input")).getAttribute("value");
                GroupData group = new GroupData(id, name, null, null);
                groups.add(group);
            }
            return groups;

        }

    }


