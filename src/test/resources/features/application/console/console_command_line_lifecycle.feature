Feature: TicTacToe console application lifecycle

  Scenario: Welcome text should be shown after starting application
    Given command line interface
    When user started the application
    Then text should be shown
      """
      Welcome in a Tic-Tac-Toe game!
      To start the game enter "start": 
      """

  Scenario: User should be able to make a move after starting the game
    Given command line interface
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
    And board should be shown
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | _ |

  Scenario: Board with a pawn at 1,2 should be shown after users move to 1,2
    Given command line interface
    And user entered command start
    When user entered command 1,2
    Then text should be shown
      """
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | o | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: Board with a pawn at 1,0 should be shown after users move to 1,0
    Given command line interface
    And user entered command start
    When user entered command 1,0
    Then text should be shown
      """
      | _ | o | _ |
      | _ | _ | _ |
      | _ | _ | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: After active player movement next player should be active
    Given command line interface
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
    When game is completed
    Then user is asked "Do you want to play again? (y/n): "

  Scenario: After completed game user can restart game by entering 'y'
    Given command line interface
    When game is completed
    And user is asked "Do you want to play again? (y/n): "
    And user answers "y"
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

  Scenario: After completed game congratulations are shown
    Given command line interface
    When game is completed
    Then text should be shown
      """
      Game finished!
      And the winner is ... O!
      
      Do you want to play again? (y/n): 
      """

  Scenario: Show 'unknown command' message if user entered wrong command
    Given command line interface
    And user started the application
    When user enter unknown command "awesome game"
    Then text should be shown
      """
      Unknown command. Enter "help" if you have some troubles...
      To start the game enter "start": 
      """

  Scenario: Show 'revenge' information if game has completed but nobody won
    Given command line interface
    When console board is full
    Then text should be shown
      """
      Game completed but nobody won...
      Revenge? (y/n): 
      """

  Scenario: User can ask for help in any time
    Given command line interface
    And user enter help command
    Then text should be shown
      """
      I need help!
      Available commands:
          break - stop current game
          exit - exit the game
          help - show this help

      """
