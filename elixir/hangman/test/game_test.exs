defmodule GameTest do
  use ExUnit.Case
  import ExUnit.CaptureIO

  test "if given an empty guess, the word display is all dashes and empty galgen" do
    assert output_of_process_guess("", "elixir", [], "") ===
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
    assert output_of_process_guess("i", "elixir", [], "------") ===
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
    assert output_of_process_guess("a", "elixir", [], "------") ===
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
    assert output_of_process_guess("a", "elixir", ["y"], "------") ===
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
    assert output_of_process_guess("b", "elixir", ["a", "y"], "------") ===
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
    assert output_of_process_guess("c", "elixir", ["a", "y", "b"], "-i--ir") ===
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
    assert output_of_process_guess("u", "elixir", ["a", "y", "b", "c"], "-i--ir") ===
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

  test "process_guess returns word progress and misses" do
    capture_io(
               fn ->
                    result1 = Game.process_guess("", "elixir", [])
                    assert  result1 === {"------", []}
                    result2 = Game.process_guess("i", "elixir", [], "------")
                    assert result2 === {"--i-i-", []}
                    result3 = Game.process_guess("y", "elixir", [], "--i-i-")
                    assert result3 === {"--i-i-", ["y"]}
               end)

  end

  defp output_of_process_guess guess, word, misses, progress do
    capture_io(fn -> Game.process_guess(guess, word, misses, progress) end)
  end
  
  

end
