package appium.stepdefs;

import appium.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HomeStepDef
{
    protected static AndroidDriver driver;

    @Given("User login with valid username and password")
    public void UserLoginWithValidUsernameAndPassword()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver(capabilities);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.InputUsername("standard_user");
        loginPage.InputPassword("secret_sauce");
        loginPage.ClickLoginButton();
    }

    @And("User click on sorting button")
    public void UserClickOnSortingButton()
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickFilterButton();
    }

    @When("User click on low to high button")
    public void UserClickOnPriceLowToHighButton()
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickLowToHighButton();
    }

    @Then("Items are lined up in order of low to high price")
    public void ItemsAreLinedUpInOrderOfLowPriceToHighPrice()
    {
        HomePage homePage = new HomePage(driver);
        homePage.ValidatePage();
    }

    @And("User add to cart first item")
    public void UserAddToCartFirstItem()
    {
        HomePage homePage = new HomePage(driver);
        homePage.AddToCartFirstItemButton();
    }

    @And("User add to cart second item")
    public void UserAddToCartSecondItem()
    {
        HomePage homePage = new HomePage(driver);
        homePage.AddToCartSecondItemButton();
    }

    @And("User click on cart button")
    public void UserClickOnCartButton()
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickCartButton();
    }

    @And("User click on checkout button")
    public void UserClickOnCheckoutButton()
    {
        CartPage cartPage = new CartPage(driver);
        cartPage.SwipeToTextElement("CHECKOUT");
        cartPage.ClickCheckoutButton();
    }

    @And("User input firstname lastname and postalcode")
    public void UserInputFirstnameLastnameAndPostalcode()
    {
        InformationPage informationPage = new InformationPage(driver);
        informationPage.InputFirstnameField("Linggar");
        informationPage.InputLastnameField("Bhakti Pratama");
        informationPage.InputPostalcodeField("61171");
    }

    @And("User click on continue button")
    public void UserClickOnContinueButton()
    {
        InformationPage informationPage = new InformationPage(driver);
        informationPage.ClickContinueButton();
    }

    @When("User click on finish button")
    public void UserClickOnFinishButton()
    {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.SwipeToTextElement("FINISH");
        overviewPage.ClickFinishButton();
    }

    @Then("User is on complete page")
    public void UserIsOnCompletePage()
    {
        CompletePage completePage = new CompletePage(driver);
        completePage.ValidatePage();
    }
}