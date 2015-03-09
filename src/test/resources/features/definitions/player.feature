Feature: Player is a person who can make a moves during the game

  Scenario: Player can make a move during the game
    Given a game with an empty board
    When active player made a move to 0,2
    Then board should be equal to
      | _ | _ | _ |
      | _ | _ | _ |
      | o | _ | _ |
      
  Scenario: Player can mark a cell on board
    Given a game with an empty board
    When players made a moves
    | 0,0 |
    | 0,1 |
    Then board should be equal to
      | o | _ | _ |
      | x | _ | _ |
      | _ | _ | _ |