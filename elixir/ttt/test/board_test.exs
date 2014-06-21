defmodule BoardTest do
  use ExUnit.Case

  import ExUnit.CaptureIO

  test "display empty board" do
    output = capture_display [[:e, :e, :e], [:e, :e, :e], [:e, :e, :e]]
    assert output == "\n- - -\n- - -\n- - -\n"
  end

  test "display board with Xs and Os" do
    output = capture_display [[:e, :x, :o], [:x, :x, :e], [:x, :e, :o]]
    assert output == "\n- X O\nX X -\nX - O\n"
  end

  test "set a field" do
    board = [[:e, :e, :e], [:e, :e, :e], [:e, :e, :e]]
    board1 = Board.set(board, 1, 0, :x)
    assert board1 == [[:e, :e, :e], [:x, :e, :e], [:e, :e, :e]]
  end

  defp capture_display board do
    capture_io(fn -> Board.display(board) end)
  end

end
 
