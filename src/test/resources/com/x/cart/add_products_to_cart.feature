@cart
Feature: add products to cart
  Add some products to cart
  Required the number of products and the name of products
  #above 2 lines are available for reporting(included by default in html reports)

  #this is a comment,Block comments are currently not supported by Gherkin

  Background:
    Given I have logged into my account

  #
  Example: add 0 product to cart
    here can place descriptions, as long as no line starts with a keyword.
    Given add 0 apple to cart
    When I add the products to cart
    Then I should be told the total price is 0

  Scenario: add multiple products to cart
    Given add 2 apple to cart
    * add 3 pair to cart
    * add 4 peach to cart
    * add 2 grape to cart
    When I add the products to cart
    Then I should be told the total price is not 0

    # "" Doc Strings
  Scenario Outline: add some products to cart
    Given add "<number>" "<product>" to cart
    When I add the products to cart
    Then I should be told the total price is "<amount>"

    #| Data Tables
    Examples:
      |2            |apple|0|
      |3         |pairs|0|
      |8         |banana|0|




