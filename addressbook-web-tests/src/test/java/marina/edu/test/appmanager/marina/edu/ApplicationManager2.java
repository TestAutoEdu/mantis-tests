package marina.edu.test.appmanager.marina.edu;

import marina.edu.test.appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ApplicationManager2 {



    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;


    @BeforeSuite

    public void setUp() throws Exception {


        driver = new ChromeDriver();
        /**System.setProperty("webdriver.ie.driver", "F:\\CoursesRep\\CourseTest\\IEDriverServer_Win32_3.9.0");
         DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
         ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
         driver = new InternetExplorerDriver(ieCapabilities);**/
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        GroupHelper2.autorization("user", "admin", "pass", "secret", By.xpath("//input[@value='Login']"));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test" + m.getName() +" with parameters"+ Arrays.asList(p));

    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test" + m.getName());
    }


}
