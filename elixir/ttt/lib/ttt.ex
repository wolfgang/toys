defmodule Ttt do
  def main(_args) do
    MainLoop.run(
      [[:e, :e, :e], [:e, :e, :e], [:e, :e, :e]],
      &Board.display/1, 
      &handle_input/1)
  end

  def display_board(board) do
    Enum.map board, &IO.puts/1
  end

  def handle_input(_board) do
    case IO.gets "> " do
      "q\n" -> :quit
      _ -> {:ok, [[:e, :e, :e], [:e, :x, :e], [:e, :e, :e]]}
    end
  end
end
