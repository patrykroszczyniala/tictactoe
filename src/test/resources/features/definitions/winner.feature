Feature: Winner is a player who first mark cells on board in a horizontal, vertical or diagonal position.

  Scenario: The winner is user who marked column with the same symbols
    Given a game with an empty board
    When players made a moves
      | 0 |
      | 4 |
      | 3 |
      | 2 |
      | 6 |
    Then board should be equal to
      | o | _ | x |
      | o | x | _ |
      | o | _ | _ |
    And player 'O' is the winner

  Scenario: The winner is user who marked column with the same symbols
    Given a game with an empty board
    When players made a moves
      | 2 |
      | 0 |
      | 4 |
      | 3 |
      | 8 |
      | 6 |
    Then board should be equal to
      | x | _ | o |
      | x | o | _ |
      | x | _ | o |
    And player 'X' is the winner

  Scenario: The winner is user who marked row with the same symbols
    Given a game with an empty board
    When players made a moves
      | 3 |
      | 0 |
      | 4 |
      | 1 |
      | 7 |
      | 2 |
    Then board should be equal to
      | x | x | x |
      | o | o | _ |
      | _ | o | _ |
    And player 'X' is the winner

  Scenario: The winner is user who marked diagonal with the same symbols
    Given a game with an empty board
    When players made a moves
      | 3 |
      | 0 |
      | 1 |
      | 4 |
      | 2 |
      | 8 |
    Then board should be equal to
      | x | o | o |
      | o | x | _ |
      | _ | _ | x |
    And player 'X' is the winner

  Scenario: The winner is user who marked diagonal with the same symbols
    Given a game with an empty board
    When players made a moves
      | 2 |
      | 1 |
      | 4 |
      | 3 |
      | 6 |
    Then board should be equal to
      | _ | x | o |
      | x | o | _ |
      | o | _ | _ |
    And player 'O' is the winner