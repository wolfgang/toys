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
    output = capture_io(fn -> Game.process_guess("i", "elixir", [], "------") end)
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
    output = capture_io(fn -> Game.process_guess("a", "elixir", [], "------") end)
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
  
  test "if given an incorrect guess for the second time, add let torso" do
    output = capture_io(fn -> Game.process_guess("a", "elixir", ["y"], "------") end)
    assert output ===
      """
   =====|    Word:    ------
   |    |    Guess:   a
   O    |    Misses:  y,a
  (     |
        |
        |
   ========
"""
  end
  
  test "if given an incorrect guess for the third time, add right torso" do
    output = capture_io(fn -> Game.process_guess("b", "elixir", ["a", "y"], "------") end)
    assert output ===
      """
   =====|    Word:    ------
   |    |    Guess:   b
   O    |    Misses:  a,y,b
  ( )   |
        |
        |
   ========
"""
  end
  
  test "if given an incorrect guess for the 4th time, add left leg" do
    output = capture_io(fn -> Game.process_guess("c", "elixir", ["a", "y", "b"], "-i--ir") end)
    assert output ===
      """
   =====|    Word:    -i--ir
   |    |    Guess:   c
   O    |    Misses:  a,y,b,c
  ( )   |
  /     |
        |
   ========
"""
  end

  test "if given an incorrect guess for the 5th time, add right leg" do
    output = capture_io(
                        fn ->
                             Game.process_guess("u", "elixir", ["a", "y", "b", "c"], "-i--ir")
                        end)
    assert output ===
      """
   =====|    Word:    -i--ir
   |    |    Guess:   u
   O    |    Misses:  a,y,b,c,u
  ( )   |
  / |   |
        |
   ========
"""
  end

  
  
  

end
