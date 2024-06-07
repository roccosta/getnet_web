Feature: GetNet Website Test

  Scenario: Search for Boleto
    Given the user is on the GetNet homepage
    When he navigate to the Help Center
    And search for "Boleto"
    And select the search result "Eu concluí a negociação, de que forma receberei meu boleto?"
    Then he should see the modal with the explanation text

  Scenario: Search for Conta
    Given the user is on the GetNet homepage
    When he navigate to the Help Center
    And search for "Conta"
    And select the search result "Posso ter um cartão com a minha Conta?"
    Then he should see the modal with the explanation text
