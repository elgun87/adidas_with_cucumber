@smoke
Feature: Phone Category Items
  Background:
    Given user open url "https://www.demoblaze.com/index.html"
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    Then user click on final login button

  Scenario: Verify all items Under Phone Category
    When user click on "Phones"
    Then user can view items under items as showen below:
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |
      | Nexus 6           |
      | Samsung galaxy s7 |
      | Iphone 6 32gb     |
      | Sony xperia z5    |
      | HTC One M9        |


  Scenario: Verify all items Under Laptops Category
    When user click on "Laptops"
    Then user can view items under items as showen below:
      | Sony vaio i5        |
      | Sony vaio i7        |
      | MacBook air         |
      | Dell i7 8gb         |
      | 2017 Dell 15.6 Inch |
      | MacBook Pro         |

  Scenario: Verify all items Under Monitors Category
    When user click on "Monitors"
    Then user can view items under items as showen below:
      | Apple monitor 24    |
      | ASUS Full HD        |


