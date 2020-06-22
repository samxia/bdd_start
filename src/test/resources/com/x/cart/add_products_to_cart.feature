#language: en
@cart @add_to_cart
Feature: add products to cart
  Add some products to cart
  Only need  the number of products and the name of products
  #above 2 lines are available for reporting(included by default in html reports)

  #this is a comment,Block comments are currently not supported by Gherkin

  Background:
    #do not consider the stock
    Given The market has the following products:
      |no|name|price|note  |
      |1 |apples|3.00   |haochi|
      |2 |bananas|2.00 |good|
      |3 |pairs  |1.00 |yamei|
      |4 |chairs |2.00   | made in china|
      |5 |peaches |1.0   |fresh          |
      |6 |grapes  |2.5   |new            |

  # Example = Scenario
  Example: add 0 product to cart
    here can place descriptions, as long as no line starts with a keyword.
    #apple here , not apples
    Given I pick up 0 apple
    When I add the products to cart
    Then I should be told the total price is 0

    #to show I know the *, instead of and
  @add_multiple_product
  Scenario: add multiple products to cart
    Given I pick up 2 apples
    #pair here, not pairs
    * I pick up 1 pairs
    * I pick up 4 peaches
    * I pick up 2 grapes
    When I add the products to cart
    Then I should be told the total price is 16.00

  @add_some_products
  Scenario Outline: add some products to cart
    Given I pick up <number> <product_name>
    When I add the products to cart
    Then I should be told the total price is <amount>

    #| Data Tables
    Examples:
      |number |product_name|amount|
      |2      |apples|6.00       |
      |3      |pairs|3.00      |
      |8      |bananas|16.00      |

  Scenario: add a product which does not belong to this market to cart
    Given pick up 10 rices
    When I add the products to cart
    Then I should be told "we do not have rice"

