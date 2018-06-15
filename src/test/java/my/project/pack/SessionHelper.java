package my.project.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SessionHelper {
    WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public void loginWithParams(UserData user) {
        driver.findElement(By.name("username")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("input.button")).click();
    }
}
