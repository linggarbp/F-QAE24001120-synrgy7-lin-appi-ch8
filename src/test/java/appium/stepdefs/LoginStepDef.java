package appium.stepdefs;

import appium.pages.HomePage;
import appium.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginStepDef
{
    protected static AndroidDriver driver;

    @Given("User is on login page")
    public void UserIsOnLoginPage()
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

    @And("User input username with {string}")
    public void UserInputUsernameWith(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.InputUsername(username);
    }

    @And("User input password with {string}")
    public void UserInputPasswordWith(String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.InputPassword(password);
    }

    @When("User click on login button")
    public void UserClickLoginButton()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ClickLoginButton();
    }

    @Then("User is on home page")
    public void UserIsOnHomePage()
    {
        HomePage homePage = new HomePage(driver);
        homePage.ValidatePage();
    }

    @Then("Error message is showing up")
    public void ErrorMessageIsShowingUp()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ErrorMessageDisplayed();
    }
}