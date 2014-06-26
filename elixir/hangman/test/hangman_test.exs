defmodule HangmanTest do
  use ExUnit.Case
  import ExUnit.CaptureIO

  test "print initial screen to the console, with N dashes for a word with length N" do
    output = capture_io(fn -> print_initial_screen("1234") end)
    assert output ===
      """
=====|    Word:    ----
|    |    Guess:   
     |    Misses:
     |
     |
     |
========
"""
    
  end

  def print_initial_screen word do
    IO.puts "=====|    Word:    ----"
    IO.puts "|    |    Guess:"
    IO.puts "     |    Misses:"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "========"

  end
  
end
