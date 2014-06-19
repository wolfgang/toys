#encoding: utf-8
Feature: Call wc from the commandline
   Scenario: Count the words when run with -w
        When I build wc successfully
        When I create a file "/tmp/test.txt" with contents "w1 w2.w3"
        Then "./wc -w /tmp/test.txt" outputs "3 /tmp/test.txt"
    Scenario: Count the lines when run with -l
        When I build wc successfully
        When I create a file "/tmp/test.txt" with contents "this is line1.this is line2"
        Then "./wc -l /tmp/test.txt" outputs "2 /tmp/test.txt"
     Scenario: Count the lines and words when run with no switch
        When I build wc successfully
        When I create a file "/tmp/test.txt" with contents "this is line1.this is line2"
        Then "./wc /tmp/test.txt" outputs "2 6 /tmp/test.txt"
 
