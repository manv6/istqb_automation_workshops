Feature: E-commerce - Add customer
  As a manager,
  I want to add a new customer,
  So that I can sell products to him/her.


  @web @e-commerce
  Scenario: test steps and page objects
    Given web browser is on e-commerce page
    And navigate to products page
    And add a new product
    And navigate to customers page
    And add a new customer
    And navigate to orders page
    And add a new order


  Scenario: Add product
    Given manager is on e-commerce page
    And navigates to products page
    When adding a product with the below details
      | testProduct | 20.0 |
    Then successful message displayed
    And product is added to listing


