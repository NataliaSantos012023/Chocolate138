# #language: pt
#  Funcionalidade: Selecionar produto na loja
#    Cenario: Selecionar Produto com sucesso
#      Dado que acesso a loja SauceDemo
#      Quando preencho o usuário e senha
#      E clico em Login
#      Entao exibe o titulo da pagina com "Products"
#      E exibe o link do carrinho de compras
#      Quando clico no produto "Sauce Labs Backpack"

  Feature: Select Product in Store
    Scenario: Selecting Product with Success
      Given I access SauceDemo store
      When I filled a user "standard_user" and password "secret_sauce"
      And I click in Login
      Then I verify the page's title "Products"
      And show cart's link
      When I click in product "4"
      Then I verify the product title "Sauce Labs Backpack"
      And I verify the product price "$29.99"
      When I click in add to cart
      And I click in Cart icon
      Then I verify the page's title "Your Cart"
      And I verify the product title "Sauce Labs Backpack" in cart
      And I verify the quantity is "1"
      And I verify the product price "$29.99" in cart



  Scenario Outline: Selecting Product with Success DDT
    Given I access SauceDemo store
    When I filled a user <user> and password <password>
    And I click in Login
    Then I verify the page's title "Products"
    And show cart's link
    When I click in product <productId>
    Then I verify the product title <productTitle>
    And I verify the product price <productPrice>
    When I click in add to cart
    And I click in Cart icon
    Then I verify the page's title "Your Cart"
    And I verify the product title <productTitle> in cart
    And I verify the quantity is "1"
    And I verify the product price <productPrice> in cart
    Examples:
      | user                      | password       | productId | productTitle            | productPrice |
      | "standard_user"           | "secret_sauce" |     "4"   | "Sauce Labs Backpack"   | "$29.99"     |
      | "performance_glitch_user" | "secret_sauce" |     "0"   | "Sauce Labs Bike Light" | "$9.99"      |



