Feature: TicTacToe rules

Scenario: Board state equals to users move 
	Given a game with an empty board
	When player made a move to (0,0)
	Then board should be equal to
	| o | _ | _ | 
	| _ | _ | _ | 
	| _ | _ | _ |
	
Scenario: Board state equals to users move
	Given a game with a board
	| _ | o | _ | 
	| _ | _ | _ | 
	| _ | _ | _ |
	When player made a move to (2,1)
	Then board should be equal to
	| _ | o | _ | 
	| _ | _ | o | 
	| _ | _ | _ |
	
Scenario: User can't move to already used cell
	Given a game with a board
	| _ | _ | _ | 
	| _ | _ | o | 
	| _ | _ | _ |
	When player made a move to (2,1)
	Then error should be shown "This position is already used!"