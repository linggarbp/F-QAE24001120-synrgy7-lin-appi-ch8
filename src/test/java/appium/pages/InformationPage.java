package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@text='CHECKOUT: INFORMATION']");
    By firstnameField = AppiumBy.accessibilityId("test-First Name");
    By lastnameField = AppiumBy.accessibilityId("test-Last Name");
    By postalcodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public InformationPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String GetDashboardText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public void InputFirstnameField(String firstname)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameField));
        driver.findElement(firstnameField).sendKeys(firstname);
    }

    public void InputLastnameField(String lastname)
    {
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void InputPostalcodeField(String postalcode)
    {
        driver.findElement(postalcodeField).sendKeys(postalcode);
    }

    public void ClickContinueButton()
    {
        driver.findElement(continueButton).click();
    }
}