package stepDefinitions.accessibility;

import base.DriverFactory;
import base.TestContext;
import com.deque.axe.AXE;
import io.cucumber.java8.En;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.ConfigFileReader;

import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Accessibility implements En {

    private static final URL scriptUrl = Accessibility.class.getResource("/axe.min.js");

    public Accessibility(TestContext testContext) {
        Then("the {string} page is accessible", (String page) -> {
            AXE.inject(DriverFactory.getDriver(), scriptUrl);
            JSONObject responseJSON;
            switch (ConfigFileReader.getInstance().getAccessibilityStandard()) {
                case WCAG2LevelA:
                    responseJSON = new AXE.Builder(DriverFactory.getDriver(), scriptUrl).options("{runOnly: ['wcag2a']}").analyze();
                    break;
                case WCAG2LevelAA:
                    responseJSON = new AXE.Builder(DriverFactory.getDriver(), scriptUrl).options("{runOnly: ['wcag2aa']}").analyze();
                    break;
                case WCAG21LevelA:
                    responseJSON = new AXE.Builder(DriverFactory.getDriver(), scriptUrl).options("{runOnly: ['wcag21a']}").analyze();
                    break;
                case WCAG21LevelAA:
                    responseJSON = new AXE.Builder(DriverFactory.getDriver(), scriptUrl).options("{runOnly: ['wcag21aa']}").analyze();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ConfigFileReader.getInstance().getAccessibilityStandard());
            }
            JSONArray violations = responseJSON.getJSONArray("violations");
            if (violations.length() == 0) {
                assertTrue("No violations found", true);
            } else {
                AXE.writeResults(System.getProperty("accessibility"), responseJSON);
                fail(AXE.report(violations));
            }
        });
    }
}