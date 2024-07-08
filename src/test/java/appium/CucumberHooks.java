package appium;

import appium.testcases.LoginSuccess;
import io.cucumber.java.*;

public class CucumberHooks
{
    @BeforeAll
    public static void SetUp()
    {
        LoginSuccess.SetUp();
    }

    @AfterAll
    public static void TearDown()
    {
        LoginSuccess.TearDown();
    }
}