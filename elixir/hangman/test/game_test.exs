defmodule GameTest do
  use ExUnit.Case
  import ExUnit.CaptureIO

  test "if given an empty guess, the word display is all dashes" do
    output = capture_io(fn -> Game.process_guess("", "elixir", []) end)
    assert output ===
      """
   =====|    Word:    ------
   |    |    Guess:   
        |    Misses:  
        |
        |
        |
   ========
"""
  end
  
  test "if given a correct guess, the word display contains the guess + the guess is displayed" do
    output = capture_io(fn -> Game.process_guess("i", "elixir", []) end)
    assert output ===
    """
   =====|    Word:    --i-i-
   |    |    Guess:   i
        |    Misses:  
        |
        |
        |
   ========
"""
  end

  test "if given an incorrect guess for the first time, add the head, add guess to misses" do
    output = capture_io(fn -> Game.process_guess("a", "elixir", []) end)
    assert output ===
      """
   =====|    Word:    ------
   |    |    Guess:   a
   O    |    Misses:  a
        |
        |
        |
   ========
"""
    

  end

  

end
