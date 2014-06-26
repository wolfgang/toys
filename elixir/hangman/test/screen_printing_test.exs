defmodule ScreenPrintingTest do
  use ExUnit.Case
  import ExUnit.CaptureIO

  test "print initial screen to the console, with 4 dashes for a word with length 4" do
    output = capture_io(fn -> Screen.print_initial("1234") end)
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

  test "print initial screen to the conle, with 10 dashes for a word with length 10" do
    output = capture_io(fn -> Screen.print_initial("0123456789") end)
    assert output ===
      """
=====|    Word:    ----------
|    |    Guess:
     |    Misses:
     |
     |
     |
========
"""
 end
  
end
