defmodule Ttt do
  def main(_args) do
    MainLoop.run(
      {[[:e, :e, :e], [:e, :e, :e], [:e, :e, :e]], :x},
      &Board.display/1, 
      &handle_input/1)
  end

  def handle_input({board, player}) do
    case IO.gets "> " do
      "q\n" -> :quit
      str ->
        [x,y] = Enum.map(String.split(str), &String.to_integer/1)

        row = :lists.nth(x+1, board)
        new_row = List.replace_at(row, y, player)
        new_board = List.replace_at(board, x, new_row)
        {new_board, next_player player}
    end
  end

  defp next_player :x do :o end
  defp next_player :o do :x end
end
