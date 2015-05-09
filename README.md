# Tic-Tac-Toe [![Build Status](https://travis-ci.org/pepuch/tictactoe.svg?branch=master)](https://travis-ci.org/pepuch/tictactoe)
Java application created to familiarize with BDD using cucumber-jvm. Currently there is only console version of application.

Example game flow:
```
$ java -jar target/tictactoe-1.0-SNAPSHOT-jar-with-dependencies.jar
Welcome in a Tic-Tac-Toe game!
To start the game enter "start": start

Game has been started.

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
Enter your directions (0-8): 0


Player 'X' move.
*****************
*               *
*   o |   |     *
*  ---+---+---  *
*     |   |     *
*  ---+---+---  *
*     |   |     *
*               *
*****************
Enter your directions (0-8):
[...]
```