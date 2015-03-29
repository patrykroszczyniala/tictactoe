Feature: User should be able to see board with cells indexes

  Scenario: Board indexes should be enabled after entering 'hint' command and board with hints should be shown if game has been started
    Given command line interface
    And user started the application
    When users entered commands
      | start |
      | hint  |
    Then text should be shown
      """
      Player 'O' move.
      *****************
      *               *
      *   0 | 1 | 2   *
      *  ---+---+---  *
      *   3 | 4 | 5   *
      *  ---+---+---  *
      *   6 | 7 | 8   *
      *               *
      *****************
      Enter your directions (0-8): 
      """

  Scenario: 'hint' command should turn on and off hints alternately
    Given command line interface
    And user started the application
    When users entered commands
      | start |
      | hint  |
      | hint  |
    Then text should be shown
      """
      Player 'O' move.
      *****************
      *               *
      *     |   |     *
      *  ---+---+---  *
      *     |   |     *
      *  ---+---+---  *
      *     |   |     *
      *               *
      *****************
      Enter your directions (0-8): 
      """

  Scenario: Message that indexes has been shown should be displayed if game hasn't been started and user entered command 'hint'
    Given command line interface
    And user started the application
    When user entered command hint
    Then text should be shown
      """
      Indexes hints enabled
      To start the game enter "start": 
      """

  Scenario: Message that indexes hints has been disabled should be displayed if game hasn't been started and user entered command 'hint'
    Given command line interface
    And user started the application
    When users entered commands
      | hint |
      | hint |
    Then text should be shown
      """
      Indexes hints disabled
      To start the game enter "start": 
      """
