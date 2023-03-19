Feature: E-commerce webpage

  @RUN
  Scenario: Login to E-commerce webpage
    Given I have the URL of E-commerce webpage
    And I login as User

  @RUN
  Scenario Outline: Validate Add To Cart option
    Given I click on Shop link on Home Page
    And I verify the cart count as <OldCartCount>
#    And I added <Product> to cart
#    And I verify the new cart count as <NewCartCount>
    Examples:
      | OldCartCount | Product          | NewCartCount |
      | 0            | Branded Converse | 1            |