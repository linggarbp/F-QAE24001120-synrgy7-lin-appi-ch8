package appium.testcases;

import appium.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import appium.pages.LoginPage;

public class LoginSuccess
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
        HomePage homePage = new HomePage(driver);

        loginPage.InputUsername("standard_user");
        loginPage.InputPassword("secret_sauce");
        loginPage.ClickLoginButton();

        Assert.assertEquals(homePage.GetDashboardText(),"PRODUCTS");
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.swaglabsmobileapp");
    }
}