@login @ui
Feature: Login

  As a user
  I want to login to the application
  So that I can access my account

  @login @successfullogin
  Scenario: Successful Login
    Given I navigate to the 'Home' page
    When I enter <username> in the 'Username' textbox on the 'Home' page
      | username |
      | standard_user   |
    And I enter <password> in the 'Password' textbox on the 'Home' page
      | password |
      | secret_sauce |
    And I click the 'LOGIN' button on the 'Home' page
    Then the 'Inventory' page is displayed