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
        board2 = Ai.move(board1, (next_player player), &:random.uniform/1)
        {board2, player}
    end
  end

	defp next_player :x do :o end
  defp next_player :o do :x end
end
