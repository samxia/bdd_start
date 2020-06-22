Feature: take the product out from cart

  Scenario: take a product out from cart when the cart is empty
    Given the cart is empty
    When take a product out from cart
    Then the answer should be "Nope"

    Scenario: take a product out from cart when the cart is not empty
      Given the cart is not empty
      When take a product out from cart
      Then the answer should be "ok"
      And the total price should not be 0

      Scenario:take all the products from cart
        Given the cart is not empty
        When take all the products from cart
        Then the totoal price should be 0