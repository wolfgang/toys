Feature: Tic Tac Toe
    Scenario: Display empty board on start
        When I build the program successfully
        When I run the program
        Then I should see:
            """
            . . .
            . . .
            . . .
            """


