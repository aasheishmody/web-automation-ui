package stepDefinitions.hooks;


import base.DriverFactory;
import base.TestContext;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class Hooks implements En {

    public Hooks(TestContext testContext) {

        Before((Scenario scenario) -> {
            testContext.scenario = scenario;
        });

        AfterStep((Scenario scenario) -> {
            WebDriver augmentedDriver = new Augmenter().augment(DriverFactory.getDriver());
            byte[] screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpeg", DriverFactory.getDriver().getCurrentUrl());
        });

        After(() ->
            DriverFactory.getDriver().manage().deleteAllCookies()
        );
    }
}