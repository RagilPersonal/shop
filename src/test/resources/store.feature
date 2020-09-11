Feature: Store Service
  Scenario: client makes call to GET Store passing Id
    When the client calls to get store with Store Id "104"
    Then the client receives store with Id "104" and name "FirstStore_4"
    And the client receives proper response code