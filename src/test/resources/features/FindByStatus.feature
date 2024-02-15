Feature: Find Pets by Status

#  positive tests
  Scenario Outline: Verify finding pets with status "<status>" in the store
    Given there are pets "<status>" in the store
    When the user requests to find pets "<status>" in the store using a GET request
    Then the response status code should be 200
    And the response body should contain pets with status "<status>"

    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |

# negative tests
  Scenario Outline: Verify finding pets with an invalid status "<status>"
    Given an invalid "<status>" is provided
    When the user requests to find pets "<status>" using a GET request
    Then the response status code should be 200
    And the response body should be empty

    Examples:
      | status       |
      | out of stock |
      | 123445554    |
      | !@##$%%^&**  |