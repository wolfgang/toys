@no-clobber
Feature: Basic board rendering and player moves
    Scenario: Build the program
        When I build the program
        Then The exit status should be "0"

    Scenario: Run: Display empty board and quit when entering 'q'
        When I run the program
        When I enter "q"
        Then The final output should match:
            """
            - - -
            - - -
            - - -
            """

    Scenario: Make a move as X at 2-2 then quit
        When I run the program
        When I enter "2 2"
        When I enter "q"
        Then The final output should match:
            """
            - - -
            - - -
            - - -
            .* 
            - - -
            - O -
            - - X
            """

    Scenario: Make a move as X at 1-0 then quit
        When I run the program
        When I enter "1 0"
        When I enter "q"
        Then The final output should match:
            """
            - - -
            - - -
            - - -
            .* 
            - - -
            X O -
            - - -
            """

    Scenario: Make a move as X at 0-0 then AI makes a move as 0 at 1 1 then quit
        When I run the program
        When I enter "0 0"
        When I enter "q"
        Then The last board should contain 1 X and 1 O

