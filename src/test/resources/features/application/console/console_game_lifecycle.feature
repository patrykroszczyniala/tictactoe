Feature: TicTacToe console game lifecycle

  Scenario: Console application has been started
    Given console application
    When console application has started
    Then welcome text should be shown
      """
      Welcome in a Tic-Tac-Toe game!
      To start the game enter "start": 
      """

  Scenario: Application has been started
    Given console application
    When user enter start command
    Then game should be started
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
    And empty board should be shown
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | _ |

  Scenario: Game has been started
    Given started game
    When user enter directions to "1,2"
    Then board with a message should be shown
      """
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | o | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: Game has been started 2
    Given started game
    When user enter directions to "1,0"
    Then board with a message should be shown
      """
      | _ | o | _ |
      | _ | _ | _ |
      | _ | _ | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: After active player movement next player should be able to make a movement
    Given started game
    When active player make a movement to (1,1)
    Then Next player should be active
    And board with a message should be shown
      """
      | _ | _ | _ |
      | _ | o | _ |
      | _ | _ | _ |
      Player 'X' move.
      Enter your directions (x,y): 
      """

  Scenario: After completed game user is asked to play again
    Given game
    When game is completed
    Then user is asked to play again

  Scenario: After completed game user can play again
    Given game
    When game is completed
    And user is asked to play again
    And user answers "y"
    Then game should be started
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
    Given game
    When game is completed
    Then Message is shown
      """
      Game finished!
      And the winner is ... O!
      
      Do you want to play again? (y/n): 
      """

  Scenario: Show help message if user entered wrong command
    Given console application
    And console application has started
    When user enter unknown command "awesome game"
    Then Message is shown
    """	
    Unknown command. Enter "help" if you have some troubles...
    To start the game enter "start": 
	"""

  Scenario: Show info if game has completed but nobody won
    Given console application
    When console board is full
    Then Message is shown
    """	
    Game completed but nobody won...
	Revenge? (y/n): 
	"""
	
  Scenario: User can ask for help in any time
    Given console application
    And user enter help command
    Then Message is shown
    """
    I need help!
    Available commands:
        break - stop current game
        exit - exit the game
        help - show this help

	"""
	