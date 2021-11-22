Feature: Can we get an empty list?
  Service must return lists of pets based on status provided.
  Service will be tested both with a real service and with a mocked version of the service.

  Scenario: Request pets with a non-existent status.
    Given I have 100 in my wallet
    When Service is requested for a "nonexistent" status
    Then A result with 0 pets is returned by the service
