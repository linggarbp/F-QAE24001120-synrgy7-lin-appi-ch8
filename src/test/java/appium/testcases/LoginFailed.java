package appium.testcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import appium.pages.LoginPage;

public class LoginFailed
{
    protected static AndroidDriver driver;

    @BeforeClass
    public static void SetUp()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public static void LoginTest()
    {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.InputUsername("standard_user");
        loginPage.InputPassword("tomato_sauce");
        loginPage.ClickLoginButton();

        loginPage.ErrorMessageDisplayed();
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.swaglabsmobileapp");
    }
}