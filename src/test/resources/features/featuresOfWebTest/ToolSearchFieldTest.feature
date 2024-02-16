Feature: Search Tools

  Scenario: Verify the Results of Finding Tools by "<toolName>"
    Given a partial tool name (at least three characters): "<toolName>"
    When the user enters "<toolName>" in the search field
    And clicks the search button
    Then the user should see the title of the search results: 'Search Results for: "<toolName>"'
    And each tool listed should contain "<toolName>"

  Scenario Outline: Verify the results of finding tools by invalid "<toolName>"
    Given a invalid tool name (at least three characters): "<toolName>"
    When the user enters "<toolName>" in the search field
    And clicks the search button
    Then the user should see the title of the search results: 'Search Results for: "<toolName>"'
    And no tool is shown on the web page

    Examples:
      | toolName |
      | *&^      |
      | *   9    |
      | 123      |
      |          |

  Scenario Outline: Verify the results of finding tools by invalid (empty, 1, or 2 characters or numbers) "<toolName>"
    Given an invalid tool name: "<toolName>"
    When the user enters "<toolName>" in the search field
    And clicks the search button
    Then the user should see no changes on the web page

    Examples:
      | toolName |
      | *&       |
      | *        |
      | 12       |
      |          |