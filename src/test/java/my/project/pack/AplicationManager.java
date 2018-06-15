package my.project.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AplicationManager {
    WebDriver driver;

    public SessionHelper getsessionHelper;
    public IssueHelper getIssueHelper;

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void openMainPage(final String mainPageForTest) {
        driver.get(mainPageForTest + "/login_page.php");
    }

    public void init() {
        //driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openMainPage("http://shipovalov.net");
        getsessionHelper = new SessionHelper(driver);
        getIssueHelper = new IssueHelper(driver);
        getsessionHelper.loginWithParams(new UserData());
    }

    public void stop() {
        getsessionHelper.logout();
        driver.quit();
    }

}
