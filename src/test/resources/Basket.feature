@nk
Feature: Basket-user story for basket functionality
  As an end user
  I want to add a product to basket
  So that i buy products

  Scenario: add product to basket
    Given I am on the home page
    When I search for a product "nike"
    And I select any product
    And I add the product to the basket
    Then the product should be in the basket