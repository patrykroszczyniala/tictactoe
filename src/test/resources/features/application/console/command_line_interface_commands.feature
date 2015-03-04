Feature: Command-line commands that user can use during application lifecycle
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
      Player 'O' starts the game.
      
      Current board:
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | _ |
      Player 'O' move.
      Enter your directions (x,y): 
      """

  Scenario: User should be able to make a move using command x,y (eg. 2,2)
    Given command line interface
    And user started the application
    When user entered command start
    And user entered command 2,2
    Then text should be shown
      """
      Current board:
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | o |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: After active player move next player should be active
    Given command line interface
    And user started the application
    And user entered command start
    When user entered command 1,1
    Then player X should be active
    And text should be shown
      """
      | _ | _ | _ |
      | _ | o | _ |
      | _ | _ | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: After completed game user is asked to play again
    Given command line interface
    And user started the application
    And users entered commands
      | start |
      | 0,0   |
      | 1,0   |
      | 0,1   |
      | 1,1   |
      | 0,2   |
    Then game is completed
    And user is asked "Do you want to play again? (y/n): "

  Scenario: After completed game user can restart game by entering 'y'
    Given command line interface
    And user started the application
    And users entered commands
      | start |
      | 0,0   |
      | 1,0   |
      | 0,1   |
      | 1,1   |
      | 0,2   |
    And user is asked "Do you want to play again? (y/n): "
    When user answers "y"
    Then text should be shown
      """
      Game has been started.
      Player 'O' starts the game.
      
      Current board:
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | _ |
      Player 'O' move.
      Enter your directions (x,y): 
      """

  Scenario: After winning the game, congratulations are shown
    Given command line interface
    And user started the application
    When users entered commands
      | start |
      | 0,0   |
      | 1,0   |
      | 0,1   |
      | 1,1   |
      | 0,2   |
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
      | 0,0   |
	  | 0,1   |
	  | 0,2   |
	  | 1,0   |
	  | 2,0   |
	  | 1,1   |
	  | 2,1   |
	  | 2,2   |
	  | 1,2   |
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
      | 0,0   |
      | 0,0   |
    Then text should be shown
      """
      This position is already used!
      Enter your directions (x,y): 
      """
