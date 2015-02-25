Feature: Console application lifecycle
  In order to be able to play the game
  As a user
  I want to start the application and exit in any time

  Scenario: User should be able to start the application
    Given command line interface
    When user started the application
    Then text should be shown
      """
      Welcome in a Tic-Tac-Toe game!
      To start the game enter "start": 
      """

  @ignore
  Scenario: User should be able to exit the application
    Given command line interface
    When user started the application
    And user entered command exit
    Then text should be shown
      """
      
      "I'll be back" you said... See you and have a nice day!
      """
    And application should be closed
