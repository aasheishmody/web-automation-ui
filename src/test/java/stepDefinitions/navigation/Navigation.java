package stepDefinitions.navigation;

import applicationComponents.pages.HomePage;
import applicationComponents.pages.InventoryPage;
import base.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Navigation implements En {

    public Navigation(TestContext testContext) {

        Given("^I navigate to the 'Home' page$", () -> testContext.applicationComponents.GetInstance(HomePage.class).navigateToHomePage());

        Then("^the 'Inventory' page is displayed$", () -> Assert.assertTrue(testContext.applicationComponents.GetInstance(InventoryPage.class).inventoryPageIsDisplayed()));

        Given("^I navigate to the 'Inventory' page as a logged in user$", (DataTable userCredentials) -> {
            testContext.applicationComponents.GetInstance(HomePage.class).navigateToHomePage();
            List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
            testContext.applicationComponents.GetInstance(HomePage.class).enterUsername(data.get(0).get("username"));
            testContext.applicationComponents.GetInstance(HomePage.class).enterPassword(data.get(0).get("password"));
            testContext.applicationComponents.GetInstance(HomePage.class).clickLoginButton();
        });

        Then("^the 'Home Page' is displayed$", () -> Assert.assertTrue(testContext.applicationComponents.GetInstance(HomePage.class).homePageIsDisplayed()));
    }
}