package my.project.pack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class CreateNewIssue {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openMainPage("http://shipovalov.net");
        loginWithParams();
    }

    @Test
    public void createNewIssue() {
        chooseProject();
        inputData("Text for block");
    }

    private void chooseProject() {
        if (!driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[41]")).isSelected()) {
            driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[41]")).click();
        }
    }

    private void openMainPage(final String mainPageForTest) {
        driver.get(mainPageForTest + "/login_page.php");
    }

    private void inputData(String inputTextData) {
        driver.findElement(By.linkText("Report Issue")).click();
        Select selectCategory = new Select(driver.findElement(By.name("category_id")));
        selectCategory.selectByVisibleText("[All Projects] General");
        Select Reproducibility = new Select(driver.findElement(By.name("reproducibility")));
        Reproducibility.selectByVisibleText("random");
        Select Severity = new Select(driver.findElement(By.name("severity")));
        Severity.selectByVisibleText("text");
        Select Priority = new Select(driver.findElement(By.name("priority")));
        Priority.selectByVisibleText("low");
        driver.findElement(By.id("platform")).click();
        driver.findElement(By.id("platform")).clear();
        driver.findElement(By.id("platform")).sendKeys(inputTextData);
        driver.findElement(By.id("os")).click();
        driver.findElement(By.id("os")).clear();
        driver.findElement(By.id("os")).sendKeys(inputTextData);
        driver.findElement(By.id("os_build")).click();
        driver.findElement(By.id("os_build")).clear();
        driver.findElement(By.id("os_build")).sendKeys(inputTextData);
        Select handlerid = new Select(driver.findElement(By.name("handler_id")));
        handlerid.selectByVisibleText("admin");
        driver.findElement(By.name("summary")).click();
        driver.findElement(By.name("summary")).clear();
        driver.findElement(By.name("summary")).sendKeys(inputTextData);
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys(inputTextData);
        driver.findElement(By.name("steps_to_reproduce")).click();
        driver.findElement(By.name("steps_to_reproduce")).clear();
        driver.findElement(By.name("steps_to_reproduce")).sendKeys(inputTextData);
        driver.findElement(By.name("additional_info")).click();
        driver.findElement(By.name("additional_info")).clear();
        driver.findElement(By.name("additional_info")).sendKeys(inputTextData);
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).click();
        }
        if (!driver.findElement(By.id("report_stay")).isSelected()) {
            driver.findElement(By.id("report_stay")).click();
        }
        driver.findElement(By.cssSelector("input.button")).click();
    }

    private void loginWithParams() {
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("student");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("luxoft");
        driver.findElement(By.cssSelector("input.button")).click();
    }

    private void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterMethod
    public void tearDown() {
        logout();
        driver.quit();
    }

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
