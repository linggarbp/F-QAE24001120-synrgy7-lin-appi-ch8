package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@text='PRODUCTS']");
    By sortingButton = By.xpath("//*[@content-desc='test-Modal Selector Button']");
    By lowHighButton = By.xpath("//*[@text='Price (low to high)']");
    By firstItemPrice = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.widget.TextView[contains(@text, '$')])[1]");
    By secondItemPrice = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.widget.TextView[contains(@text, '$')])[2]");
    By addToCartFirstItemButton = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    By addToCartSecondItemButton = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    By cartButton = AppiumBy.accessibilityId("test-Cart");

    public HomePage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
    }

    public String GetDashboardText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public void ClickFilterButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortingButton));
        driver.findElement(sortingButton).click();
    }

    public void ClickLowToHighButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lowHighButton));
        driver.findElement(lowHighButton).click();
    }

    public float GetFirstItemPrice()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemPrice));
        String beforeRemoveDollar = driver.findElement(firstItemPrice).getText();
        String afterRemoveDollar = beforeRemoveDollar.replace("$", "");
        return Float.parseFloat(afterRemoveDollar);
    }

    public float GetSecondItemPrice()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemPrice));
        String beforeRemoveDollar = driver.findElement(secondItemPrice).getText();
        String afterRemoveDollar = beforeRemoveDollar.replace("$", "");
        return Float.parseFloat(afterRemoveDollar);
    }

    public void AddToCartFirstItemButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartFirstItemButton));
        driver.findElement(addToCartFirstItemButton).click();
    }

    public void AddToCartSecondItemButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSecondItemButton));
        driver.findElement(addToCartSecondItemButton).click();
    }

    public void ClickCartButton()
    {
        driver.findElement(cartButton).click();
    }
}