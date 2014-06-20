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

  def handle_input(board) do
    case IO.gets "> " do
      "q\n" -> :quit
      str ->
        [x,y] = Enum.map(String.split(str), &String.to_integer/1)

        row = :lists.nth(x+1, board)
        new_row = List.replace_at(row, y, :x)
        new_board = List.replace_at(board, x, new_row)
        {:ok, new_board}
    end
  end
end
