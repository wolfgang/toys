@no-clobber
Feature: Tic Tac Toe
    Scenario: Build the program
        When I build the program
        Then The exit status should be "0"

    Scenario: Run: Display empty board and quit when entering 'q'
        When I run the program
        When I enter "q"
        Then I should see:
            """
            . . .
            . . .
            . . .
            >
            """

    Scenario: Display make a move then quit
        When I run the program
        When I enter "1 1"
        When I enter "q"
        Then I should see:
            """
            . . .
            . . .
            . . .
            > 
            . . .
            . X .
            . . .
            >
            """



