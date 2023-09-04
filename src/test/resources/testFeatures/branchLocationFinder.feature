@branchLocationFinder
Feature: Branch code locator and print the phone number
  I want to test the scenario to find the phone number based on the post code

  @tagPostCode
  Scenario Outline: Find the phone number from branch details and print the phone number
    Given I want to launch lloyds banking application
    When I want to search the lloyds banking branch with postcode "<data_id>"
    Then I want to filter the first nearest branch
    And I want to print phone number in bdd test resport

    Examples: 
      | tc_id | data_id             |
      | tc_01 | postcode.postcode1  |
      | tc_02 | postcode.postcode2  |
      | tc_03 | postcode.postcode3  |
      | tc_04 | postcode.postcode4  |
      | tc_05 | postcode.postcode5  |
      | tc_06 | postcode.postcode6  |
      | tc_07 | postcode.postcode7  |
      | tc_08 | postcode.postcode8  |
      | tc_09 | postcode.postcode9  |
      | tc_10 | postcode.postcode10 |
