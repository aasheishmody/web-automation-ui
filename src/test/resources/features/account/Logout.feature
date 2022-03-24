@logout @ui
Feature: Logout

  As a user
  I want to log out
  So that my account is not accessible to others

  @logout
  Scenario: Logout
    Given I navigate to the 'Inventory' page as a logged in user
      | username | password |
      | standard_user   | secret_sauce |
    When I click the 'Menu' button on the 'Inventory' page
    And I click the 'LOGOUT' link on the 'Menu' section
    Then the 'Home Page' is displayed