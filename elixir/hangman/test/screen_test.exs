defmodule ScreenTest do
  use ExUnit.Case
  import ExUnit.CaptureIO

  test "given empty misses, display only the galgen" do
    output = capture_io(fn -> Screen.display "-----", "", [] end)
    assert output ===
      """
   =====|    Word:    -----
   |    |    Guess:   
        |    Misses:  
        |
        |
        |
   ========
"""

  end
  
end