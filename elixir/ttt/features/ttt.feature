@no-clobber
Feature: Tic Tac Toe
    Scenario: Build the program
        When I build the program
        Then The exit status should be "0"

    Scenario: Run: Display empty board and quit when entering 'q'
        When I run the program
        When I enter "q"
        Then The final output should match:
            """
            . . .
            . . .
            . . .
            >.*
            """

    Scenario: Make a move as X at 1-1 then quit
        When I run the program
        When I enter "1 1"
        When I enter "q"
        Then The final output should match:
            """
            . . .
            . . .
            . . .
            >.*. . .
            . X .
            . . .
            >.*
            """


    @ignore
    Scenario: Make a move as X at 0-0 then quit
        When I run the program
        When I enter "0 0"
        When I enter "q"
        Then The final output should match:
            """
            . . .
            . . .
            . . .
            >.* X . .
            . . .
            . . .
            >.*
            """


