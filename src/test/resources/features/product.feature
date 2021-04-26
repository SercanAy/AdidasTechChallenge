Feature: Product

  @smoke
  Scenario: purchasing a product
    Given the user clicks on "Laptop" category
    And the user clicks on "Sony vaio i5" product
    And the user clicks on Add to cart
    And the user clicks on "Laptop" category
    And the user clicks on "Dell i7 8gb" product
    And the user clicks on Add to cart
    When the user clicks on "Cart" module
    And the user deletes "Dell i7 8gb" product from cart
    And the user clicks on "Place Order" button
    And the user fills all web form fields
    When the user clicks on "Purchase" button
    Then the user should expect "790 USD" amount
    And the user clicks on "OK" button
