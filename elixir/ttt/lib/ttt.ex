defmodule Ttt do
  def main(_args) do
    MainLoop.run(
      [". . .", ". . .", ". . ."], 
      &display_board/1, 
      &handle_input/1)
  end

  def display_board(board) do
    Enum.map board, &IO.puts/1
  end

  def handle_input(_board) do
    case IO.gets "> " do
      "q\n" -> :quit
      _ -> {:ok, [". . .", ". X .", ". . ."]}
    end
  end
end
