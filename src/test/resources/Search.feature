
Feature: search product-Name of user story
  As a customer
  I want to search for a product
  So that i can add product to the basket


  Background:
    Given I am on the home page
  Scenario: postive test for search
#    Given I am on the home page
    When I search for a product "puma"
    Then I should to see respective results


  Scenario Outline: Data-driven test for search
#    Given I am on the home page
    When I search for a product "<items>"
    Then I should to see respective results

    Examples:
    | items |
    |nike |
    |puma |
    |reebok|