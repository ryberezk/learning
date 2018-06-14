package my.project.pack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class CreateNewIssue {
    WebDriver driver;
    
    @BeforeMethod
    public void setUp() throws Exception {
        //driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @Test
    public void createNewIssue() {
        driver.get("http://shipovalov.net/login_page.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("student");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("luxoft");
        driver.findElement(By.cssSelector("input.button")).click();
        if (!driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[41]")).isSelected()) {
            driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[41]")).click();
        }
        driver.findElement(By.linkText("Report Issue")).click();
        driver.findElement(By.id("platform")).click();
        driver.findElement(By.id("platform")).clear();
        driver.findElement(By.id("platform")).sendKeys("Platform");
        driver.findElement(By.id("os")).click();
        driver.findElement(By.id("os")).clear();
        driver.findElement(By.id("os")).sendKeys("OS");
        driver.findElement(By.id("os_build")).click();
        driver.findElement(By.id("os_build")).clear();
        driver.findElement(By.id("os_build")).sendKeys("OS version");
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[8]/td[2]/select//option[2]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[8]/td[2]/select//option[2]")).click();
        }
        driver.findElement(By.name("summary")).click();
        driver.findElement(By.name("summary")).clear();
        driver.findElement(By.name("summary")).sendKeys("Summary");
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys("Desckription");
        driver.findElement(By.name("steps_to_reproduce")).click();
        driver.findElement(By.name("steps_to_reproduce")).clear();
        driver.findElement(By.name("steps_to_reproduce")).sendKeys("Reproduce");
        driver.findElement(By.name("additional_info")).click();
        driver.findElement(By.name("additional_info")).clear();
        driver.findElement(By.name("additional_info")).sendKeys("Information");
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[14]/td[2]/label[2]/input")).click();
        }
        if (!driver.findElement(By.id("report_stay")).isSelected()) {
            driver.findElement(By.id("report_stay")).click();
        }
        driver.findElement(By.cssSelector("input.button")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
    
    @AfterMethod
    public void tearDown() {
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
