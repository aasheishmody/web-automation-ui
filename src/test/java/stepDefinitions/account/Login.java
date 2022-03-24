package stepDefinitions.account;

import applicationComponents.pages.HomePage;
import base.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

public class Login implements En {



    public Login(TestContext testContext) {

        When("^I enter <username> in the 'Username' textbox on the 'Home' page$", (DataTable username) -> {
            List<Map<String, String>> data = username.asMaps(String.class, String.class);
            testContext.applicationComponents.GetInstance(HomePage.class).enterUsername(data.get(0).get("username"));
        });

        When("^I enter <password> in the 'Password' textbox on the 'Home' page$", (DataTable password) -> {
            List<Map<String, String>> data = password.asMaps(String.class, String.class);
            testContext.applicationComponents.GetInstance(HomePage.class).enterPassword(data.get(0).get("password"));
        });

        And("^I click the 'LOGIN' button on the 'Home' page$", () -> testContext.applicationComponents.GetInstance(HomePage.class).clickLoginButton());
    }
}
