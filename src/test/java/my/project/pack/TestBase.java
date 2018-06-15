package my.project.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeClass
    public void setUp() throws Exception {
        //driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openMainPage("http://shipovalov.net");
        loginWithParams();
    }

    public void chooseProject(String project) {
        Select selectCategory = new Select(driver.findElement(By.name(project)));
        selectCategory.selectByVisibleText("Lala");
    }

    public void openMainPage(final String mainPageForTest) {
        driver.get(mainPageForTest + "/login_page.php");
    }

    public void inputData(String inputTextData) {
        Select selectCategory = new Select(driver.findElement(By.name("category_id")));
        selectCategory.selectByVisibleText("[All Projects] General");
        Select reproducibility = new Select(driver.findElement(By.name("reproducibility")));
        reproducibility.selectByVisibleText("random");
        Select severity = new Select(driver.findElement(By.name("severity")));
        severity.selectByVisibleText("text");
        Select priority = new Select(driver.findElement(By.name("priority")));
        priority.selectByVisibleText("low");
        Select profileId = new Select(driver.findElement(By.name("profile_id")));
        profileId.selectByVisibleText("Desktop Windows 10");
        driver.findElement(By.id("platform")).sendKeys(inputTextData);
        driver.findElement(By.id("os")).sendKeys(inputTextData);
        driver.findElement(By.id("os_build")).sendKeys(inputTextData);
        Select handlerid = new Select(driver.findElement(By.name("handler_id")));
        handlerid.selectByVisibleText("admin");
        driver.findElement(By.name("summary")).sendKeys(inputTextData);
        driver.findElement(By.name("description")).sendKeys(inputTextData);
        driver.findElement(By.name("steps_to_reproduce")).sendKeys(inputTextData);
        driver.findElement(By.name("additional_info")).sendKeys(inputTextData);
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).click();
        }
        if (!driver.findElement(By.id("report_stay")).isSelected()) {
            driver.findElement(By.id("report_stay")).click();
        }
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public void openReportIssue() {
        driver.findElement(By.linkText("Report Issue")).click();
    }

    public void loginWithParams() {
        driver.findElement(By.name("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("luxoft");
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public void checkErrorText() {
        Assert.assertEquals(driver.findElement(By.className("center")).getText(),"A necessary field \"Summary\" was empty. Please recheck your inputs.");
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterClass
    public void tearDown() {
        logout();
        driver.quit();
    }
}
