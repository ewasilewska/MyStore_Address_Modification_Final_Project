Feature: Deleting New Address

  Scenario: User can delete the Address

    Given I'm logged in MyStore page and I'm in address section
    When I click Delete button under chosen address
    Then I remove the address and I see success message with text "Address successfully deleted!"

