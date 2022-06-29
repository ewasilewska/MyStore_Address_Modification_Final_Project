Feature: Adding New Address

  Scenario Outline: User can add New Address

    Given I'm logged in on MyStore page
    When I click Create new address button
    And I provide firstname <firstname> lastname <lastname> alias <alias> address <address> city <city> postcode <postcode> country <country> phone <phone>
    Then I can see success message with text "Address successfully added!"
    And I can see correct firstname "<firstname>"
    And correct lastname "<lastname>"
    And correct address "<address>"
    And correct city "<city>"
    And correct postcode "<postcode>"
    And correct phone "<phone>"

    Examples:
  | firstname | lastname| alias | address | city | postcode | country       | phone    |
  |Ewa        |Kowalska | Ewka  | Ziemska | Elk  | 80-987   | United Kingdom| 509124871|
