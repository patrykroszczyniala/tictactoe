Feature:  
	User should be able to play with other user on the same computer using two command line dialogs.

Scenario: User should be able to start local server for multiplayer game. 
	Given command line interface 
	And user started the application 
	When user entered command start multiplayer 
	Then text should be shown 
      """
      Multiplayer game has been started.
      Hint! To connect to your game player should:
      - open new command line interface
      - start the application
      - enter command start multiplayer
      
      Waiting for the second player...
      
      """
      
Scenario: User should be able to connect to started multiplayer game. 
	Given command line interface 
	And user started the application 
	And multiplayer game is running 
	And user entered command start multiplayer 
	Then text should be shown 
      """
      Multiplayer game has been started.
      
      Player 'O' move.
      *****************
      *               *
      *     |   |     *
      *  ---+---+---  *
      *     |   |     *
      *  ---+---+---  *
      *     |   |     *
      *               *
      *****************
      Enter your directions (0-8): 
      """