package appium.testcases;

import appium.pages.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Checkout
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
    public static void CheckoutTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        CompletePage completePage = new CompletePage(driver);

        loginPage.InputUsername("standard_user");
        loginPage.InputPassword("secret_sauce");
        loginPage.ClickLoginButton();

        Assert.assertEquals(homePage.GetDashboardText(),"PRODUCTS");

        homePage.AddToCartFirstItemButton();
        homePage.AddToCartSecondItemButton();
        homePage.ClickCartButton();

        Assert.assertEquals(cartPage.GetDashboardText(), "YOUR CART");

        cartPage.SwipeToTextElement("CHECKOUT");
        cartPage.ClickCheckoutButton();

        Assert.assertEquals(informationPage.GetDashboardText(),"CHECKOUT: INFORMATION");

        informationPage.InputFirstnameField("Linggar");
        informationPage.InputLastnameField("Bhakti Pratama");
        informationPage.InputPostalcodeField("61171");
        informationPage.ClickContinueButton();

        Assert.assertEquals(overviewPage.GetDashboardText(),"CHECKOUT: OVERVIEW");

        overviewPage.SwipeToTextElement("FINISH");
        overviewPage.ClickFinishButton();

        Assert.assertEquals(completePage.GetDashboardText(),"CHECKOUT: COMPLETE!");
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.swaglabsmobileapp");
    }
}