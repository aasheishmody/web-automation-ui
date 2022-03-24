@accessibility
Feature: Accessibility

  As a business
  I want my application pages to be accessible
  So that they meet the accessibility standards

  @accessibility
  Scenario Outline: <page> page is accessible as a logged out user
    Given I navigate to the '<page>' page
    Then the '<page>' page is accessible
    Examples:
      | page |
      | Home |

  @accessibility
  Scenario Outline: <page> page is accessible as a logged in user
    Given I navigate to the '<page>' page as a logged in user
      | username      | password     |
      | standard_user | secret_sauce |
    Then the '<page>' page is accessible
    Examples:
      | page      |
      | Inventory |