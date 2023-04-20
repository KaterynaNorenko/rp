Feature: Launches Page tests

  Background:
    Given I open Report Portal for 'local'
    And I am logged into account
    And I verify page title contains text 'Report Portal'

  @smoke
  Scenario Outline: Verify launches dropdown
    Given I go to the Launches Page
    When I press the launches drop-down
    And I choose the '<launchesType>' launches
    Then I verify the '<launchesType>' launches are chosen
    And I verify that there are <launchesNumber> launches in the results
    And I close the browser

    Examples:
      | launchesType | launchesNumber |
      | Latest       | 1              |
      | All          | 5              |
