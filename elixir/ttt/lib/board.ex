defmodule Board do
  def display board do
    IO.puts ""
    Enum.map(board, &display_row/1)
  end

  def set board, x, y, player do
    row = :lists.nth(x+1, board)
    new_row = List.replace_at(row, y, player)
    List.replace_at(board, x, new_row)
  end

  def get board, x, y do
    row = :lists.nth(x+1, board)
		:lists.nth(y+1, row)
	end

	defp display_row row do
     Enum.map(
      1..3, 
      fn index ->
        IO.write display_string(:lists.nth(index, row))
        if index < 3 do
          IO.write " "
        end
      end)
      IO.puts ""
  end

  defp display_string elem do
    case elem do
      :e -> "-"
      :x -> "X"
      :o -> "O"
      _ -> ""
    end
  end
end
