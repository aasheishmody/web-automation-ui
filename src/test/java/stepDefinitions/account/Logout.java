package stepDefinitions.account;

import applicationComponents.pages.InventoryPage;
import applicationComponents.sections.MenuSection;
import base.TestContext;
import io.cucumber.java8.En;

public class Logout implements En {

    public Logout(TestContext testContext) {

        And("^I click the 'Menu' button on the 'Inventory' page$", () -> testContext.applicationComponents.GetInstance(InventoryPage.class).clickMenuButton());
        And("^I click the 'LOGOUT' link on the 'Menu' section$", () -> testContext.applicationComponents.GetInstance(MenuSection.class).clickLogoutLink());
    }
}
