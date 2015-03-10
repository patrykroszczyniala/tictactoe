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

  Scenario: Already used cell can not be used anymore
    Given a game with a board
      | _ | _ | _ |
      | _ | _ | o |
      | _ | _ | _ |
    When active player made a move to 2,1
    Then error should be returned "This position is already used!"

  Scenario: Board is filled if every cell is marked
    Given a game with a board
      | o | o | x |
      | x | x | o |
      | o | x | _ |
    When active player made a move to 2,2
    Then board is full

  Scenario: Board state responds to users positions
    Given a game with a board
      | _ | o | _ |
      | _ | _ | _ |
      | _ | _ | _ |
    When active player made a move to 2,1
    Then board should be equal to
      | _ | o | _ |
      | _ | _ | o |
      | _ | _ | _ |
