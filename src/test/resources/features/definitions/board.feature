Feature: Board is a 3x3 grid where players can make a moves / mark cells

  Scenario: Board is a 3x3 grid
    Given a game with an empty board
    Then board should be equal to
      | _ | _ | _ |
      | _ | _ | _ |
      | _ | _ | _ |
      
  Scenario: Player can mark a cell on board
    Given a game with an empty board
    When active player made a move to 1,1
    Then board should be equal to
      | _ | _ | _ |
      | _ | o | _ |
      | _ | _ | _ |
      
      