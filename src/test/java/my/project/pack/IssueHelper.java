package my.project.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class IssueHelper {
    WebDriver driver;

    public IssueHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseProject(ProjectData project) {
        Select selectCategory = new Select(driver.findElement(By.name(project.getProject())));
        selectCategory.selectByVisibleText(project.getNameOfChoose());
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
        if (!driver.findElement(By.id("report_stay")).isSelected()) {
            driver.findElement(By.id("report_stay")).click();
        }
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public void openReportIssue() {
        driver.findElement(By.linkText("Report Issue")).click();
    }

    public void checkErrorText() {
        Assert.assertEquals(driver.findElement(By.className("center")).getText(), "A necessary field \"Summary\" was empty. Please recheck your inputs.");
    }

}
