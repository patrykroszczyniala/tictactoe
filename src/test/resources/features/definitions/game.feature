Feature: Tic-tac-toe is a game where two players can play on a 3x3 board. Player who first mark column, row or diagonal with the same symbols is a winner.

  Scenario: Two players can play tic-tac-toe game
    Given a game with an empty board
    When players made a moves
    | 0,0 |
    | 0,1 |
    Then board should be equal to
      | o | _ | _ |
      | x | _ | _ |
      | _ | _ | _ |