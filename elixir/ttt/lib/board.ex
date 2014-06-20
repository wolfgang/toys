defmodule Board do
  def display board do
    IO.puts ""
    Enum.map(board, &display_row/1)
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
      :e -> "."
      :x -> "X"
      :o -> "O"
      _ -> ""
    end
  end
end
