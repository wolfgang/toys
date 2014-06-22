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
        board1 = Board.set(board, x, y, player)
				{ai_x,ai_y} = Ai.get_move board1
				board2 = Board.set(board1, ai_x, ai_y, next_player player)
        {board2, player}
    end
  end

	defp next_player :x do :o end
  defp next_player :o do :x end
end
