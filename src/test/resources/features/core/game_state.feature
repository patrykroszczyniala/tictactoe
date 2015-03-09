Feature: TicTacToe rules

  Scenario: Player 'O' starts the game
    Given new game
    When game has started
    Then player O should be active

  Scenario: Player 'X' has a second movement
    Given new game
    When game has started
    And active player made a move to 1,1
    Then player X should be active