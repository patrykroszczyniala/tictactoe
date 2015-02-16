Feature: TicTacToe rules

  Scenario: Player 'O' starts the game
    Given new game
    When game has started
    Then player "O" should be active

  Scenario: Player 'X' has a second movement
    Given new game
    When game has started
    And active player made a move
    Then player "X" should be active

  Scenario: Player wins if marks are in horizontal positions
    Given a game with a board
      | _ | o | _ |
      | _ | o | _ |
      | _ | _ | _ |
    When Active player make a move to (1,2)
    Then Active player is the winner
