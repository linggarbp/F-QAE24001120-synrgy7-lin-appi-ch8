package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By usernameField = By.xpath("//*[@content-desc='test-Username']");
    By passwordField = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    By errorMessage = AppiumBy.accessibilityId("test-Error message");

    public LoginPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void InputUsername(String username)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void InputPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public void ErrorMessageDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        driver.findElement(errorMessage).isDisplayed();
    }
}