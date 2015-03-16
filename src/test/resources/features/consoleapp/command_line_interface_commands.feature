Feature: 
  Command-line commands that user can use during application lifecycle
  In order to be able to play the game
  As a user
  I want to use commands that will let me use the application and game

  Scenario: Game should be started after entering 'start' command
    Given command line interface
    And user started the application
    When user entered command start
    Then text should be shown
      """
      Game has been started.
      
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

  Scenario: User should be able to make a move using command 0-8 (eg. 8)
    Given command line interface
    And user started the application
    When user entered command start
    And user entered command 8
    Then text should be shown
      """
      Player 'X' move.
      *****************
      *               *
      *     |   |     *
      *  ---+---+---  *
      *     |   |     *
      *  ---+---+---  *
      *     |   | o   *
      *               *
      *****************
      Enter your directions (0-8): 
      """

  Scenario: After active player move next player should be active
    Given command line interface
    And user started the application
    And user entered command start
    When user entered command 4
    Then player X should be active
    And text should be shown
      """
      Player 'X' move.
      *****************
      *               *
      *     |   |     *
      *  ---+---+---  *
      *     | o |     *
      *  ---+---+---  *
      *     |   |     *
      *               *
      *****************
      Enter your directions (0-8): 
      """

  Scenario: After completed game user is asked to play again
    Given command line interface
    And user started the application
    And users entered commands
      | start |
      | 0     |
      | 3     |
      | 1     |
      | 4     |
      | 2     |
    Then game is completed
    And user is asked "Do you want to play again? (y/n): "

  Scenario: After completed game user can restart game by entering 'y'
    Given command line interface
    And user started the application
    And users entered commands
      | start |
      | 0     |
      | 1     |
      | 3     |
      | 4     |
      | 6     |
    And user is asked "Do you want to play again? (y/n): "
    When user answers "y"
    Then text should be shown
      """
      Game has been started.
      
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

  Scenario: After winning the game, congratulations are shown
    Given command line interface
    And user started the application
    When users entered commands
      | start |
      | 0     |
      | 1     |
      | 3     |
      | 4     |
      | 6     |
    Then text should be shown
      """
      Game finished!
      And the winner is ... O!
      
      Do you want to play again? (y/n): 
      """

  Scenario: Show appropiate information to user if entered wrong command
    Given command line interface
    And user started the application
    When user entered command awesome game
    Then text should be shown
      """
      Unknown command. Enter "help" if you have some troubles...
      To start the game enter "start": 
      """

  Scenario: Show 'revenge' information if game has finished but nobody won
    Given command line interface
    And user started the application
    And users entered commands
      | start |
      | 0     |
      | 3     |
      | 6     |
      | 1     |
      | 2     |
      | 4     |
      | 5     |
      | 8     |
      | 7     |
    Then text should be shown
      """
      Game completed but nobody won...
      Revenge? (y/n): 
      """

  Scenario: User can ask for help in any time
    Given command line interface
    And user started the application
    And user entered command help
    Then text should be shown
      """
      I need help!
      Available commands:
          break - stop current game
          exit - exit the game
          help - show this help

      """

  Scenario: User can not make a move to already used cell
    Given command line interface
    And user started the application
    When users entered commands
      | start |
      | 0     |
      | 0     |
    Then text should be shown
      """
      This position is already used!
      Enter your directions (0-8): 
      """

  Scenario: User should be able to start the application
    Given command line interface
    When user started the application
    Then text should be shown
      """
      Welcome in a Tic-Tac-Toe game!
      To start the game enter "start": 
      """

  @ignore
  Scenario: User should be able to exit the application
    Given command line interface
    When user started the application
    And user entered command exit
    Then text should be shown
      """
      
      "I'll be back" you said... See you and have a nice day!
      """
    And application should be closed
