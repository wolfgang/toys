@no-clobber
Feature: Basic board rendering and player moves
    Scenario: Build the program
        When I build the program
        Then The exit status should be "0"

    @Ignore
    Scenario: Run: Display empty board and quit when entering 'q'
        When I run the program
        When I enter "q"
        Then The final output should match:
            """
            - - -
            - - -
            - - -
            """

    Scenario: Make a move as X at 0-0, then AI makes a move as O somewhere, then quit
        When I run the program
        When I enter "0 0"
        When I enter "q"
        Then The last board should contain 1 O and otherwise match:
            """
            X . .
            . . .
            . . .
            """

