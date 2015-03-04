Feature: Winner is one of two players who first mark cells on board in horizontal, vertical or diagonal position.

  Scenario: The winner is user who marked column with the same symbols
    Given a game with an empty board
    When players made a moves
      | 0,0 |
      | 1,1 |
      | 0,1 |
      | 2,0 |
      | 0,2 |
    Then board should be equal to
      | o | _ | x |
      | o | x | _ |
      | o | _ | _ |
    And player 'O' is the winner

  Scenario: The winner is user who marked column with the same symbols
    Given a game with an empty board
    When players made a moves
      | 2,0 |
      | 0,0 |
      | 1,1 |
      | 0,1 |
      | 2,2 |
      | 0,2 |
    Then board should be equal to
      | x | _ | o |
      | x | o | _ |
      | x | _ | o |
    And player 'X' is the winner

  Scenario: The winner is user who marked row with the same symbols
    Given a game with an empty board
    When players made a moves
      | 0,1 |
      | 0,0 |
      | 1,1 |
      | 1,0 |
      | 1,2 |
      | 2,0 |
    Then board should be equal to
      | x | x | x |
      | o | o | _ |
      | _ | o | _ |
    And player 'X' is the winner

  Scenario: The winner is user who marked diagonal with the same symbols
    Given a game with an empty board
    When players made a moves
      | 0,1 |
      | 0,0 |
      | 1,0 |
      | 1,1 |
      | 2,0 |
      | 2,2 |
    Then board should be equal to
      | x | o | o |
      | o | x | _ |
      | _ | _ | x |
    And player 'X' is the winner

  Scenario: The winner is user who marked diagonal with the same symbols
    Given a game with an empty board
    When players made a moves
      | 2,0 |
      | 1,0 |
      | 1,1 |
      | 0,1 |
      | 0,2 |
    Then board should be equal to
      | _ | x | o |
      | x | o | _ |
      | o | _ | _ |
    And player 'O' is the winner